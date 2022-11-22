// Generated from /Users/tls/Desktop/University/Year 2/COMP0010-SoftEng/python-shell-p7/src/ShellGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShellGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, INPUT=12, OUTPUT=13, QUOTED=14, SINGLEQ=15, BACKQ=16, 
		DOUBLEQ=17, NEW_LINE=18, WHITESPACE=19, UNQUOTED=20, NON_KEYWORD=21, NON_SINGLE_QUOTE=22, 
		NON_BACK_QUOTE=23, DOUBLE_QUOTE_CONTENT=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "INPUT", "OUTPUT", "QUOTED", "SINGLEQ", "BACKQ", "DOUBLEQ", 
			"NEW_LINE", "WHITESPACE", "UNQUOTED", "NON_KEYWORD", "NON_SINGLE_QUOTE", 
			"NON_BACK_QUOTE", "DOUBLE_QUOTE_CONTENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'|'", "'pwd'", "'cd'", "'echo'", "'ls'", "'cat'", "'head'", 
			"'tail'", "'grep'", "'exit'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"INPUT", "OUTPUT", "QUOTED", "SINGLEQ", "BACKQ", "DOUBLEQ", "NEW_LINE", 
			"WHITESPACE", "UNQUOTED", "NON_KEYWORD", "NON_SINGLE_QUOTE", "NON_BACK_QUOTE", 
			"DOUBLE_QUOTE_CONTENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ShellGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ShellGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u009b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\5\17f\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\7\22s\n\22\f\22\16\22v\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\6\25\u0083\n\25\r\25\16\25\u0084\3\26\6\26\u0088\n\26"+
		"\r\26\16\26\u0089\3\27\3\27\7\27\u008e\n\27\f\27\16\27\u0091\13\27\3\30"+
		"\3\30\7\30\u0095\n\30\f\30\16\30\u0098\13\30\3\31\3\31\4\u008f\u0096\2"+
		"\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\b\4\2\f\f\17\17\13"+
		"\2\f\f\17\17\"\"$$))=>@@bb~~\n\2\f\f\17\17\"\"$$))==bb~~\5\2\f\f\17\17"+
		"))\5\2\f\f\17\17bb\6\2\f\f\17\17$$bb\2\u00a2\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2"+
		"\2\5\65\3\2\2\2\7\67\3\2\2\2\t;\3\2\2\2\13>\3\2\2\2\rC\3\2\2\2\17F\3\2"+
		"\2\2\21J\3\2\2\2\23O\3\2\2\2\25T\3\2\2\2\27Y\3\2\2\2\31^\3\2\2\2\33`\3"+
		"\2\2\2\35e\3\2\2\2\37g\3\2\2\2!k\3\2\2\2#o\3\2\2\2%y\3\2\2\2\'}\3\2\2"+
		"\2)\u0082\3\2\2\2+\u0087\3\2\2\2-\u008b\3\2\2\2/\u0092\3\2\2\2\61\u0099"+
		"\3\2\2\2\63\64\7=\2\2\64\4\3\2\2\2\65\66\7~\2\2\66\6\3\2\2\2\678\7r\2"+
		"\289\7y\2\29:\7f\2\2:\b\3\2\2\2;<\7e\2\2<=\7f\2\2=\n\3\2\2\2>?\7g\2\2"+
		"?@\7e\2\2@A\7j\2\2AB\7q\2\2B\f\3\2\2\2CD\7n\2\2DE\7u\2\2E\16\3\2\2\2F"+
		"G\7e\2\2GH\7c\2\2HI\7v\2\2I\20\3\2\2\2JK\7j\2\2KL\7g\2\2LM\7c\2\2MN\7"+
		"f\2\2N\22\3\2\2\2OP\7v\2\2PQ\7c\2\2QR\7k\2\2RS\7n\2\2S\24\3\2\2\2TU\7"+
		"i\2\2UV\7t\2\2VW\7g\2\2WX\7r\2\2X\26\3\2\2\2YZ\7g\2\2Z[\7z\2\2[\\\7k\2"+
		"\2\\]\7v\2\2]\30\3\2\2\2^_\7>\2\2_\32\3\2\2\2`a\7@\2\2a\34\3\2\2\2bf\5"+
		"\37\20\2cf\5#\22\2df\5!\21\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2f\36\3\2\2\2"+
		"gh\7)\2\2hi\5-\27\2ij\7)\2\2j \3\2\2\2kl\7b\2\2lm\5/\30\2mn\7b\2\2n\""+
		"\3\2\2\2ot\7$\2\2ps\5!\21\2qs\5\61\31\2rp\3\2\2\2rq\3\2\2\2sv\3\2\2\2"+
		"tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7$\2\2x$\3\2\2\2yz\t\2\2\2"+
		"z{\3\2\2\2{|\b\23\2\2|&\3\2\2\2}~\7\"\2\2~\177\3\2\2\2\177\u0080\b\24"+
		"\2\2\u0080(\3\2\2\2\u0081\u0083\n\3\2\2\u0082\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085*\3\2\2\2\u0086"+
		"\u0088\n\4\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a,\3\2\2\2\u008b\u008f\n\5\2\2\u008c\u008e"+
		"\13\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u008f\u008d\3\2\2\2\u0090.\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0096\n"+
		"\6\2\2\u0093\u0095\13\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\60\3\2\2\2\u0098\u0096\3\2\2"+
		"\2\u0099\u009a\n\7\2\2\u009a\62\3\2\2\2\n\2ert\u0084\u0089\u008f\u0096"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}