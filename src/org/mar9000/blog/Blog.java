/**
 * This file is part of mar9000's blog.
 * 
 * mar9000's blog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * mar9000's blog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with mar9000's blog.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright 2011-2014 Marco LOMBARDO.
 */
package org.mar9000.blog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.mar9000.blog.grammar.BlogLexer;
import org.mar9000.blog.grammar.BlogParser;
import org.mar9000.blog.grammar.BlogParser.PostContext;
import org.pegdown.PegDownProcessor;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STRawGroupDir;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

public class Blog {
	
	public static final String MARKDOWN = ".md";
	public static final String EXTENSIONS = ".post,.html," + MARKDOWN;
	public static final String TEMPLATE_EXTENSION = ".st";
	public static final String TEMPLATES = "/templates";
	public static final String WEB_TEMPLATE = "/web-template";
	public static final String POSTS = "/posts";
	public static final String WEB_GEN = "/web-gen";
	public static final String HEADER = "header.html";
	public static final String FOOTER = "footer.html";
	public static final int NUMBER_POSTS_ON_INDEX = 7;
	
	public static final String FEED_TYPE = "atom_1.0";
	public static final String FEED_FILENAME= "posts.atom";
	
	private static String baseDirPath = null;
	private static String header = null;
	private static String footer = null;
	private static ArrayList<Post> posts = new ArrayList<Post>();
	private static HashMap<String, ArrayList<Post>> tags = new HashMap<String, ArrayList<Post>>();

	public static void main(String[] args) {
		// First arguments is mandatory and is the path containing the project.
		if (args.length == 0) {
			System.err.println("Missing parameter with the path to the project.");
		} else {
			baseDirPath = args[0];
			try {
				// Check baseDirPath is a directory.
				File baseDir = new File(baseDirPath);
				if (!baseDir.isDirectory()) {
					System.out.println("Passed parameter should be a directory.");
					return;
				}
				// Load files to be rendered in each template.
				header = readFileAsString(baseDirPath + TEMPLATES + "/" + HEADER);
				footer = readFileAsString(baseDirPath + TEMPLATES + "/" + FOOTER);
				// Process posts.
				System.out.println("Source dir. is " + baseDirPath + POSTS);
				System.out.println("Target dir. is " + baseDirPath + WEB_GEN + "\n");
				processPosts(args[0] + POSTS, baseDirPath + WEB_GEN + "/bliki");
				Collections.sort(posts, new Comparator<Post>() {
					@Override
					public int compare(Post p1, Post p2) {
						// Sort in descending order.
						return p1.getDate().compareTo(p2.getDate()) * -1;
					}
				});
				// Process index.st and other basic ST files.
				processSTTemplates(baseDirPath + TEMPLATES, baseDirPath + WEB_GEN);
				// Create tag pages.
				createTagsPages();
				// Create atom file.
				createAtom();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	private static String readFileAsString(String filePath) throws IOException {
		StringBuffer fileData = new StringBuffer();
		BufferedReader reader = new BufferedReader(
				new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead=0;
		while((numRead=reader.read(buf)) != -1){
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
		}
		reader.close();
		return fileData.toString();
	}
	
	private static String processPosts(String postsDirPath, String webDirPath) throws IOException{
		String message = "OK";
		try {
			File postsDir = new File(postsDirPath);
			if (!postsDir.isDirectory()) {
				return "Path should be a directory.";
			}
			File[] files = postsDir.listFiles();
			for (int f = 0; f < files.length; f++) {
				File file = files[f];
				if (file.isDirectory()) {
					System.out.println("\nProcess subdir. " + file.getName());
					processPosts(file.getAbsolutePath(), webDirPath + "/" + file.getName());
				} else if (EXTENSIONS.indexOf(file.getName().substring(file.getName().lastIndexOf("."))) != -1) {
					processPost(file, webDirPath);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}

	private static void processPost(File post, String webDirPath) throws IOException, ParseException {
		System.out.print("Process: " + post.getAbsolutePath() + " ...");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		ANTLRInputStream input = new ANTLRInputStream(new FileReader(post));
		BlogLexer lexer = new BlogLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BlogParser parser = new BlogParser(tokens);
		PostContext tree = parser.post();
		Post postMetadata = new Post();
		posts.add(postMetadata);
		// Instantiate the template.
		STRawGroupDir stDir = new STRawGroupDir(baseDirPath + "/templates", '$', '$');
		ST st = stDir.getInstanceOf("post");
		st.add("header", header);
		st.add("footer", footer);
		//
		postMetadata.setTitle(tree.title().LINE().getText());
		postMetadata.setUrl(tree.url().LINE().getText());
		//
		String dateString = tree.date().LINE().getText();
		Timestamp date = new Timestamp(dateFormat.parse(dateString).getTime());
		postMetadata.setDate(date);
		//
		String dex = tree.dex().chars().getText();
		if (post.getName().endsWith(MARKDOWN)) {
			dex = new PegDownProcessor().markdownToHtml(dex);
		}
		postMetadata.setSummary(dex);
		// Markdown?
		String content = tree.content().chars().getText();
		if (post.getName().endsWith(MARKDOWN)) {
			content = new PegDownProcessor().markdownToHtml(content);
		}
		postMetadata.setContent(content);
		st.add("post", postMetadata);
		st.add("content", content);
		// Tags.
		Iterator<TerminalNode> iter = tree.tags().WORDS().iterator();
		while (iter.hasNext()) {
			TerminalNode words = iter.next();
			String tag = words.getText().trim();
			st.add("tags", tag);
			// Add to tags.
			ArrayList<Post> tagPosts = tags.get(tag);
			if (tagPosts == null) {
				tagPosts = new ArrayList<Post>();
				tags.put(tag, tagPosts);
			}
			tagPosts.add(postMetadata);
		}
		// Output HTML file through ST.
		File output = new File(webDirPath + "/" + tree.url().LINE().getText());
		FileWriter writer = new FileWriter(output);
		writer.write(st.render());
		writer.flush();
		writer.close();
		System.out.println(" done.");
	}
	
	private static String processSTTemplates(String templateDirPath, String destDirPath) {
		String message = "OK";
		try {
			File templateDir = new File(templateDirPath);
			if (!templateDir.isDirectory()) {
				return "Path should be a directory.";
			}
			File[] files = templateDir.listFiles();
			for (int f = 0; f < files.length; f++) {
				// The tag template is used to render is tag page and is not a template to process here.
				// Same for post.st .
				if (files[f].getName().equals("tag.st") || files[f].getName().equals("post.st"))
					continue;
				//
				if (files[f].isDirectory()) {
					System.out.println("\nProcess subdirectory " + files[f].getName() + " ...");
					processSTTemplates(files[f].getAbsolutePath(), destDirPath + "/" + files[f].getName());
					System.out.println("        subdirectory " + files[f].getName() + " processed.\n");
				} else if (files[f].getName().endsWith(TEMPLATE_EXTENSION)) {
					processSTTemplate(files[f], destDirPath);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}

	private static void processSTTemplate(File template, String destDirPath) throws IOException {
		System.out.print("Process: " + template.getAbsolutePath() + " ...");
		// Instantiate the template.
		STRawGroupDir stDir = new STRawGroupDir(template.getParent(), '$', '$');
		String filename = template.getName();
		filename = filename.substring(0, filename.length()-3);   // Remove .st
		ST st = stDir.getInstanceOf(filename);
		st.add("header", header);
		st.add("footer", footer);
		for (int p = 0; p < posts.size() && p < NUMBER_POSTS_ON_INDEX; p++) {
			st.add("posts", posts.get(p));
		}
		String[] tagNames = new String[tags.size()];
		tags.keySet().toArray(tagNames);
		Arrays.sort(tagNames);
		st.add("siteTags", tagNames);
		// Output HTML file through ST.
		File output = new File(destDirPath + "/" + filename + ".html");
		FileWriter writer = new FileWriter(output);
		writer.write(st.render());
		writer.flush();
		writer.close();
		System.out.println(" done.");
	}
	
	private static void createTagsPages() throws IOException {
		Iterator<String> iter = tags.keySet().iterator();
		while (iter.hasNext()) {
			String tagName = iter.next();
			ArrayList<Post> posts = tags.get(tagName);
			Collections.sort(posts, new Comparator<Post>() {
				@Override
				public int compare(Post p1, Post p2) {
					// Sort in descending order.
					return p1.getDate().compareTo(p2.getDate()) * -1;
				}
			});
			// Instantiate the template.
			STRawGroupDir stDir = new STRawGroupDir(baseDirPath + "/" + TEMPLATES, '$', '$');
			ST st = stDir.getInstanceOf("tag");
			st.add("header", header);
			st.add("footer", footer);
			st.add("tag", tagName);
			st.add("posts", posts);
			// Output HTML file through ST.
			File output = new File(baseDirPath + WEB_GEN + "/tags/" + tagName + ".html");
			FileWriter writer = new FileWriter(output);
			writer.write(st.render());
			writer.flush();
			writer.close();
		}
	}

	private static void createAtom() throws IOException, FeedException {
		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType(FEED_TYPE);
		feed.setTitle("MAR9000 posts feed.");
		feed.setLink("http://www.mar9000.org");
		feed.setDescription("Master feed of posts from mar9000.org .");
		//
		List<SyndEntry> entries = new ArrayList<SyndEntry>();
		for (Post post: posts) {
			SyndEntry entry;
			SyndContent description;
			//
			entry = new SyndEntryImpl();
			entry.setTitle(post.getTitle());
			entry.setLink("http://www.mar9000.org/bliki/" + post.getUrl());
			entry.setPublishedDate(post.getDate());
			description = new SyndContentImpl();
			description.setType("text/html");
			description.setValue(post.getSummary() + post.getContent());
			entry.setDescription(description);
			//
			entries.add(entry);
		}
		feed.setEntries(entries);
		Writer writer = new FileWriter(baseDirPath + "/" + WEB_GEN + "/" + FEED_FILENAME);
		SyndFeedOutput output = new SyndFeedOutput();
		output.output(feed,writer);
		writer.close();		
	}
}
