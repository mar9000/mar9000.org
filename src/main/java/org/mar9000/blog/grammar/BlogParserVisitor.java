// Generated from src/org/mar9000/blog/grammar/BlogParser.g4 by ANTLR 4.2
package org.mar9000.blog.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BlogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BlogParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BlogParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(@NotNull BlogParser.ContentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BlogParser#tags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTags(@NotNull BlogParser.TagsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BlogParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(@NotNull BlogParser.TitleContext ctx);

	/**
	 * Visit a parse tree produced by {@link BlogParser#post}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPost(@NotNull BlogParser.PostContext ctx);

	/**
	 * Visit a parse tree produced by {@link BlogParser#dex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDex(@NotNull BlogParser.DexContext ctx);

	/**
	 * Visit a parse tree produced by {@link BlogParser#chars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChars(@NotNull BlogParser.CharsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BlogParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(@NotNull BlogParser.DateContext ctx);

	/**
	 * Visit a parse tree produced by {@link BlogParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(@NotNull BlogParser.UrlContext ctx);
}