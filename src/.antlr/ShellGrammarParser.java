// Generated from /Users/tls/Desktop/University/Year 2/COMP0010-SoftEng/python-shell-p7/src/ShellGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShellGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		INPUT=10, OUTPUT=11, PIPE=12, SEQUENCE=13, QUOTED=14, SINGLEQ=15, BACKQ=16, 
		DOUBLEQ=17, NEW_LINE=18, WHITESPACE=19, UNQUOTED=20, NON_KEYWORD=21, NON_SINGLE_QUOTE=22, 
		NON_BACK_QUOTE=23, DOUBLE_QUOTE_CONTENT=24;
	public static final int
		RULE_start = 0, RULE_command = 1, RULE_pipe = 2, RULE_call = 3, RULE_applications = 4, 
		RULE_atom = 5, RULE_argument = 6, RULE_redirection = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "command", "pipe", "call", "applications", "atom", "argument", 
			"redirection"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pwd'", "'cd'", "'echo'", "'ls'", "'cat'", "'head'", "'tail'", 
			"'grep'", "'exit'", "'<'", "'>'", "'|'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "INPUT", 
			"OUTPUT", "PIPE", "SEQUENCE", "QUOTED", "SINGLEQ", "BACKQ", "DOUBLEQ", 
			"NEW_LINE", "WHITESPACE", "UNQUOTED", "NON_KEYWORD", "NON_SINGLE_QUOTE", 
			"NON_BACK_QUOTE", "DOUBLE_QUOTE_CONTENT"
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
	public String getGrammarFileName() { return "ShellGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShellGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			command(0);
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

	public static class CommandContext extends ParserRuleContext {
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public TerminalNode SEQUENCE() { return getToken(ShellGrammarParser.SEQUENCE, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		return command(0);
	}

	private CommandContext command(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CommandContext _localctx = new CommandContext(_ctx, _parentState);
		CommandContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_command, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(19);
				pipe(0);
				}
				break;
			case 2:
				{
				setState(20);
				call();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CommandContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_command);
					setState(23);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(24);
					match(SEQUENCE);
					setState(25);
					command(4);
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PipeContext extends ParserRuleContext {
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public TerminalNode PIPE() { return getToken(ShellGrammarParser.PIPE, 0); }
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public PipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipe; }
	}

	public final PipeContext pipe() throws RecognitionException {
		return pipe(0);
	}

	private PipeContext pipe(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PipeContext _localctx = new PipeContext(_ctx, _parentState);
		PipeContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_pipe, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(32);
			call();
			setState(33);
			match(PIPE);
			setState(34);
			call();
			}
			_ctx.stop = _input.LT(-1);
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PipeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pipe);
					setState(36);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(37);
					match(PIPE);
					setState(38);
					call();
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public ApplicationsContext applications() {
			return getRuleContext(ApplicationsContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(ShellGrammarParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(ShellGrammarParser.WHITESPACE, i);
		}
		public List<TerminalNode> QUOTED() { return getTokens(ShellGrammarParser.QUOTED); }
		public TerminalNode QUOTED(int i) {
			return getToken(ShellGrammarParser.QUOTED, i);
		}
		public List<TerminalNode> NON_KEYWORD() { return getTokens(ShellGrammarParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(ShellGrammarParser.NON_KEYWORD, i);
		}
		public List<TerminalNode> UNQUOTED() { return getTokens(ShellGrammarParser.UNQUOTED); }
		public TerminalNode UNQUOTED(int i) {
			return getToken(ShellGrammarParser.UNQUOTED, i);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public List<RedirectionContext> redirection() {
			return getRuleContexts(RedirectionContext.class);
		}
		public RedirectionContext redirection(int i) {
			return getRuleContext(RedirectionContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_call);
		int _la;
		try {
			int _alt;
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(44);
				applications();
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(45);
						match(WHITESPACE);
						}
						} 
					}
					setState(50);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(51);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUOTED) | (1L << UNQUOTED) | (1L << NON_KEYWORD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(56);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(57);
				applications();
				setState(59);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(58);
					match(WHITESPACE);
					}
					break;
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INPUT) | (1L << OUTPUT) | (1L << WHITESPACE))) != 0)) {
					{
					setState(63);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INPUT:
					case OUTPUT:
						{
						setState(61);
						redirection();
						}
						break;
					case WHITESPACE:
						{
						setState(62);
						match(WHITESPACE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(68);
				argument();
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(71);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case WHITESPACE:
							{
							setState(69);
							match(WHITESPACE);
							}
							break;
						case INPUT:
						case OUTPUT:
						case QUOTED:
						case UNQUOTED:
							{
							setState(70);
							atom();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(76);
					match(WHITESPACE);
					}
					break;
				}
				}
				}
				break;
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

	public static class ApplicationsContext extends ParserRuleContext {
		public ApplicationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applications; }
	 
		public ApplicationsContext() { }
		public void copyFrom(ApplicationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HeadContext extends ApplicationsContext {
		public Token com;
		public HeadContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class CdContext extends ApplicationsContext {
		public Token com;
		public CdContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class ExitContext extends ApplicationsContext {
		public Token com;
		public ExitContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class TailContext extends ApplicationsContext {
		public Token com;
		public TailContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class GrepContext extends ApplicationsContext {
		public Token com;
		public GrepContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class LsContext extends ApplicationsContext {
		public Token com;
		public LsContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class CatContext extends ApplicationsContext {
		public Token com;
		public CatContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class EchoContext extends ApplicationsContext {
		public Token com;
		public EchoContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}
	public static class PwdContext extends ApplicationsContext {
		public Token com;
		public PwdContext(ApplicationsContext ctx) { copyFrom(ctx); }
	}

	public final ApplicationsContext applications() throws RecognitionException {
		ApplicationsContext _localctx = new ApplicationsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_applications);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new PwdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((PwdContext)_localctx).com = match(T__0);
				}
				break;
			case T__1:
				_localctx = new CdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((CdContext)_localctx).com = match(T__1);
				}
				break;
			case T__2:
				_localctx = new EchoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				((EchoContext)_localctx).com = match(T__2);
				}
				break;
			case T__3:
				_localctx = new LsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				((LsContext)_localctx).com = match(T__3);
				}
				break;
			case T__4:
				_localctx = new CatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				((CatContext)_localctx).com = match(T__4);
				}
				break;
			case T__5:
				_localctx = new HeadContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				((HeadContext)_localctx).com = match(T__5);
				}
				break;
			case T__6:
				_localctx = new TailContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(87);
				((TailContext)_localctx).com = match(T__6);
				}
				break;
			case T__7:
				_localctx = new GrepContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(88);
				((GrepContext)_localctx).com = match(T__7);
				}
				break;
			case T__8:
				_localctx = new ExitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(89);
				((ExitContext)_localctx).com = match(T__8);
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

	public static class AtomContext extends ParserRuleContext {
		public RedirectionContext redirection() {
			return getRuleContext(RedirectionContext.class,0);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atom);
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INPUT:
			case OUTPUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				redirection();
				}
				break;
			case QUOTED:
			case UNQUOTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				argument();
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

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode QUOTED() { return getToken(ShellGrammarParser.QUOTED, 0); }
		public TerminalNode UNQUOTED() { return getToken(ShellGrammarParser.UNQUOTED, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_la = _input.LA(1);
			if ( !(_la==QUOTED || _la==UNQUOTED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class RedirectionContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(ShellGrammarParser.INPUT, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(ShellGrammarParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(ShellGrammarParser.WHITESPACE, i);
		}
		public TerminalNode OUTPUT() { return getToken(ShellGrammarParser.OUTPUT, 0); }
		public RedirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redirection; }
	}

	public final RedirectionContext redirection() throws RecognitionException {
		RedirectionContext _localctx = new RedirectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_redirection);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INPUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(INPUT);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(99);
					match(WHITESPACE);
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				argument();
				}
				break;
			case OUTPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(OUTPUT);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(107);
					match(WHITESPACE);
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(113);
				argument();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return command_sempred((CommandContext)_localctx, predIndex);
		case 2:
			return pipe_sempred((PipeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean command_sempred(CommandContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean pipe_sempred(PipeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32w\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3\3\3"+
		"\5\3\30\n\3\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\7\5\61\n\5\f\5\16\5\64\13"+
		"\5\3\5\7\5\67\n\5\f\5\16\5:\13\5\3\5\3\5\5\5>\n\5\3\5\3\5\7\5B\n\5\f\5"+
		"\16\5E\13\5\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\5\5P\n\5\5\5R\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\3\7\3\7\5\7a\n\7\3\b\3\b"+
		"\3\t\3\t\7\tg\n\t\f\t\16\tj\13\t\3\t\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\3"+
		"\t\5\tu\n\t\3\t\2\4\4\6\n\2\4\6\b\n\f\16\20\2\4\4\2\20\20\26\27\4\2\20"+
		"\20\26\26\2\u0086\2\22\3\2\2\2\4\27\3\2\2\2\6!\3\2\2\2\bQ\3\2\2\2\n\\"+
		"\3\2\2\2\f`\3\2\2\2\16b\3\2\2\2\20t\3\2\2\2\22\23\5\4\3\2\23\3\3\2\2\2"+
		"\24\25\b\3\1\2\25\30\5\6\4\2\26\30\5\b\5\2\27\24\3\2\2\2\27\26\3\2\2\2"+
		"\30\36\3\2\2\2\31\32\f\5\2\2\32\33\7\17\2\2\33\35\5\4\3\6\34\31\3\2\2"+
		"\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\5\3\2\2\2 \36\3\2\2\2!\""+
		"\b\4\1\2\"#\5\b\5\2#$\7\16\2\2$%\5\b\5\2%+\3\2\2\2&\'\f\3\2\2\'(\7\16"+
		"\2\2(*\5\b\5\2)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-+\3"+
		"\2\2\2.\62\5\n\6\2/\61\7\25\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2"+
		"\2\62\63\3\2\2\2\638\3\2\2\2\64\62\3\2\2\2\65\67\t\2\2\2\66\65\3\2\2\2"+
		"\67:\3\2\2\28\66\3\2\2\289\3\2\2\29R\3\2\2\2:8\3\2\2\2;=\5\n\6\2<>\7\25"+
		"\2\2=<\3\2\2\2=>\3\2\2\2>C\3\2\2\2?B\5\20\t\2@B\7\25\2\2A?\3\2\2\2A@\3"+
		"\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FK\5\16\b\2GJ"+
		"\7\25\2\2HJ\5\f\7\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2"+
		"LO\3\2\2\2MK\3\2\2\2NP\7\25\2\2ON\3\2\2\2OP\3\2\2\2PR\3\2\2\2Q.\3\2\2"+
		"\2Q;\3\2\2\2R\t\3\2\2\2S]\7\3\2\2T]\7\4\2\2U]\7\5\2\2V]\7\6\2\2W]\7\7"+
		"\2\2X]\7\b\2\2Y]\7\t\2\2Z]\7\n\2\2[]\7\13\2\2\\S\3\2\2\2\\T\3\2\2\2\\"+
		"U\3\2\2\2\\V\3\2\2\2\\W\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3"+
		"\2\2\2]\13\3\2\2\2^a\5\20\t\2_a\5\16\b\2`^\3\2\2\2`_\3\2\2\2a\r\3\2\2"+
		"\2bc\t\3\2\2c\17\3\2\2\2dh\7\f\2\2eg\7\25\2\2fe\3\2\2\2gj\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2ku\5\16\b\2lp\7\r\2\2mo\7\25\2\2n"+
		"m\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2su\5\16\b\2"+
		"td\3\2\2\2tl\3\2\2\2u\21\3\2\2\2\23\27\36+\628=ACIKOQ\\`hpt";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}