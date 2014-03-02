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
import java.util.Iterator;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.mar9000.blog.grammar.BlogLexer;
import org.mar9000.blog.grammar.BlogParser;
import org.mar9000.blog.grammar.BlogParser.PostContext;
import org.pegdown.PegDownProcessor;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STRawGroupDir;

public class Blog {
	
	public static final String MARKDOWN = ".md";
	public static final String EXTENSIONS = ".post,.html," + MARKDOWN;
	public static final String TEMPLATE_EXTENSION = ".st";
	public static final String TEMPLATES = "/templates";
	public static final String WEB_TEMPLATE = "/web-template";
	public static final String WEB_GEN = "/web-gen";
	public static final String HEADER = "header.html";
	public static final String FOOTER = "footer.html";
	
	private static String baseDirPath = null;
	private static String header = null;
	private static String footer = null;

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
				// Process index.st and other basic ST files.
				processSTTemplates(baseDirPath + TEMPLATES, baseDirPath + WEB_GEN);
				// Process posts.
				System.out.println("Source dir. is " + baseDirPath + "/posts");
				System.out.println("Target dir. is " + baseDirPath + "/web\n");
				processPosts(args[0] + "/posts", baseDirPath + "/web-gen/bliki");
			} catch (IOException e) {
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

	private static void processPost(File post, String webDirPath) throws IOException {
		System.out.print("Process: " + post.getAbsolutePath() + " ...");
		ANTLRInputStream input = new ANTLRInputStream(new FileReader(post));
		BlogLexer lexer = new BlogLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BlogParser parser = new BlogParser(tokens);
		PostContext tree = parser.post();
		// Instantiate the template.
		STRawGroupDir stDir = new STRawGroupDir(baseDirPath + "/templates", '$', '$');
		ST st = stDir.getInstanceOf("post");
		st.add("header", header);
		st.add("footer", footer);
		//
		st.add("title", tree.title().LINE().getText());
		st.add("url", tree.url().LINE().getText());
		st.add("date", tree.date().LINE().getText());
		//
		String dex = tree.dex().chars().getText();
		if (post.getName().endsWith(MARKDOWN)) {
			dex = new PegDownProcessor().markdownToHtml(dex);
		}
		st.add("abstract", dex);
		// Markdown?
		String content = tree.content().chars().getText();
		if (post.getName().endsWith(MARKDOWN)) {
			content = new PegDownProcessor().markdownToHtml(content);
		}
		st.add("content", content);
		// Tags.
		Iterator<TerminalNode> iter = tree.tags().WORDS().iterator();
		while (iter.hasNext()) {
			TerminalNode words = iter.next();
			st.add("tags", words.getText());
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
				if (false && files[f].isDirectory()) {   // Disabled because there are subdir with many subdirs.
					System.out.println("\nProcess subdir. " + files[f].getName());
					processSTTemplates(files[f].getAbsolutePath(), destDirPath + "/" + files[f].getName());
				} else if (files[f].getName().endsWith(TEMPLATE_EXTENSION)
						&& !files[f].getName().equals("post.st")) {
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
		// Output HTML file through ST.
		File output = new File(destDirPath + "/" + filename + ".html");
		FileWriter writer = new FileWriter(output);
		writer.write(st.render());
		writer.flush();
		writer.close();
		System.out.println(" done.");
	}
}
