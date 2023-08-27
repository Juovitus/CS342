// Generated from varlang\parser\VarLang.g by ANTLR 4.5
package varlang.parser; import static varlang.AST.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VarLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		Define=10, Let=11, Dot=12, Number=13, Identifier=14, Letter=15, LetterOrDigit=16, 
		AT=17, ELLIPSIS=18, WS=19, Comment=20, Line_Comment=21;
	public static final int
		RULE_exp = 0, RULE_varexp = 1, RULE_letexp = 2, RULE_uniqueexp = 3, RULE_leteexp = 4, 
		RULE_decexp = 5, RULE_program = 6, RULE_numexp = 7, RULE_addexp = 8, RULE_subexp = 9, 
		RULE_multexp = 10, RULE_divexp = 11;
	public static final String[] ruleNames = {
		"exp", "varexp", "letexp", "uniqueexp", "leteexp", "decexp", "program", 
		"numexp", "addexp", "subexp", "multexp", "divexp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'(letunique'", "'(lete'", "'(dec'", "'-'", "'+'", 
		"'*'", "'/'", "'define'", "'let'", "'.'", null, null, null, null, "'@'", 
		"'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "Define", 
		"Let", "Dot", "Number", "Identifier", "Letter", "LetterOrDigit", "AT", 
		"ELLIPSIS", "WS", "Comment", "Line_Comment"
	};
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
	public String getGrammarFileName() { return "VarLang.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VarLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpContext extends ParserRuleContext {
		public Exp ast;
		public VarexpContext v;
		public NumexpContext n;
		public AddexpContext a;
		public SubexpContext s;
		public MultexpContext m;
		public DivexpContext d;
		public LetexpContext l;
		public UniqueexpContext u;
		public LeteexpContext e;
		public DecexpContext f;
		public VarexpContext varexp() {
			return getRuleContext(VarexpContext.class,0);
		}
		public NumexpContext numexp() {
			return getRuleContext(NumexpContext.class,0);
		}
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public SubexpContext subexp() {
			return getRuleContext(SubexpContext.class,0);
		}
		public MultexpContext multexp() {
			return getRuleContext(MultexpContext.class,0);
		}
		public DivexpContext divexp() {
			return getRuleContext(DivexpContext.class,0);
		}
		public LetexpContext letexp() {
			return getRuleContext(LetexpContext.class,0);
		}
		public UniqueexpContext uniqueexp() {
			return getRuleContext(UniqueexpContext.class,0);
		}
		public LeteexpContext leteexp() {
			return getRuleContext(LeteexpContext.class,0);
		}
		public DecexpContext decexp() {
			return getRuleContext(DecexpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_exp);
		try {
			setState(54);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				((ExpContext)_localctx).v = varexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).v.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				((ExpContext)_localctx).n = numexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).n.ast; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				((ExpContext)_localctx).a = addexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).a.ast; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				((ExpContext)_localctx).s = subexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).s.ast; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				((ExpContext)_localctx).m = multexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).m.ast; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				((ExpContext)_localctx).d = divexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).d.ast; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				((ExpContext)_localctx).l = letexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).l.ast; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(45);
				((ExpContext)_localctx).u = uniqueexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).u.ast; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(48);
				((ExpContext)_localctx).e = leteexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).e.ast; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(51);
				((ExpContext)_localctx).f = decexp();
				 ((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast; 
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

	public static class VarexpContext extends ParserRuleContext {
		public VarExp ast;
		public Token id;
		public TerminalNode Identifier() { return getToken(VarLangParser.Identifier, 0); }
		public VarexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varexp; }
	}

	public final VarexpContext varexp() throws RecognitionException {
		VarexpContext _localctx = new VarexpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_varexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			((VarexpContext)_localctx).id = match(Identifier);
			 ((VarexpContext)_localctx).ast =  new VarExp((((VarexpContext)_localctx).id!=null?((VarexpContext)_localctx).id.getText():null)); 
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

	public static class LetexpContext extends ParserRuleContext {
		public LetExp ast;
		public ArrayList<String> names;
		public ArrayList<Exp> value_exps;
		public Token id;
		public ExpContext e;
		public ExpContext body;
		public TerminalNode Let() { return getToken(VarLangParser.Let, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(VarLangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(VarLangParser.Identifier, i);
		}
		public LetexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letexp; }
	}

	public final LetexpContext letexp() throws RecognitionException {
		LetexpContext _localctx = new LetexpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_letexp);
		 ((LetexpContext)_localctx).names =  new ArrayList<String>(); ((LetexpContext)_localctx).value_exps =  new ArrayList<Exp>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__0);
			setState(60);
			match(Let);
			setState(61);
			match(T__0);
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				match(T__0);
				setState(63);
				((LetexpContext)_localctx).id = match(Identifier);
				setState(64);
				((LetexpContext)_localctx).e = exp();
				setState(65);
				match(T__1);
				 _localctx.names.add((((LetexpContext)_localctx).id!=null?((LetexpContext)_localctx).id.getText():null)); _localctx.value_exps.add(((LetexpContext)_localctx).e.ast); 
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(72);
			match(T__1);
			setState(73);
			((LetexpContext)_localctx).body = exp();
			setState(74);
			match(T__1);
			 ((LetexpContext)_localctx).ast =  new LetExp(_localctx.names, _localctx.value_exps, ((LetexpContext)_localctx).body.ast); 
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

	public static class UniqueexpContext extends ParserRuleContext {
		public UniqueExp ast;
		public ArrayList<String> names =  new ArrayList<String>();
		public ArrayList<Exp> value_exps =  new ArrayList<Exp>();
		public Token id;
		public ExpContext e;
		public ExpContext body;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(VarLangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(VarLangParser.Identifier, i);
		}
		public UniqueexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniqueexp; }
	}

	public final UniqueexpContext uniqueexp() throws RecognitionException {
		UniqueexpContext _localctx = new UniqueexpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_uniqueexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__2);
			setState(78);
			match(T__0);
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				match(T__0);
				setState(80);
				((UniqueexpContext)_localctx).id = match(Identifier);
				setState(81);
				((UniqueexpContext)_localctx).e = exp();
				setState(82);
				match(T__1);
				 _localctx.names.add((((UniqueexpContext)_localctx).id!=null?((UniqueexpContext)_localctx).id.getText():null)); _localctx.value_exps.add(((UniqueexpContext)_localctx).e.ast); 
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(89);
			match(T__1);
			setState(90);
			((UniqueexpContext)_localctx).body = exp();
			setState(91);
			match(T__1);
			 ((UniqueexpContext)_localctx).ast =  new UniqueExp(_localctx.names, _localctx.value_exps, ((UniqueexpContext)_localctx).body.ast); 
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

	public static class LeteexpContext extends ParserRuleContext {
		public LeteExp ast;
		public ArrayList<String> names =  new ArrayList<String>();
		public ArrayList<Exp> value_exps =  new ArrayList<Exp>();
		public NumExp encoder;
		public NumexpContext n;
		public Token id;
		public ExpContext e;
		public ExpContext body;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public NumexpContext numexp() {
			return getRuleContext(NumexpContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(VarLangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(VarLangParser.Identifier, i);
		}
		public LeteexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leteexp; }
	}

	public final LeteexpContext leteexp() throws RecognitionException {
		LeteexpContext _localctx = new LeteexpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_leteexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__3);
			{
			setState(95);
			((LeteexpContext)_localctx).n = numexp();
			}
			((LeteexpContext)_localctx).encoder =  ((LeteexpContext)_localctx).n.ast;
			setState(97);
			match(T__0);
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				match(T__0);
				setState(99);
				((LeteexpContext)_localctx).id = match(Identifier);
				setState(100);
				((LeteexpContext)_localctx).e = exp();
				setState(101);
				match(T__1);
				 _localctx.names.add((((LeteexpContext)_localctx).id!=null?((LeteexpContext)_localctx).id.getText():null)); _localctx.value_exps.add(((LeteexpContext)_localctx).e.ast); 
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(108);
			match(T__1);
			setState(109);
			((LeteexpContext)_localctx).body = exp();
			setState(110);
			match(T__1);
			 ((LeteexpContext)_localctx).ast =  new LeteExp(_localctx.names, _localctx.value_exps, ((LeteexpContext)_localctx).body.ast, _localctx.encoder); 
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

	public static class DecexpContext extends ParserRuleContext {
		public DecExp ast;
		public NumexpContext decoder;
		public Token id;
		public NumexpContext numexp() {
			return getRuleContext(NumexpContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(VarLangParser.Identifier, 0); }
		public DecexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decexp; }
	}

	public final DecexpContext decexp() throws RecognitionException {
		DecexpContext _localctx = new DecexpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__4);
			setState(114);
			((DecexpContext)_localctx).decoder = numexp();
			setState(115);
			((DecexpContext)_localctx).id = match(Identifier);
			setState(116);
			match(T__1);
			 ((DecexpContext)_localctx).ast =  new DecExp(((DecexpContext)_localctx).decoder.ast, (((DecexpContext)_localctx).id!=null?((DecexpContext)_localctx).id.getText():null));
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

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public ExpContext e;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((ProgramContext)_localctx).e = exp();
			 ((ProgramContext)_localctx).ast =  new Program(((ProgramContext)_localctx).e.ast); 
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

	public static class NumexpContext extends ParserRuleContext {
		public NumExp ast;
		public Token n0;
		public Token n1;
		public List<TerminalNode> Number() { return getTokens(VarLangParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(VarLangParser.Number, i);
		}
		public TerminalNode Dot() { return getToken(VarLangParser.Dot, 0); }
		public NumexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numexp; }
	}

	public final NumexpContext numexp() throws RecognitionException {
		NumexpContext _localctx = new NumexpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_numexp);
		try {
			setState(136);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				((NumexpContext)_localctx).n0 = match(Number);
				 ((NumexpContext)_localctx).ast =  new NumExp(Integer.parseInt((((NumexpContext)_localctx).n0!=null?((NumexpContext)_localctx).n0.getText():null))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(T__5);
				setState(125);
				((NumexpContext)_localctx).n0 = match(Number);
				 ((NumexpContext)_localctx).ast =  new NumExp(-Integer.parseInt((((NumexpContext)_localctx).n0!=null?((NumexpContext)_localctx).n0.getText():null))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				((NumexpContext)_localctx).n0 = match(Number);
				setState(128);
				match(Dot);
				setState(129);
				((NumexpContext)_localctx).n1 = match(Number);
				 ((NumexpContext)_localctx).ast =  new NumExp(Double.parseDouble((((NumexpContext)_localctx).n0!=null?((NumexpContext)_localctx).n0.getText():null)+"."+(((NumexpContext)_localctx).n1!=null?((NumexpContext)_localctx).n1.getText():null))); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				match(T__5);
				setState(132);
				((NumexpContext)_localctx).n0 = match(Number);
				setState(133);
				match(Dot);
				setState(134);
				((NumexpContext)_localctx).n1 = match(Number);
				 ((NumexpContext)_localctx).ast =  new NumExp(Double.parseDouble("-" + (((NumexpContext)_localctx).n0!=null?((NumexpContext)_localctx).n0.getText():null)+"."+(((NumexpContext)_localctx).n1!=null?((NumexpContext)_localctx).n1.getText():null))); 
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

	public static class AddexpContext extends ParserRuleContext {
		public AddExp ast;
		public ArrayList<Exp> list;
		public ExpContext e;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public AddexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexp; }
	}

	public final AddexpContext addexp() throws RecognitionException {
		AddexpContext _localctx = new AddexpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_addexp);
		 ((AddexpContext)_localctx).list =  new ArrayList<Exp>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__0);
			setState(139);
			match(T__6);
			setState(140);
			((AddexpContext)_localctx).e = exp();
			 _localctx.list.add(((AddexpContext)_localctx).e.ast); 
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				((AddexpContext)_localctx).e = exp();
				 _localctx.list.add(((AddexpContext)_localctx).e.ast); 
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Number) | (1L << Identifier))) != 0) );
			setState(149);
			match(T__1);
			 ((AddexpContext)_localctx).ast =  new AddExp(_localctx.list); 
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

	public static class SubexpContext extends ParserRuleContext {
		public SubExp ast;
		public ArrayList<Exp> list;
		public ExpContext e;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SubexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subexp; }
	}

	public final SubexpContext subexp() throws RecognitionException {
		SubexpContext _localctx = new SubexpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subexp);
		 ((SubexpContext)_localctx).list =  new ArrayList<Exp>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__0);
			setState(153);
			match(T__5);
			setState(154);
			((SubexpContext)_localctx).e = exp();
			 _localctx.list.add(((SubexpContext)_localctx).e.ast); 
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				((SubexpContext)_localctx).e = exp();
				 _localctx.list.add(((SubexpContext)_localctx).e.ast); 
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Number) | (1L << Identifier))) != 0) );
			setState(163);
			match(T__1);
			 ((SubexpContext)_localctx).ast =  new SubExp(_localctx.list); 
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

	public static class MultexpContext extends ParserRuleContext {
		public MultExp ast;
		public ArrayList<Exp> list;
		public ExpContext e;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public MultexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multexp; }
	}

	public final MultexpContext multexp() throws RecognitionException {
		MultexpContext _localctx = new MultexpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multexp);
		 ((MultexpContext)_localctx).list =  new ArrayList<Exp>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__0);
			setState(167);
			match(T__7);
			setState(168);
			((MultexpContext)_localctx).e = exp();
			 _localctx.list.add(((MultexpContext)_localctx).e.ast); 
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(170);
				((MultexpContext)_localctx).e = exp();
				 _localctx.list.add(((MultexpContext)_localctx).e.ast); 
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Number) | (1L << Identifier))) != 0) );
			setState(177);
			match(T__1);
			 ((MultexpContext)_localctx).ast =  new MultExp(_localctx.list); 
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

	public static class DivexpContext extends ParserRuleContext {
		public DivExp ast;
		public ArrayList<Exp> list;
		public ExpContext e;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public DivexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divexp; }
	}

	public final DivexpContext divexp() throws RecognitionException {
		DivexpContext _localctx = new DivexpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_divexp);
		 ((DivexpContext)_localctx).list =  new ArrayList<Exp>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__0);
			setState(181);
			match(T__8);
			setState(182);
			((DivexpContext)_localctx).e = exp();
			 _localctx.list.add(((DivexpContext)_localctx).e.ast); 
			setState(187); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
				((DivexpContext)_localctx).e = exp();
				 _localctx.list.add(((DivexpContext)_localctx).e.ast); 
				}
				}
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Number) | (1L << Identifier))) != 0) );
			setState(191);
			match(T__1);
			 ((DivexpContext)_localctx).ast =  new DivExp(_localctx.list); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\27\u00c5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\5\29\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4G\n\4\r"+
		"\4\16\4H\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5X\n\5"+
		"\r\5\16\5Y\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\6\6k\n\6\r\6\16\6l\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u0094\n\n\r\n\16\n\u0095\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00a2\n\13\r\13\16\13\u00a3"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00b0\n\f\r\f\16\f\u00b1"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u00be\n\r\r\r\16\r\u00bf"+
		"\3\r\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\u00cb\28\3\2"+
		"\2\2\4:\3\2\2\2\6=\3\2\2\2\bO\3\2\2\2\n`\3\2\2\2\fs\3\2\2\2\16y\3\2\2"+
		"\2\20\u008a\3\2\2\2\22\u008c\3\2\2\2\24\u009a\3\2\2\2\26\u00a8\3\2\2\2"+
		"\30\u00b6\3\2\2\2\32\33\5\4\3\2\33\34\b\2\1\2\349\3\2\2\2\35\36\5\20\t"+
		"\2\36\37\b\2\1\2\379\3\2\2\2 !\5\22\n\2!\"\b\2\1\2\"9\3\2\2\2#$\5\24\13"+
		"\2$%\b\2\1\2%9\3\2\2\2&\'\5\26\f\2\'(\b\2\1\2(9\3\2\2\2)*\5\30\r\2*+\b"+
		"\2\1\2+9\3\2\2\2,-\5\6\4\2-.\b\2\1\2.9\3\2\2\2/\60\5\b\5\2\60\61\b\2\1"+
		"\2\619\3\2\2\2\62\63\5\n\6\2\63\64\b\2\1\2\649\3\2\2\2\65\66\5\f\7\2\66"+
		"\67\b\2\1\2\679\3\2\2\28\32\3\2\2\28\35\3\2\2\28 \3\2\2\28#\3\2\2\28&"+
		"\3\2\2\28)\3\2\2\28,\3\2\2\28/\3\2\2\28\62\3\2\2\28\65\3\2\2\29\3\3\2"+
		"\2\2:;\7\20\2\2;<\b\3\1\2<\5\3\2\2\2=>\7\3\2\2>?\7\r\2\2?F\7\3\2\2@A\7"+
		"\3\2\2AB\7\20\2\2BC\5\2\2\2CD\7\4\2\2DE\b\4\1\2EG\3\2\2\2F@\3\2\2\2GH"+
		"\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\4\2\2KL\5\2\2\2LM\7\4\2\2M"+
		"N\b\4\1\2N\7\3\2\2\2OP\7\5\2\2PW\7\3\2\2QR\7\3\2\2RS\7\20\2\2ST\5\2\2"+
		"\2TU\7\4\2\2UV\b\5\1\2VX\3\2\2\2WQ\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2"+
		"\2Z[\3\2\2\2[\\\7\4\2\2\\]\5\2\2\2]^\7\4\2\2^_\b\5\1\2_\t\3\2\2\2`a\7"+
		"\6\2\2ab\5\20\t\2bc\b\6\1\2cj\7\3\2\2de\7\3\2\2ef\7\20\2\2fg\5\2\2\2g"+
		"h\7\4\2\2hi\b\6\1\2ik\3\2\2\2jd\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2"+
		"mn\3\2\2\2no\7\4\2\2op\5\2\2\2pq\7\4\2\2qr\b\6\1\2r\13\3\2\2\2st\7\7\2"+
		"\2tu\5\20\t\2uv\7\20\2\2vw\7\4\2\2wx\b\7\1\2x\r\3\2\2\2yz\5\2\2\2z{\b"+
		"\b\1\2{\17\3\2\2\2|}\7\17\2\2}\u008b\b\t\1\2~\177\7\b\2\2\177\u0080\7"+
		"\17\2\2\u0080\u008b\b\t\1\2\u0081\u0082\7\17\2\2\u0082\u0083\7\16\2\2"+
		"\u0083\u0084\7\17\2\2\u0084\u008b\b\t\1\2\u0085\u0086\7\b\2\2\u0086\u0087"+
		"\7\17\2\2\u0087\u0088\7\16\2\2\u0088\u0089\7\17\2\2\u0089\u008b\b\t\1"+
		"\2\u008a|\3\2\2\2\u008a~\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0085\3\2\2"+
		"\2\u008b\21\3\2\2\2\u008c\u008d\7\3\2\2\u008d\u008e\7\t\2\2\u008e\u008f"+
		"\5\2\2\2\u008f\u0093\b\n\1\2\u0090\u0091\5\2\2\2\u0091\u0092\b\n\1\2\u0092"+
		"\u0094\3\2\2\2\u0093\u0090\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\4\2\2\u0098"+
		"\u0099\b\n\1\2\u0099\23\3\2\2\2\u009a\u009b\7\3\2\2\u009b\u009c\7\b\2"+
		"\2\u009c\u009d\5\2\2\2\u009d\u00a1\b\13\1\2\u009e\u009f\5\2\2\2\u009f"+
		"\u00a0\b\13\1\2\u00a0\u00a2\3\2\2\2\u00a1\u009e\3\2\2\2\u00a2\u00a3\3"+
		"\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\7\4\2\2\u00a6\u00a7\b\13\1\2\u00a7\25\3\2\2\2\u00a8\u00a9\7\3\2"+
		"\2\u00a9\u00aa\7\n\2\2\u00aa\u00ab\5\2\2\2\u00ab\u00af\b\f\1\2\u00ac\u00ad"+
		"\5\2\2\2\u00ad\u00ae\b\f\1\2\u00ae\u00b0\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b4\7\4\2\2\u00b4\u00b5\b\f\1\2\u00b5\27\3\2\2\2\u00b6\u00b7"+
		"\7\3\2\2\u00b7\u00b8\7\13\2\2\u00b8\u00b9\5\2\2\2\u00b9\u00bd\b\r\1\2"+
		"\u00ba\u00bb\5\2\2\2\u00bb\u00bc\b\r\1\2\u00bc\u00be\3\2\2\2\u00bd\u00ba"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\b\r\1\2\u00c3\31\3\2\2"+
		"\2\138HYl\u008a\u0095\u00a3\u00b1\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}