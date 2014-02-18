// Generated from src/org/mar9000/blog/grammar/BlogParser.g4 by ANTLR 4.0
package org.mar9000.blog.grammar;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface BlogParserListener extends ParseTreeListener {
	void enterContent(BlogParser.ContentContext ctx);
	void exitContent(BlogParser.ContentContext ctx);

	void enterTags(BlogParser.TagsContext ctx);
	void exitTags(BlogParser.TagsContext ctx);

	void enterTitle(BlogParser.TitleContext ctx);
	void exitTitle(BlogParser.TitleContext ctx);

	void enterPost(BlogParser.PostContext ctx);
	void exitPost(BlogParser.PostContext ctx);

	void enterDex(BlogParser.DexContext ctx);
	void exitDex(BlogParser.DexContext ctx);

	void enterChars(BlogParser.CharsContext ctx);
	void exitChars(BlogParser.CharsContext ctx);

	void enterDate(BlogParser.DateContext ctx);
	void exitDate(BlogParser.DateContext ctx);

	void enterUrl(BlogParser.UrlContext ctx);
	void exitUrl(BlogParser.UrlContext ctx);
}