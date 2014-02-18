// Generated from src/org/mar9000/blog/grammar/BlogParser.g4 by ANTLR 4.0
package org.mar9000.blog.grammar;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class BlogParserBaseListener implements BlogParserListener {
	@Override public void enterContent(BlogParser.ContentContext ctx) { }
	@Override public void exitContent(BlogParser.ContentContext ctx) { }

	@Override public void enterTags(BlogParser.TagsContext ctx) { }
	@Override public void exitTags(BlogParser.TagsContext ctx) { }

	@Override public void enterTitle(BlogParser.TitleContext ctx) { }
	@Override public void exitTitle(BlogParser.TitleContext ctx) { }

	@Override public void enterPost(BlogParser.PostContext ctx) { }
	@Override public void exitPost(BlogParser.PostContext ctx) { }

	@Override public void enterDex(BlogParser.DexContext ctx) { }
	@Override public void exitDex(BlogParser.DexContext ctx) { }

	@Override public void enterChars(BlogParser.CharsContext ctx) { }
	@Override public void exitChars(BlogParser.CharsContext ctx) { }

	@Override public void enterDate(BlogParser.DateContext ctx) { }
	@Override public void exitDate(BlogParser.DateContext ctx) { }

	@Override public void enterUrl(BlogParser.UrlContext ctx) { }
	@Override public void exitUrl(BlogParser.UrlContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}