// Generated from /Users/tls/Desktop/University/Year 2/COMP0010-SoftEng/python-shell-p7/src/idk.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class idkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, APPLICATIONS=13, NEW_LINE=14, QUOTES=15, 
		NON_NEWLINE=16, NON_SINGLE_QUOTE=17, NON_BACK_QUOTE=18, DOUBLE_QUOTE_CONTENT=19, 
		WHITESPACE=20, QUOTED=21, SINGLEQ=22, BACKQ=23, DOUBLEQ=24;
	public static final int
		RULE_command = 0, RULE_pipe = 1, RULE_call = 2, RULE_applications = 3, 
		RULE_atom = 4, RULE_argument = 5, RULE_redirection = 6, RULE_non_keyword = 7, 
		RULE_unquoted = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"command", "pipe", "call", "applications", "atom", "argument", "redirection", 
			"non_keyword", "unquoted"
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

	@Override
	public String getGrammarFileName() { return "idk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public idkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_command, _p);
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
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(24);
					match(T__0);
					setState(25);
					command(3);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_pipe, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(32);
			call();
			setState(33);
			match(T__1);
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
					match(T__1);
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
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(idkParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(idkParser.WHITESPACE, i);
		}
		public Non_keywordContext non_keyword() {
			return getRuleContext(Non_keywordContext.class,0);
		}
		public TerminalNode QUOTED() { return getToken(idkParser.QUOTED, 0); }
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
		enterRule(_localctx, 4, RULE_call);
		int _la;
		try {
			int _alt;
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(44);
				applications();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(45);
				applications();
				{
				setState(46);
				match(WHITESPACE);
				}
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(47);
					non_keyword();
					}
					break;
				case 2:
					{
					setState(48);
					match(QUOTED);
					}
					break;
				}
				{
				setState(51);
				match(WHITESPACE);
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10 || _la==T__11) {
					{
					{
					setState(52);
					redirection();
					setState(53);
					match(WHITESPACE);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				argument();
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(61);
						match(WHITESPACE);
						setState(62);
						atom();
						}
						} 
					}
					setState(67);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(68);
				match(WHITESPACE);
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
		enterRule(_localctx, 6, RULE_applications);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new PwdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				((PwdContext)_localctx).com = match(T__2);
				}
				break;
			case T__3:
				_localctx = new CdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				((CdContext)_localctx).com = match(T__3);
				}
				break;
			case T__4:
				_localctx = new EchoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				((EchoContext)_localctx).com = match(T__4);
				}
				break;
			case T__5:
				_localctx = new LsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				((LsContext)_localctx).com = match(T__5);
				}
				break;
			case T__6:
				_localctx = new CatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				((CatContext)_localctx).com = match(T__6);
				}
				break;
			case T__7:
				_localctx = new HeadContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				((HeadContext)_localctx).com = match(T__7);
				}
				break;
			case T__8:
				_localctx = new TailContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				((TailContext)_localctx).com = match(T__8);
				}
				break;
			case T__9:
				_localctx = new GrepContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(79);
				((GrepContext)_localctx).com = match(T__9);
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
		enterRule(_localctx, 8, RULE_atom);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				redirection();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case APPLICATIONS:
			case NON_NEWLINE:
			case NON_SINGLE_QUOTE:
			case NON_BACK_QUOTE:
			case DOUBLE_QUOTE_CONTENT:
			case QUOTED:
			case SINGLEQ:
			case BACKQ:
			case DOUBLEQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
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
		public List<TerminalNode> QUOTED() { return getTokens(idkParser.QUOTED); }
		public TerminalNode QUOTED(int i) {
			return getToken(idkParser.QUOTED, i);
		}
		public List<UnquotedContext> unquoted() {
			return getRuleContexts(UnquotedContext.class);
		}
		public UnquotedContext unquoted(int i) {
			return getRuleContext(UnquotedContext.class,i);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(88);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(86);
					match(QUOTED);
					}
					break;
				case 2:
					{
					setState(87);
					unquoted();
					}
					break;
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << APPLICATIONS) | (1L << NON_NEWLINE) | (1L << NON_SINGLE_QUOTE) | (1L << NON_BACK_QUOTE) | (1L << DOUBLE_QUOTE_CONTENT) | (1L << QUOTED) | (1L << SINGLEQ) | (1L << BACKQ) | (1L << DOUBLEQ))) != 0) );
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
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode WHITESPACE() { return getToken(idkParser.WHITESPACE, 0); }
		public RedirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redirection; }
	}

	public final RedirectionContext redirection() throws RecognitionException {
		RedirectionContext _localctx = new RedirectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_redirection);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(T__10);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(93);
					match(WHITESPACE);
					}
				}

				setState(96);
				argument();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__11);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(98);
					match(WHITESPACE);
					}
				}

				setState(101);
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

	public static class Non_keywordContext extends ParserRuleContext {
		public List<TerminalNode> NEW_LINE() { return getTokens(idkParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(idkParser.NEW_LINE, i);
		}
		public List<TerminalNode> SINGLEQ() { return getTokens(idkParser.SINGLEQ); }
		public TerminalNode SINGLEQ(int i) {
			return getToken(idkParser.SINGLEQ, i);
		}
		public List<TerminalNode> DOUBLEQ() { return getTokens(idkParser.DOUBLEQ); }
		public TerminalNode DOUBLEQ(int i) {
			return getToken(idkParser.DOUBLEQ, i);
		}
		public List<TerminalNode> BACKQ() { return getTokens(idkParser.BACKQ); }
		public TerminalNode BACKQ(int i) {
			return getToken(idkParser.BACKQ, i);
		}
		public Non_keywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_keyword; }
	}

	public final Non_keywordContext non_keyword() throws RecognitionException {
		Non_keywordContext _localctx = new Non_keywordContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_non_keyword);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(104);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << NEW_LINE) | (1L << SINGLEQ) | (1L << BACKQ) | (1L << DOUBLEQ))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(107); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class UnquotedContext extends ParserRuleContext {
		public List<TerminalNode> WHITESPACE() { return getTokens(idkParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(idkParser.WHITESPACE, i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(idkParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(idkParser.NEW_LINE, i);
		}
		public List<TerminalNode> QUOTES() { return getTokens(idkParser.QUOTES); }
		public TerminalNode QUOTES(int i) {
			return getToken(idkParser.QUOTES, i);
		}
		public UnquotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unquoted; }
	}

	public final UnquotedContext unquoted() throws RecognitionException {
		UnquotedContext _localctx = new UnquotedContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unquoted);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(109);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__10) | (1L << T__11) | (1L << NEW_LINE) | (1L << QUOTES) | (1L << WHITESPACE))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(112); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 0:
			return command_sempred((CommandContext)_localctx, predIndex);
		case 1:
			return pipe_sempred((PipeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean command_sempred(CommandContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32u\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\5\2\30\n\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\3\4\3\4\5\4\64\n\4\3"+
		"\4\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\3\4\3\4\7\4B\n\4\f\4\16\4E"+
		"\13\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5S\n\5\3\6\3"+
		"\6\5\6W\n\6\3\7\3\7\6\7[\n\7\r\7\16\7\\\3\b\3\b\5\ba\n\b\3\b\3\b\3\b\5"+
		"\bf\n\b\3\b\5\bi\n\b\3\t\6\tl\n\t\r\t\16\tm\3\n\6\nq\n\n\r\n\16\nr\3\n"+
		"\2\4\2\4\13\2\4\6\b\n\f\16\20\22\2\4\5\2\3\4\20\20\30\32\6\2\3\4\r\16"+
		"\20\21\26\26\2\u0081\2\27\3\2\2\2\4!\3\2\2\2\6H\3\2\2\2\bR\3\2\2\2\nV"+
		"\3\2\2\2\fZ\3\2\2\2\16h\3\2\2\2\20k\3\2\2\2\22p\3\2\2\2\24\25\b\2\1\2"+
		"\25\30\5\4\3\2\26\30\5\6\4\2\27\24\3\2\2\2\27\26\3\2\2\2\30\36\3\2\2\2"+
		"\31\32\f\4\2\2\32\33\7\3\2\2\33\35\5\2\2\5\34\31\3\2\2\2\35 \3\2\2\2\36"+
		"\34\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 \36\3\2\2\2!\"\b\3\1\2\"#\5\6\4"+
		"\2#$\7\4\2\2$%\5\6\4\2%+\3\2\2\2&\'\f\3\2\2\'(\7\4\2\2(*\5\6\4\2)&\3\2"+
		"\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-+\3\2\2\2.I\5\b\5\2/\60"+
		"\5\b\5\2\60\63\7\26\2\2\61\64\5\20\t\2\62\64\7\27\2\2\63\61\3\2\2\2\63"+
		"\62\3\2\2\2\64\65\3\2\2\2\65;\7\26\2\2\66\67\5\16\b\2\678\7\26\2\28:\3"+
		"\2\2\29\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>"+
		"C\5\f\7\2?@\7\26\2\2@B\5\n\6\2A?\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2"+
		"DF\3\2\2\2EC\3\2\2\2FG\7\26\2\2GI\3\2\2\2H.\3\2\2\2H/\3\2\2\2I\7\3\2\2"+
		"\2JS\7\5\2\2KS\7\6\2\2LS\7\7\2\2MS\7\b\2\2NS\7\t\2\2OS\7\n\2\2PS\7\13"+
		"\2\2QS\7\f\2\2RJ\3\2\2\2RK\3\2\2\2RL\3\2\2\2RM\3\2\2\2RN\3\2\2\2RO\3\2"+
		"\2\2RP\3\2\2\2RQ\3\2\2\2S\t\3\2\2\2TW\5\16\b\2UW\5\f\7\2VT\3\2\2\2VU\3"+
		"\2\2\2W\13\3\2\2\2X[\7\27\2\2Y[\5\22\n\2ZX\3\2\2\2ZY\3\2\2\2[\\\3\2\2"+
		"\2\\Z\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^`\7\r\2\2_a\7\26\2\2`_\3\2\2\2`a\3"+
		"\2\2\2ab\3\2\2\2bi\5\f\7\2ce\7\16\2\2df\7\26\2\2ed\3\2\2\2ef\3\2\2\2f"+
		"g\3\2\2\2gi\5\f\7\2h^\3\2\2\2hc\3\2\2\2i\17\3\2\2\2jl\n\2\2\2kj\3\2\2"+
		"\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\21\3\2\2\2oq\n\3\2\2po\3\2\2\2qr\3\2"+
		"\2\2rp\3\2\2\2rs\3\2\2\2s\23\3\2\2\2\22\27\36+\63;CHRVZ\\`ehmr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}