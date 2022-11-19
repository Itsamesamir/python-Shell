// Generated from /Users/tls/Desktop/University/Year 2/COMP0010-SoftEng/python-shell-p7/src/MyGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, CD=2, ECHO=3, LS=4, CAT=5, HEAD=6, TAIL=7, GREP=8, TEXTSQ=9, TEXTDQ=10, 
		COMMAND=11, INPUT=12, INT=13, WS=14, ANYCHAR=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "CD", "ECHO", "LS", "CAT", "HEAD", "TAIL", "GREP", "TEXTSQ", 
			"TEXTDQ", "COMMAND", "INPUT", "INT", "LOWERCASE", "UPPERCASE", "WS", 
			"ANYCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pwd'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "CD", "ECHO", "LS", "CAT", "HEAD", "TAIL", "GREP", "TEXTSQ", 
			"TEXTDQ", "COMMAND", "INPUT", "INT", "WS", "ANYCHAR"
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


	public MyGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\7\nJ\n\n\f\n\16\nM\13\n\3\n\3\n\3\13\3\13\7\13S\n\13\f\13\16\13V"+
		"\13\13\3\13\3\13\3\f\6\f[\n\f\r\f\16\f\\\3\f\7\f`\n\f\f\f\16\fc\13\f\3"+
		"\r\3\r\3\r\6\rh\n\r\r\r\16\ri\5\rl\n\r\3\16\6\16o\n\16\r\16\16\16p\3\17"+
		"\3\17\3\20\3\20\3\21\6\21x\n\21\r\21\16\21y\3\21\3\21\3\22\3\22\2\2\23"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37"+
		"\2!\20#\21\3\2\b\3\2))\3\2$$\3\2\13\13\3\2\62;\3\2c|\3\2C\\\2\u0085\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5)\3\2\2\2\7"+
		",\3\2\2\2\t\61\3\2\2\2\13\64\3\2\2\2\r8\3\2\2\2\17=\3\2\2\2\21B\3\2\2"+
		"\2\23G\3\2\2\2\25P\3\2\2\2\27Z\3\2\2\2\31k\3\2\2\2\33n\3\2\2\2\35r\3\2"+
		"\2\2\37t\3\2\2\2!w\3\2\2\2#}\3\2\2\2%&\7r\2\2&\'\7y\2\2\'(\7f\2\2(\4\3"+
		"\2\2\2)*\7e\2\2*+\7f\2\2+\6\3\2\2\2,-\7g\2\2-.\7e\2\2./\7j\2\2/\60\7q"+
		"\2\2\60\b\3\2\2\2\61\62\7n\2\2\62\63\7u\2\2\63\n\3\2\2\2\64\65\7e\2\2"+
		"\65\66\7c\2\2\66\67\7v\2\2\67\f\3\2\2\289\7j\2\29:\7g\2\2:;\7c\2\2;<\7"+
		"f\2\2<\16\3\2\2\2=>\7v\2\2>?\7c\2\2?@\7k\2\2@A\7n\2\2A\20\3\2\2\2BC\7"+
		"i\2\2CD\7t\2\2DE\7g\2\2EF\7r\2\2F\22\3\2\2\2GK\7)\2\2HJ\n\2\2\2IH\3\2"+
		"\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7)\2\2O\24\3"+
		"\2\2\2PT\7$\2\2QS\n\3\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3"+
		"\2\2\2VT\3\2\2\2WX\7$\2\2X\26\3\2\2\2Y[\5\35\17\2ZY\3\2\2\2[\\\3\2\2\2"+
		"\\Z\3\2\2\2\\]\3\2\2\2]a\3\2\2\2^`\t\4\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2"+
		"\2ab\3\2\2\2b\30\3\2\2\2ca\3\2\2\2dl\5\23\n\2el\5\25\13\2fh\n\4\2\2gf"+
		"\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2kd\3\2\2\2ke\3\2\2\2k"+
		"g\3\2\2\2l\32\3\2\2\2mo\t\5\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2"+
		"\2q\34\3\2\2\2rs\t\6\2\2s\36\3\2\2\2tu\t\7\2\2u \3\2\2\2vx\t\4\2\2wv\3"+
		"\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\21\2\2|\"\3\2\2\2}"+
		"~\13\2\2\2~$\3\2\2\2\13\2KT\\aikpy\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}