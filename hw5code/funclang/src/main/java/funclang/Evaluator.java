package funclang;
import static funclang.AST.*;
import static funclang.Value.*;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

import funclang.Env.*;
import javafx.util.Pair;

public class Evaluator implements Visitor<Value> {

	Printer.Formatter ts = new Printer.Formatter();

	Env initEnv = initialEnv(); //New for definelang

	Value valueOf(Program p) {
			return (Value) p.accept(this, initEnv);
	}

	@Override
	public Value visit(AddExp e, Env env) {
		List<Exp> operands = e.all();
		double result = 0;
		for(Exp exp: operands) {
			NumVal intermediate = (NumVal) exp.accept(this, env); // Dynamic type-checking
			result += intermediate.v(); //Semantics of AddExp in terms of the target language.
		}
		return new NumVal(result);
	}

	@Override
	public Value visit(UnitExp e, Env env) {
		return new UnitVal();
	}

	@Override
	public Value visit(NumExp e, Env env) {
		return new NumVal(e.v());
	}

	@Override
	public Value visit(StrExp e, Env env) {
		return new StringVal(e.v());
	}

	@Override
	public Value visit(BoolExp e, Env env) {
		return new BoolVal(e.v());
	}

	@Override
	public Value visit(DivExp e, Env env) {
		List<Exp> operands = e.all();
		NumVal lVal = (NumVal) operands.get(0).accept(this, env);
		double result = lVal.v();
		for(int i=1; i<operands.size(); i++) {
			NumVal rVal = (NumVal) operands.get(i).accept(this, env);
			result = result / rVal.v();
		}
		return new NumVal(result);
	}

	@Override
	public Value visit(MultExp e, Env env) {
		List<Exp> operands = e.all();
		double result = 1;
		for(Exp exp: operands) {
			NumVal intermediate = (NumVal) exp.accept(this, env); // Dynamic type-checking
			result *= intermediate.v(); //Semantics of MultExp.
		}
		return new NumVal(result);
	}

	@Override
	public Value visit(Program p, Env env) {
		try {
			for(DefineDecl d: p.decls())
				d.accept(this, initEnv);
			return (Value) p.e().accept(this, initEnv);
		} catch (ClassCastException e) {
			return new DynamicError(e.getMessage());
		}
	}

	@Override
	public Value visit(SubExp e, Env env) {
		List<Exp> operands = e.all();
		NumVal lVal = (NumVal) operands.get(0).accept(this, env);
		double result = lVal.v();
		for(int i=1; i<operands.size(); i++) {
			NumVal rVal = (NumVal) operands.get(i).accept(this, env);
			result = result - rVal.v();
		}
		return new NumVal(result);
	}

	@Override
	public Value visit(VarExp e, Env env) {
		// Previously, all variables had value 42. New semantics.
		return env.get(e.name());
	}

	@Override
	public Value visit(LetExp e, Env env) { // New for varlang.
		List<String> names = e.names();
		List<Exp> value_exps = e.value_exps();
		List<Value> values = new ArrayList<Value>(value_exps.size());

		for(Exp exp : value_exps)
			values.add((Value)exp.accept(this, env));

		Env new_env = env;
		for (int index = 0; index < names.size(); index++)
			new_env = new ExtendEnv(new_env, names.get(index), values.get(index));

		return (Value) e.body().accept(this, new_env);
	}

	@Override
	public Value visit(DefineDecl e, Env env) { // New for definelang.
		String name = e.name();
		Exp value_exp = e.value_exp();
		Value value = (Value) value_exp.accept(this, env);
		((GlobalEnv) initEnv).extend(name, value);
		return new Value.UnitVal();
	}

	@Override
	public Value visit(LambdaExp e, Env env) { // New for funclang.
		return new Value.FunVal(env, e.formals(), e.body());
	}

	@Override
	public Value visit(CallExp e, Env env) { // New for funclang.
		Object result = e.operator().accept(this, env);
		if(!(result instanceof Value.FunVal))
			return new Value.DynamicError("Operator not a function in call " +  ts.visit(e, env));
		Value.FunVal operator =  (Value.FunVal) result; //Dynamic checking
		List<Exp> operands = e.operands();

		// Call-by-value semantics
		List<Value> actuals = new ArrayList<Value>(operands.size());
		for(Exp exp : operands)
			actuals.add((Value)exp.accept(this, env));

		List<String> formals = operator.formals();
		if (formals.size()!=actuals.size())
			return new Value.DynamicError("Argument mismatch in call " + ts.visit(e, env));

		Env fun_env = operator.env();
		for (int index = 0; index < formals.size(); index++)
			fun_env = new ExtendEnv(fun_env, formals.get(index), actuals.get(index));

		return (Value) operator.body().accept(this, fun_env);
	}

	@Override
	public Value visit(IfExp e, Env env) { // New for funclang.
		Object result = e.conditional().accept(this, env);
		if(!(result instanceof Value.BoolVal))
			return new Value.DynamicError("Condition not a boolean in expression " +  ts.visit(e, env));
		Value.BoolVal condition =  (Value.BoolVal) result; //Dynamic checking

		if(condition.v())
			return (Value) e.then_exp().accept(this, env);
		else return (Value) e.else_exp().accept(this, env);
	}

	@Override
	public Value visit(LessExp e, Env env) { // New for funclang.
		Value first = (Value) e.first_exp().accept(this, env);
		Value second = (Value) e.second_exp().accept(this, env);
		return new Value.BoolVal(compare(first, second) < 0);
	}

	public static boolean equal(Value first, Value second){
		//Check if values are either String, List(Which is pair?), or a Num.
		if(first instanceof StringVal && second instanceof StringVal){
			//If string we'll compare the lengths of the strings for comparison
			//IDK if this is working right yet cuz it autoparsed it to Stringval but we'll see IG
			String s1Length = ((StringVal) first).v();
			String s2Length = ((StringVal) second).v();
			//Return if they're equal or not
			return s1Length.equals(s2Length);
		}else if(first instanceof PairVal && second instanceof PairVal){
			//Check equaility, return if true
//			if(equal(((PairVal) first)._fst, ((PairVal) second)._fst) && equal(((PairVal) first)._snd, ((PairVal) second)._snd)){
//				return true;
//			}else {
//				return false;
//			}
			//This is currently returning if the first values in a list are equal, I have no idea how to check size
			if(((PairVal)first).isList() && ((PairVal)second).isList()){
				//if both are null ret true, if both are = ret true, otherwise false
				return (((PairVal)first).listEquals(((PairVal) second)));

			}
			//boolean b1 = equal(((PairVal)first).fst() , ((PairVal)second).fst());
			//return b1;
		}else if(first instanceof NumVal && second instanceof NumVal){
			//parse
			Double firstDouble = ((NumVal) first).v();
			Double secondDouble = ((NumVal) second).v();
			//Return true if they're equal
			if(Double.compare(firstDouble, secondDouble) == 0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public static double compare(Value first, Value second){
		//comparison is 0 if they're equal
		if(equal(first, second)){
			return 0;
		}
		if(first instanceof StringVal && second instanceof StringVal){
			return ((StringVal)first).v().compareTo(((StringVal)second).v());
		}else if(first instanceof NumVal && second instanceof NumVal){
			return Double.compare(((NumVal)first).v(), ((NumVal)second).v());
		}else if(first instanceof PairVal && second instanceof PairVal){
			return ((PairVal) first).compare((PairVal) second);
		}else if(first instanceof PairVal){
			return 11111;
		}
		return -99999;
	}

	@Override
	public Value visit(EqualExp e, Env env) { // New for funclang.
		Value first = (Value) e.first_exp().accept(this, env);
		Value second = (Value) e.second_exp().accept(this, env);
		return new Value.BoolVal(equal(first, second));
	}

	@Override
	public Value visit(GreaterExp e, Env env) { // New for funclang.
		Value first = (Value) e.first_exp().accept(this, env);
		Value second = (Value) e.second_exp().accept(this, env);
		return new Value.BoolVal(compare(first, second) > 0);
	}

	@Override
	public Value visit(CarExp e, Env env) {
		Value.PairVal pair = (Value.PairVal) e.arg().accept(this, env);
		return pair.fst();
	}

	@Override
	public Value visit(CdrExp e, Env env) {
		Value.PairVal pair = (Value.PairVal) e.arg().accept(this, env);
		return pair.snd();
	}

	@Override
	public Value visit(ConsExp e, Env env) {
		Value first = (Value) e.fst().accept(this, env);
		Value second = (Value) e.snd().accept(this, env);
		return new Value.PairVal(first, second);
	}

	@Override
	public Value visit(ListExp e, Env env) { // New for funclang.
		List<Exp> elemExps = e.elems();
		int length = elemExps.size();
		if(length == 0)
			return new Value.Null();

		//Order of evaluation: left to right e.g. (list (+ 3 4) (+ 5 4))
		Value[] elems = new Value[length];
		for(int i=0; i<length; i++)
			elems[i] = (Value) elemExps.get(i).accept(this, env);

		Value result = new Value.Null();
		for(int i=length-1; i>=0; i--)
			result = new PairVal(elems[i], result);
		return result;
	}

	@Override
	public Value visit(NullExp e, Env env) {
		Value val = (Value) e.arg().accept(this, env);
		return new BoolVal(val instanceof Value.Null);
	}

	public Value visit(EvalExp e, Env env) {
		StringVal programText = (StringVal) e.code().accept(this, env);
		Program p = _reader.parse(programText.v());
		return (Value) p.accept(this, env);
	}

	public Value visit(ReadExp e, Env env) {
		StringVal fileName = (StringVal) e.file().accept(this, env);
		try {
			String text = Reader.readFile("" + System.getProperty("user.dir") + File.separator + fileName.v());
			return new StringVal(text);
		} catch (IOException ex) {
			return new DynamicError(ex.getMessage());
		}
	}

	private Env initialEnv() {
		GlobalEnv initEnv = new GlobalEnv();

		/* Procedure: (read <filename>). Following is same as (define read (lambda (file) (read file))) */
		List<String> formals = new ArrayList<>();
		formals.add("file");
		Exp body = new AST.ReadExp(new VarExp("file"));
		Value.FunVal readFun = new Value.FunVal(initEnv, formals, body);
		initEnv.extend("read", readFun);

		/* Procedure: (require <filename>). Following is same as (define require (lambda (file) (eval (read file)))) */
		formals = new ArrayList<>();
		formals.add("file");
		body = new EvalExp(new AST.ReadExp(new VarExp("file")));
		Value.FunVal requireFun = new Value.FunVal(initEnv, formals, body);
		initEnv.extend("require", requireFun);

		/* Add new built-in procedures here */

		return initEnv;
	}

	Reader _reader;
	public Evaluator(Reader reader) {
		_reader = reader;
	}
}
