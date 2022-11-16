// Generated from /Users/tls/Desktop/University/Year 2/COMP0010-SoftEng/python-shell-p7/src/MyGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PWD=1, CD=2, ECHO=3, LS=4, CAT=5, HEAD=6, TAIL=7, GREP=8, TEXTSQ=9, TEXTDQ=10, 
		COMMAND=11, INPUT=12, INT=13, WS=14, ANYCHAR=15;
	public static final int
		RULE_commandline = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"commandline"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PWD", "CD", "ECHO", "LS", "CAT", "HEAD", "TAIL", "GREP", "TEXTSQ", 
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

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CommandlineContext extends ParserRuleContext {
		public CommandlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandline; }
	 
		public CommandlineContext() { }
		public void copyFrom(CommandlineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HeadContext extends CommandlineContext {
		public Token atom;
		public TerminalNode HEAD() { return getToken(MyGrammarParser.HEAD, 0); }
		public HeadContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class CdContext extends CommandlineContext {
		public Token atom;
		public TerminalNode CD() { return getToken(MyGrammarParser.CD, 0); }
		public CdContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class DefaultContext extends CommandlineContext {
		public Token left;
		public Token right;
		public TerminalNode COMMAND() { return getToken(MyGrammarParser.COMMAND, 0); }
		public TerminalNode INPUT() { return getToken(MyGrammarParser.INPUT, 0); }
		public DefaultContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class TailContext extends CommandlineContext {
		public Token atom;
		public TerminalNode TAIL() { return getToken(MyGrammarParser.TAIL, 0); }
		public TailContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class GrepContext extends CommandlineContext {
		public Token atom;
		public TerminalNode GREP() { return getToken(MyGrammarParser.GREP, 0); }
		public GrepContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class LsContext extends CommandlineContext {
		public Token atom;
		public TerminalNode LS() { return getToken(MyGrammarParser.LS, 0); }
		public LsContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class CatContext extends CommandlineContext {
		public Token atom;
		public TerminalNode CAT() { return getToken(MyGrammarParser.CAT, 0); }
		public CatContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class EchoContext extends CommandlineContext {
		public Token atom;
		public TerminalNode ECHO() { return getToken(MyGrammarParser.ECHO, 0); }
		public EchoContext(CommandlineContext ctx) { copyFrom(ctx); }
	}
	public static class PwdContext extends CommandlineContext {
		public Token atom;
		public TerminalNode PWD() { return getToken(MyGrammarParser.PWD, 0); }
		public PwdContext(CommandlineContext ctx) { copyFrom(ctx); }
	}

	public final CommandlineContext commandline() throws RecognitionException {
		CommandlineContext _localctx = new CommandlineContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_commandline);
		try {
			setState(12);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMAND:
				_localctx = new DefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2);
				((DefaultContext)_localctx).left = match(COMMAND);
				setState(3);
				((DefaultContext)_localctx).right = match(INPUT);
				}
				break;
			case PWD:
				_localctx = new PwdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(4);
				((PwdContext)_localctx).atom = match(PWD);
				}
				break;
			case CD:
				_localctx = new CdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(5);
				((CdContext)_localctx).atom = match(CD);
				}
				break;
			case ECHO:
				_localctx = new EchoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(6);
				((EchoContext)_localctx).atom = match(ECHO);
				}
				break;
			case LS:
				_localctx = new LsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(7);
				((LsContext)_localctx).atom = match(LS);
				}
				break;
			case CAT:
				_localctx = new CatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(8);
				((CatContext)_localctx).atom = match(CAT);
				}
				break;
			case HEAD:
				_localctx = new HeadContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(9);
				((HeadContext)_localctx).atom = match(HEAD);
				}
				break;
			case TAIL:
				_localctx = new TailContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(10);
				((TailContext)_localctx).atom = match(TAIL);
				}
				break;
			case GREP:
				_localctx = new GrepContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(11);
				((GrepContext)_localctx).atom = match(GREP);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21\21\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\17\n\2\3\2\2\2\3\2\2\2\2\27\2"+
		"\16\3\2\2\2\4\5\7\r\2\2\5\17\7\16\2\2\6\17\7\3\2\2\7\17\7\4\2\2\b\17\7"+
		"\5\2\2\t\17\7\6\2\2\n\17\7\7\2\2\13\17\7\b\2\2\f\17\7\t\2\2\r\17\7\n\2"+
		"\2\16\4\3\2\2\2\16\6\3\2\2\2\16\7\3\2\2\2\16\b\3\2\2\2\16\t\3\2\2\2\16"+
		"\n\3\2\2\2\16\13\3\2\2\2\16\f\3\2\2\2\16\r\3\2\2\2\17\3\3\2\2\2\3\16";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}