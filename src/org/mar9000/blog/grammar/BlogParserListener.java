// Generated from src/org/mar9000/blog/grammar/BlogParser.g4 by ANTLR 4.2
package org.mar9000.blog.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BlogParser}.
 */
public interface BlogParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BlogParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(@NotNull BlogParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(@NotNull BlogParser.ContentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BlogParser#tags}.
	 * @param ctx the parse tree
	 */
	void enterTags(@NotNull BlogParser.TagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#tags}.
	 * @param ctx the parse tree
	 */
	void exitTags(@NotNull BlogParser.TagsContext ctx);

	/**
	 * Enter a parse tree produced by {@link BlogParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(@NotNull BlogParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(@NotNull BlogParser.TitleContext ctx);

	/**
	 * Enter a parse tree produced by {@link BlogParser#post}.
	 * @param ctx the parse tree
	 */
	void enterPost(@NotNull BlogParser.PostContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#post}.
	 * @param ctx the parse tree
	 */
	void exitPost(@NotNull BlogParser.PostContext ctx);

	/**
	 * Enter a parse tree produced by {@link BlogParser#dex}.
	 * @param ctx the parse tree
	 */
	void enterDex(@NotNull BlogParser.DexContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#dex}.
	 * @param ctx the parse tree
	 */
	void exitDex(@NotNull BlogParser.DexContext ctx);

	/**
	 * Enter a parse tree produced by {@link BlogParser#chars}.
	 * @param ctx the parse tree
	 */
	void enterChars(@NotNull BlogParser.CharsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#chars}.
	 * @param ctx the parse tree
	 */
	void exitChars(@NotNull BlogParser.CharsContext ctx);

	/**
	 * Enter a parse tree produced by {@link BlogParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(@NotNull BlogParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(@NotNull BlogParser.DateContext ctx);

	/**
	 * Enter a parse tree produced by {@link BlogParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(@NotNull BlogParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlogParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(@NotNull BlogParser.UrlContext ctx);
}