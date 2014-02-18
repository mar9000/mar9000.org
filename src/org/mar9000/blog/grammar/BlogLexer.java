// Generated from src/org/mar9000/blog/grammar/BlogLexer.g4 by ANTLR 4.0
package org.mar9000.blog.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BlogLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TITLE=1, URL=2, DATE=3, TAGS=4, ABSTRACT=5, CONTENT=6, WORDS=7, COMMA=8, 
		NL=9, END_ONE_LINE=10, LINE=11, END_MORE_LINES=12, CH=13;
	public static final int ONE_LINE = 1;
	public static final int MORE_LINES = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "ONE_LINE", "MORE_LINES"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'title:'", "'url:'", "'date:'", "'tags:'", "'abstract:'", "'content:'", 
		"WORDS", "','", "NL", "END_ONE_LINE", "LINE", "END_MORE_LINES", "CH"
	};
	public static final String[] ruleNames = {
		"TITLE", "URL", "DATE", "TAGS", "ABSTRACT", "CONTENT", "WORDS", "COMMA", 
		"NL", "END_ONE_LINE", "LINE", "END_MORE_LINES", "CH"
	};


	public BlogLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BlogLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: TITLE_action((RuleContext)_localctx, actionIndex); break;

		case 1: URL_action((RuleContext)_localctx, actionIndex); break;

		case 2: DATE_action((RuleContext)_localctx, actionIndex); break;

		case 4: ABSTRACT_action((RuleContext)_localctx, actionIndex); break;

		case 5: CONTENT_action((RuleContext)_localctx, actionIndex); break;

		case 9: END_ONE_LINE_action((RuleContext)_localctx, actionIndex); break;

		case 11: END_MORE_LINES_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void CONTENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: _mode = MORE_LINES;  break;
		}
	}
	private void ABSTRACT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: _mode = MORE_LINES;  break;
		}
	}
	private void DATE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: _mode = ONE_LINE;  break;
		}
	}
	private void END_ONE_LINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: _mode = DEFAULT_MODE;  break;
		}
	}
	private void URL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _mode = ONE_LINE;  break;
		}
	}
	private void END_MORE_LINES_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: _mode = DEFAULT_MODE;  break;
		}
	}
	private void TITLE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _mode = ONE_LINE;  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\17t\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4"+
		"\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\6\bV"+
		"\n\b\r\b\16\bW\3\t\3\t\3\n\5\n]\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\6"+
		"\ff\n\f\r\f\16\fg\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\2\17\5"+
		"\3\2\7\4\3\t\5\4\13\6\1\r\7\5\17\b\6\21\t\1\23\n\1\25\13\1\27\f\7\31\r"+
		"\1\33\16\b\35\17\1\5\2\3\4\4\6\"\"\62;C\\c|\4\f\f\17\17t\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\4\33\3\2\2\2"+
		"\4\35\3\2\2\2\5\37\3\2\2\2\7(\3\2\2\2\t/\3\2\2\2\13\67\3\2\2\2\r=\3\2"+
		"\2\2\17I\3\2\2\2\21U\3\2\2\2\23Y\3\2\2\2\25\\\3\2\2\2\27`\3\2\2\2\31e"+
		"\3\2\2\2\33i\3\2\2\2\35r\3\2\2\2\37 \7v\2\2 !\7k\2\2!\"\7v\2\2\"#\7n\2"+
		"\2#$\7g\2\2$%\7<\2\2%&\3\2\2\2&\'\b\2\2\2\'\6\3\2\2\2()\7w\2\2)*\7t\2"+
		"\2*+\7n\2\2+,\7<\2\2,-\3\2\2\2-.\b\3\3\2.\b\3\2\2\2/\60\7f\2\2\60\61\7"+
		"c\2\2\61\62\7v\2\2\62\63\7g\2\2\63\64\7<\2\2\64\65\3\2\2\2\65\66\b\4\4"+
		"\2\66\n\3\2\2\2\678\7v\2\289\7c\2\29:\7i\2\2:;\7u\2\2;<\7<\2\2<\f\3\2"+
		"\2\2=>\7c\2\2>?\7d\2\2?@\7u\2\2@A\7v\2\2AB\7t\2\2BC\7c\2\2CD\7e\2\2DE"+
		"\7v\2\2EF\7<\2\2FG\3\2\2\2GH\b\6\5\2H\16\3\2\2\2IJ\7e\2\2JK\7q\2\2KL\7"+
		"p\2\2LM\7v\2\2MN\7g\2\2NO\7p\2\2OP\7v\2\2PQ\7<\2\2QR\3\2\2\2RS\b\7\6\2"+
		"S\20\3\2\2\2TV\t\2\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\22\3\2"+
		"\2\2YZ\7.\2\2Z\24\3\2\2\2[]\7\17\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^"+
		"_\7\f\2\2_\26\3\2\2\2`a\5\25\n\2ab\3\2\2\2bc\b\13\7\2c\30\3\2\2\2df\n"+
		"\3\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\32\3\2\2\2ij\5\25\n\2"+
		"jk\7\60\2\2kl\7\60\2\2lm\7\60\2\2mn\3\2\2\2no\5\25\n\2op\3\2\2\2pq\b\r"+
		"\b\2q\34\3\2\2\2rs\13\2\2\2s\36\3\2\2\2\t\2\3\4UW\\g";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}