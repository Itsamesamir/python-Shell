// Generated from /Users/tls/Desktop/University/Year 2/COMP0010-SoftEng/python-shell-p7/src/idk.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class idkLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, APPLICATIONS=13, NEW_LINE=14, QUOTES=15, 
		NON_NEWLINE=16, NON_SINGLE_QUOTE=17, NON_BACK_QUOTE=18, DOUBLE_QUOTE_CONTENT=19, 
		WHITESPACE=20, QUOTED=21, SINGLEQ=22, BACKQ=23, DOUBLEQ=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "APPLICATIONS", "NEW_LINE", "QUOTES", "NON_NEWLINE", 
			"NON_SINGLE_QUOTE", "NON_BACK_QUOTE", "DOUBLE_QUOTE_CONTENT", "WHITESPACE", 
			"QUOTED", "SINGLEQ", "BACKQ", "DOUBLEQ"
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
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "APPLICATIONS", "NEW_LINE", "QUOTES", "NON_NEWLINE", "NON_SINGLE_QUOTE", 
			"NON_BACK_QUOTE", "DOUBLE_QUOTE_CONTENT", "WHITESPACE", "QUOTED", "SINGLEQ", 
			"BACKQ", "DOUBLEQ"
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


	public idkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "idk.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00b0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16x\n\16\3\17\6\17{\n\17\r\17\16\17|"+
		"\3\20\3\20\3\21\6\21\u0082\n\21\r\21\16\21\u0083\3\22\6\22\u0087\n\22"+
		"\r\22\16\22\u0088\3\23\6\23\u008c\n\23\r\23\16\23\u008d\3\24\6\24\u0091"+
		"\n\24\r\24\16\24\u0092\3\25\6\25\u0096\n\25\r\25\16\25\u0097\3\26\3\26"+
		"\3\26\5\26\u009d\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\7\31\u00aa\n\31\f\31\16\31\u00ad\13\31\3\31\3\31\2\2\32\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\b\4\2\f\f\17\17\5\2$$))bb\5\2"+
		"\f\f\17\17))\4\2\f\fbb\5\2\f\f$$bb\4\2\13\13\"\"\2\u00c0\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t;\3\2\2\2\13>\3\2\2\2\rC\3\2"+
		"\2\2\17F\3\2\2\2\21J\3\2\2\2\23O\3\2\2\2\25T\3\2\2\2\27Y\3\2\2\2\31[\3"+
		"\2\2\2\33w\3\2\2\2\35z\3\2\2\2\37~\3\2\2\2!\u0081\3\2\2\2#\u0086\3\2\2"+
		"\2%\u008b\3\2\2\2\'\u0090\3\2\2\2)\u0095\3\2\2\2+\u009c\3\2\2\2-\u009e"+
		"\3\2\2\2/\u00a2\3\2\2\2\61\u00a6\3\2\2\2\63\64\7=\2\2\64\4\3\2\2\2\65"+
		"\66\7~\2\2\66\6\3\2\2\2\678\7r\2\289\7y\2\29:\7f\2\2:\b\3\2\2\2;<\7e\2"+
		"\2<=\7f\2\2=\n\3\2\2\2>?\7g\2\2?@\7e\2\2@A\7j\2\2AB\7q\2\2B\f\3\2\2\2"+
		"CD\7n\2\2DE\7u\2\2E\16\3\2\2\2FG\7e\2\2GH\7c\2\2HI\7v\2\2I\20\3\2\2\2"+
		"JK\7j\2\2KL\7g\2\2LM\7c\2\2MN\7f\2\2N\22\3\2\2\2OP\7v\2\2PQ\7c\2\2QR\7"+
		"k\2\2RS\7n\2\2S\24\3\2\2\2TU\7i\2\2UV\7t\2\2VW\7g\2\2WX\7r\2\2X\26\3\2"+
		"\2\2YZ\7>\2\2Z\30\3\2\2\2[\\\7@\2\2\\\32\3\2\2\2]^\7r\2\2^_\7y\2\2_x\7"+
		"f\2\2`a\7e\2\2ax\7f\2\2bc\7g\2\2cd\7e\2\2de\7j\2\2ex\7q\2\2fg\7n\2\2g"+
		"x\7u\2\2hi\7e\2\2ij\7c\2\2jx\7v\2\2kl\7j\2\2lm\7g\2\2mn\7c\2\2nx\7f\2"+
		"\2op\7v\2\2pq\7c\2\2qr\7k\2\2rx\7n\2\2st\7i\2\2tu\7t\2\2uv\7g\2\2vx\7"+
		"r\2\2w]\3\2\2\2w`\3\2\2\2wb\3\2\2\2wf\3\2\2\2wh\3\2\2\2wk\3\2\2\2wo\3"+
		"\2\2\2ws\3\2\2\2x\34\3\2\2\2y{\t\2\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|"+
		"}\3\2\2\2}\36\3\2\2\2~\177\t\3\2\2\177 \3\2\2\2\u0080\u0082\n\2\2\2\u0081"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\"\3\2\2\2\u0085\u0087\n\4\2\2\u0086\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089$\3\2\2\2\u008a"+
		"\u008c\n\5\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e&\3\2\2\2\u008f\u0091\n\6\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"(\3\2\2\2\u0094\u0096\t\7\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2"+
		"\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098*\3\2\2\2\u0099\u009d\5"+
		"-\27\2\u009a\u009d\5\61\31\2\u009b\u009d\5/\30\2\u009c\u0099\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d,\3\2\2\2\u009e\u009f\7)\2\2\u009f"+
		"\u00a0\5#\22\2\u00a0\u00a1\7)\2\2\u00a1.\3\2\2\2\u00a2\u00a3\7b\2\2\u00a3"+
		"\u00a4\5%\23\2\u00a4\u00a5\7b\2\2\u00a5\60\3\2\2\2\u00a6\u00ab\7$\2\2"+
		"\u00a7\u00aa\5/\30\2\u00a8\u00aa\5\'\24\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7$\2\2\u00af\62\3\2\2\2"+
		"\r\2w|\u0083\u0088\u008d\u0092\u0097\u009c\u00a9\u00ab\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}