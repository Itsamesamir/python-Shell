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
		T__9=10, T__10=11, INPUT=12, OUTPUT=13, QUOTED=14, SINGLEQ=15, BACKQ=16, 
		DOUBLEQ=17, NEW_LINE=18, WHITESPACE=19, UNQUOTED=20, NON_KEYWORD=21, NON_SINGLE_QUOTE=22, 
		NON_BACK_QUOTE=23, DOUBLE_QUOTE_CONTENT=24;
	public static final int
		RULE_start = 0, RULE_command = 1, RULE_pipe = 2, RULE_call = 3, RULE_call2 = 4, 
		RULE_applications = 5, RULE_atom = 6, RULE_argument = 7, RULE_redirection = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "command", "pipe", "call", "call2", "applications", "atom", 
			"argument", "redirection"
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
			setState(18);
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
		public Call2Context call2() {
			return getRuleContext(Call2Context.class,0);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
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
			setState(24);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(21);
				pipe(0);
				}
				break;
			case 2:
				{
				setState(22);
				call();
				}
				break;
			case 3:
				{
				setState(23);
				call2();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(31);
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
					setState(26);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(27);
					match(T__0);
					setState(28);
					command(5);
					}
					} 
				}
				setState(33);
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
			setState(35);
			call();
			setState(36);
			match(T__1);
			setState(37);
			call();
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
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
					setState(39);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(40);
					match(T__1);
					setState(41);
					call();
					}
					} 
				}
				setState(46);
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
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(47);
			applications();
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					match(WHITESPACE);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
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
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
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

	public static class Call2Context extends ParserRuleContext {
		public ApplicationsContext applications() {
			return getRuleContext(ApplicationsContext.class,0);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(ShellGrammarParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(ShellGrammarParser.WHITESPACE, i);
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
		public Call2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call2; }
	}

	public final Call2Context call2() throws RecognitionException {
		Call2Context _localctx = new Call2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_call2);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(60);
			applications();
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(61);
				match(WHITESPACE);
				}
				break;
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INPUT) | (1L << OUTPUT) | (1L << WHITESPACE))) != 0)) {
				{
				setState(66);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INPUT:
				case OUTPUT:
					{
					setState(64);
					redirection();
					}
					break;
				case WHITESPACE:
					{
					setState(65);
					match(WHITESPACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			argument();
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(74);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(72);
						match(WHITESPACE);
						}
						break;
					case INPUT:
					case OUTPUT:
					case QUOTED:
					case UNQUOTED:
						{
						setState(73);
						atom();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(79);
				match(WHITESPACE);
				}
				break;
			}
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
		enterRule(_localctx, 10, RULE_applications);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new PwdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				((PwdContext)_localctx).com = match(T__2);
				}
				break;
			case T__3:
				_localctx = new CdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				((CdContext)_localctx).com = match(T__3);
				}
				break;
			case T__4:
				_localctx = new EchoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				((EchoContext)_localctx).com = match(T__4);
				}
				break;
			case T__5:
				_localctx = new LsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				((LsContext)_localctx).com = match(T__5);
				}
				break;
			case T__6:
				_localctx = new CatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				((CatContext)_localctx).com = match(T__6);
				}
				break;
			case T__7:
				_localctx = new HeadContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(87);
				((HeadContext)_localctx).com = match(T__7);
				}
				break;
			case T__8:
				_localctx = new TailContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				((TailContext)_localctx).com = match(T__8);
				}
				break;
			case T__9:
				_localctx = new GrepContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(89);
				((GrepContext)_localctx).com = match(T__9);
				}
				break;
			case T__10:
				_localctx = new ExitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(90);
				((ExitContext)_localctx).com = match(T__10);
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
		enterRule(_localctx, 12, RULE_atom);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INPUT:
			case OUTPUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				redirection();
				}
				break;
			case QUOTED:
			case UNQUOTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
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
		enterRule(_localctx, 14, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
		enterRule(_localctx, 16, RULE_redirection);
		int _la;
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INPUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(INPUT);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(100);
					match(WHITESPACE);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(106);
				argument();
				}
				break;
			case OUTPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(OUTPUT);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(108);
					match(WHITESPACE);
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
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
			return precpred(_ctx, 4);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32x\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\5\3\33\n\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\5\3\5\7\5\64\n\5\f"+
		"\5\16\5\67\13\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\6\3\6\5\6A\n\6\3\6\3\6\7"+
		"\6E\n\6\f\6\16\6H\13\6\3\6\3\6\3\6\7\6M\n\6\f\6\16\6P\13\6\3\6\5\6S\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\5\bb\n\b\3\t\3"+
		"\t\3\n\3\n\7\nh\n\n\f\n\16\nk\13\n\3\n\3\n\3\n\7\np\n\n\f\n\16\ns\13\n"+
		"\3\n\5\nv\n\n\3\n\2\4\4\6\13\2\4\6\b\n\f\16\20\22\2\4\4\2\20\20\26\27"+
		"\4\2\20\20\26\26\2\u0086\2\24\3\2\2\2\4\32\3\2\2\2\6$\3\2\2\2\b\61\3\2"+
		"\2\2\n>\3\2\2\2\f]\3\2\2\2\16a\3\2\2\2\20c\3\2\2\2\22u\3\2\2\2\24\25\5"+
		"\4\3\2\25\3\3\2\2\2\26\27\b\3\1\2\27\33\5\6\4\2\30\33\5\b\5\2\31\33\5"+
		"\n\6\2\32\26\3\2\2\2\32\30\3\2\2\2\32\31\3\2\2\2\33!\3\2\2\2\34\35\f\6"+
		"\2\2\35\36\7\3\2\2\36 \5\4\3\7\37\34\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\""+
		"\3\2\2\2\"\5\3\2\2\2#!\3\2\2\2$%\b\4\1\2%&\5\b\5\2&\'\7\4\2\2\'(\5\b\5"+
		"\2(.\3\2\2\2)*\f\3\2\2*+\7\4\2\2+-\5\b\5\2,)\3\2\2\2-\60\3\2\2\2.,\3\2"+
		"\2\2./\3\2\2\2/\7\3\2\2\2\60.\3\2\2\2\61\65\5\f\7\2\62\64\7\25\2\2\63"+
		"\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65"+
		"\3\2\2\28:\t\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\t\3\2\2\2"+
		"=;\3\2\2\2>@\5\f\7\2?A\7\25\2\2@?\3\2\2\2@A\3\2\2\2AF\3\2\2\2BE\5\22\n"+
		"\2CE\7\25\2\2DB\3\2\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2"+
		"\2\2HF\3\2\2\2IN\5\20\t\2JM\7\25\2\2KM\5\16\b\2LJ\3\2\2\2LK\3\2\2\2MP"+
		"\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2QS\7\25\2\2RQ\3\2\2\2"+
		"RS\3\2\2\2S\13\3\2\2\2T^\7\5\2\2U^\7\6\2\2V^\7\7\2\2W^\7\b\2\2X^\7\t\2"+
		"\2Y^\7\n\2\2Z^\7\13\2\2[^\7\f\2\2\\^\7\r\2\2]T\3\2\2\2]U\3\2\2\2]V\3\2"+
		"\2\2]W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\r\3"+
		"\2\2\2_b\5\22\n\2`b\5\20\t\2a_\3\2\2\2a`\3\2\2\2b\17\3\2\2\2cd\t\3\2\2"+
		"d\21\3\2\2\2ei\7\16\2\2fh\7\25\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2"+
		"\2\2jl\3\2\2\2ki\3\2\2\2lv\5\20\t\2mq\7\17\2\2np\7\25\2\2on\3\2\2\2ps"+
		"\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tv\5\20\t\2ue\3\2\2\2"+
		"um\3\2\2\2v\23\3\2\2\2\22\32!.\65;@DFLNR]aiqu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}