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
		T__9=10, INPUT=11, OUTPUT=12, QUOTED=13, SINGLEQ=14, BACKQ=15, DOUBLEQ=16, 
		NEW_LINE=17, WHITESPACE=18, UNQUOTED=19, NON_KEYWORD=20, NON_SINGLE_QUOTE=21, 
		NON_BACK_QUOTE=22, DOUBLE_QUOTE_CONTENT=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "INPUT", "OUTPUT", "QUOTED", "SINGLEQ", "BACKQ", "DOUBLEQ", "NEW_LINE", 
			"WHITESPACE", "UNQUOTED", "NON_KEYWORD", "NON_SINGLE_QUOTE", "NON_BACK_QUOTE", 
			"DOUBLE_QUOTE_CONTENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'|'", "'pwd'", "'cd'", "'echo'", "'ls'", "'cat'", "'head'", 
			"'tail'", "'grep'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INPUT", 
			"OUTPUT", "QUOTED", "SINGLEQ", "BACKQ", "DOUBLEQ", "NEW_LINE", "WHITESPACE", 
			"UNQUOTED", "NON_KEYWORD", "NON_SINGLE_QUOTE", "NON_BACK_QUOTE", "DOUBLE_QUOTE_CONTENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0094\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\5\16_\n\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21l\n\21\f\21\16\21o\13\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\6\24|\n\24\r\24"+
		"\16\24}\3\25\6\25\u0081\n\25\r\25\16\25\u0082\3\26\3\26\7\26\u0087\n\26"+
		"\f\26\16\26\u008a\13\26\3\27\3\27\7\27\u008e\n\27\f\27\16\27\u0091\13"+
		"\27\3\30\3\30\4\u0088\u008f\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\3\2\b\4\2\f\f\17\17\13\2\f\f\17\17\"\"$$))=>@@bb~~\n\2\f\f\17\17\"\""+
		"$$))==bb~~\5\2\f\f\17\17))\5\2\f\f\17\17bb\6\2\f\f\17\17$$bb\2\u009b\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t9\3\2\2\2\13<\3\2\2\2\rA\3\2"+
		"\2\2\17D\3\2\2\2\21H\3\2\2\2\23M\3\2\2\2\25R\3\2\2\2\27W\3\2\2\2\31Y\3"+
		"\2\2\2\33^\3\2\2\2\35`\3\2\2\2\37d\3\2\2\2!h\3\2\2\2#r\3\2\2\2%v\3\2\2"+
		"\2\'{\3\2\2\2)\u0080\3\2\2\2+\u0084\3\2\2\2-\u008b\3\2\2\2/\u0092\3\2"+
		"\2\2\61\62\7=\2\2\62\4\3\2\2\2\63\64\7~\2\2\64\6\3\2\2\2\65\66\7r\2\2"+
		"\66\67\7y\2\2\678\7f\2\28\b\3\2\2\29:\7e\2\2:;\7f\2\2;\n\3\2\2\2<=\7g"+
		"\2\2=>\7e\2\2>?\7j\2\2?@\7q\2\2@\f\3\2\2\2AB\7n\2\2BC\7u\2\2C\16\3\2\2"+
		"\2DE\7e\2\2EF\7c\2\2FG\7v\2\2G\20\3\2\2\2HI\7j\2\2IJ\7g\2\2JK\7c\2\2K"+
		"L\7f\2\2L\22\3\2\2\2MN\7v\2\2NO\7c\2\2OP\7k\2\2PQ\7n\2\2Q\24\3\2\2\2R"+
		"S\7i\2\2ST\7t\2\2TU\7g\2\2UV\7r\2\2V\26\3\2\2\2WX\7>\2\2X\30\3\2\2\2Y"+
		"Z\7@\2\2Z\32\3\2\2\2[_\5\35\17\2\\_\5!\21\2]_\5\37\20\2^[\3\2\2\2^\\\3"+
		"\2\2\2^]\3\2\2\2_\34\3\2\2\2`a\7)\2\2ab\5+\26\2bc\7)\2\2c\36\3\2\2\2d"+
		"e\7b\2\2ef\5-\27\2fg\7b\2\2g \3\2\2\2hm\7$\2\2il\5\37\20\2jl\5/\30\2k"+
		"i\3\2\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2"+
		"pq\7$\2\2q\"\3\2\2\2rs\t\2\2\2st\3\2\2\2tu\b\22\2\2u$\3\2\2\2vw\7\"\2"+
		"\2wx\3\2\2\2xy\b\23\2\2y&\3\2\2\2z|\n\3\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2"+
		"\2\2}~\3\2\2\2~(\3\2\2\2\177\u0081\n\4\2\2\u0080\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083*\3\2\2\2\u0084"+
		"\u0088\n\5\2\2\u0085\u0087\13\2\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3"+
		"\2\2\2\u0088\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089,\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008b\u008f\n\6\2\2\u008c\u008e\13\2\2\2\u008d\u008c\3\2\2\2"+
		"\u008e\u0091\3\2\2\2\u008f\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090.\3"+
		"\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\n\7\2\2\u0093\60\3\2\2\2\n\2^k"+
		"m}\u0082\u0088\u008f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}