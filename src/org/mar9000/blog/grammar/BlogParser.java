// Generated from src/org/mar9000/blog/grammar/BlogParser.g4 by ANTLR 4.0
package org.mar9000.blog.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BlogParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=8, END_ONE_LINE=10, WORDS=7, TAGS=4, CH=13, ABSTRACT=5, CONTENT=6, 
		NL=9, DATE=3, LINE=11, URL=2, END_MORE_LINES=12, TITLE=1;
	public static final String[] tokenNames = {
		"<INVALID>", "'title:'", "'url:'", "'date:'", "'tags:'", "'abstract:'", 
		"'content:'", "WORDS", "','", "NL", "END_ONE_LINE", "LINE", "END_MORE_LINES", 
		"CH"
	};
	public static final int
		RULE_post = 0, RULE_title = 1, RULE_url = 2, RULE_date = 3, RULE_tags = 4, 
		RULE_dex = 5, RULE_content = 6, RULE_chars = 7;
	public static final String[] ruleNames = {
		"post", "title", "url", "date", "tags", "dex", "content", "chars"
	};

	@Override
	public String getGrammarFileName() { return "BlogParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BlogParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PostContext extends ParserRuleContext {
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TagsContext tags() {
			return getRuleContext(TagsContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DexContext dex() {
			return getRuleContext(DexContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public PostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_post; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterPost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitPost(this);
		}
	}

	public final PostContext post() throws RecognitionException {
		PostContext _localctx = new PostContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_post);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); title();
			setState(17); url();
			setState(18); date();
			setState(19); tags();
			setState(20); dex();
			setState(21); content();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode END_ONE_LINE() { return getToken(BlogParser.END_ONE_LINE, 0); }
		public TerminalNode LINE() { return getToken(BlogParser.LINE, 0); }
		public TerminalNode TITLE() { return getToken(BlogParser.TITLE, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); match(TITLE);
			setState(24); match(LINE);
			setState(25); match(END_ONE_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UrlContext extends ParserRuleContext {
		public TerminalNode END_ONE_LINE() { return getToken(BlogParser.END_ONE_LINE, 0); }
		public TerminalNode LINE() { return getToken(BlogParser.LINE, 0); }
		public TerminalNode URL() { return getToken(BlogParser.URL, 0); }
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitUrl(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); match(URL);
			setState(28); match(LINE);
			setState(29); match(END_ONE_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DateContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(BlogParser.DATE, 0); }
		public TerminalNode END_ONE_LINE() { return getToken(BlogParser.END_ONE_LINE, 0); }
		public TerminalNode LINE() { return getToken(BlogParser.LINE, 0); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitDate(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(DATE);
			setState(32); match(LINE);
			setState(33); match(END_ONE_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagsContext extends ParserRuleContext {
		public TerminalNode TAGS() { return getToken(BlogParser.TAGS, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BlogParser.COMMA, i);
		}
		public TerminalNode WORDS(int i) {
			return getToken(BlogParser.WORDS, i);
		}
		public TerminalNode NL() { return getToken(BlogParser.NL, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BlogParser.COMMA); }
		public List<TerminalNode> WORDS() { return getTokens(BlogParser.WORDS); }
		public TagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterTags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitTags(this);
		}
	}

	public final TagsContext tags() throws RecognitionException {
		TagsContext _localctx = new TagsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tags);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); match(TAGS);
			setState(36); match(WORDS);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(37); match(COMMA);
				setState(38); match(WORDS);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44); match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DexContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(BlogParser.ABSTRACT, 0); }
		public CharsContext chars() {
			return getRuleContext(CharsContext.class,0);
		}
		public TerminalNode END_MORE_LINES() { return getToken(BlogParser.END_MORE_LINES, 0); }
		public DexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterDex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitDex(this);
		}
	}

	public final DexContext dex() throws RecognitionException {
		DexContext _localctx = new DexContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(ABSTRACT);
			setState(47); chars();
			setState(48); match(END_MORE_LINES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public TerminalNode CONTENT() { return getToken(BlogParser.CONTENT, 0); }
		public CharsContext chars() {
			return getRuleContext(CharsContext.class,0);
		}
		public TerminalNode END_MORE_LINES() { return getToken(BlogParser.END_MORE_LINES, 0); }
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitContent(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_content);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); match(CONTENT);
			setState(51); chars();
			setState(52); match(END_MORE_LINES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CharsContext extends ParserRuleContext {
		public List<TerminalNode> CH() { return getTokens(BlogParser.CH); }
		public TerminalNode CH(int i) {
			return getToken(BlogParser.CH, i);
		}
		public CharsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).enterChars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlogParserListener ) ((BlogParserListener)listener).exitChars(this);
		}
	}

	public final CharsContext chars() throws RecognitionException {
		CharsContext _localctx = new CharsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_chars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CH) {
				{
				{
				setState(54); match(CH);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\17?\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\7\6*\n\6\f\6\16\6-\13\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\t\7\t:\n\t\f\t\16\t=\13\t\3\t\2\n\2\4\6\b\n\f\16"+
		"\20\2\28\2\22\3\2\2\2\4\31\3\2\2\2\6\35\3\2\2\2\b!\3\2\2\2\n%\3\2\2\2"+
		"\f\60\3\2\2\2\16\64\3\2\2\2\20;\3\2\2\2\22\23\5\4\3\2\23\24\5\6\4\2\24"+
		"\25\5\b\5\2\25\26\5\n\6\2\26\27\5\f\7\2\27\30\5\16\b\2\30\3\3\2\2\2\31"+
		"\32\7\3\2\2\32\33\7\r\2\2\33\34\7\f\2\2\34\5\3\2\2\2\35\36\7\4\2\2\36"+
		"\37\7\r\2\2\37 \7\f\2\2 \7\3\2\2\2!\"\7\5\2\2\"#\7\r\2\2#$\7\f\2\2$\t"+
		"\3\2\2\2%&\7\6\2\2&+\7\t\2\2\'(\7\n\2\2(*\7\t\2\2)\'\3\2\2\2*-\3\2\2\2"+
		"+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\13\2\2/\13\3\2\2\2\60\61"+
		"\7\7\2\2\61\62\5\20\t\2\62\63\7\16\2\2\63\r\3\2\2\2\64\65\7\b\2\2\65\66"+
		"\5\20\t\2\66\67\7\16\2\2\67\17\3\2\2\28:\7\17\2\298\3\2\2\2:=\3\2\2\2"+
		";9\3\2\2\2;<\3\2\2\2<\21\3\2\2\2=;\3\2\2\2\4+;";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}