package typelang;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import typelang.AST.*;
import typelang.Env.ExtendEnv;
import typelang.Env.GlobalEnv;
import typelang.Type.*;

public class Checker implements Visitor<Type,Env<Type>> {
	Printer.Formatter ts = new Printer.Formatter();
	Env<Type> initEnv = initialEnv(); //New for definelang
	
	private Env<Type> initialEnv() {
		GlobalEnv<Type> initEnv = new GlobalEnv<Type>();
		
		/* Type for procedure: (read <filename>). Following is same as (define read (lambda (file) (read file))) */
		List<Type> formalTypes = new ArrayList<Type>();
		formalTypes.add(new Type.StringT());
		initEnv.extend("read", new Type.FuncT(formalTypes, new Type.StringT()));

		/* Type for procedure: (require <filename>). Following is same as (define require (lambda (file) (eval (read file)))) */
		formalTypes = new ArrayList<Type>();
		formalTypes.add(new Type.StringT());
		initEnv.extend("eval", new Type.FuncT(formalTypes, new Type.UnitT()));
		
		/* Add type for new built-in procedures here */ 
		
		return initEnv;
	}
	
    Type check(Program p) {
		return (Type) p.accept(this, null);
	}

	public Type visit(Program p, Env<Type> env) {
		Env<Type> new_env = initEnv;

		for (DefineDecl d: p.decls()) {
			Type type = (Type)d.accept(this, new_env);

			if (type instanceof ErrorT) { return type; }

			Type dType = d.type();

			if (!type.typeEqual(dType)) {
				return new ErrorT("Expected " + dType + " found " + type + " in " + ts.visit(d, null));
			}

			new_env = new ExtendEnv<Type>(new_env, d.name(), dType);
		}
		return (Type) p.e().accept(this, new_env);
	}

	public Type visit(VarExp e, Env<Type> env) {
		try {
			return env.get(e.name());
		} catch(Exception ex) {
			return new ErrorT("Variable " + e.name() +
					" has not been declared in " + ts.visit(e, null));
		}
	}

	public Type visit(LetExp e, Env<Type> env) {
		List <Exp> value_exps = e.value_exps();
		List<String> names = e.names();
		List<Type> values = new ArrayList<>(value_exps.size());
		for(int i = 0; i < value_exps.size(); i++){
			Exp exp = value_exps.get(i);
			Type type = (Type)exp.accept(this, env);
			values.add(type);
		}
		for(int i = 0; i < names.size(); i++){
			initEnv = new ExtendEnv<>(initEnv, names.get(i), values.get(i));
		}
		return (Type) e.body().accept(this, initEnv);
	}

	public Type visit(DefineDecl d, Env<Type> env) {
		String name = d.name();
		Type t =(Type) d._value_exp.accept(this, env);
		((GlobalEnv<Type>) initEnv).extend(name, t);
		return t;
	}

	public Type visit(LambdaExp e, Env<Type> env) {
		List<String> names = e.formals();
		List<Type> types = e.types();
		String message = "The number of formal parameters and the number of "
				+ "arguments in the function type do not match in ";
		if (types.size() == names.size()) {
			Env<Type> new_env = env;
			int index = 0;
			for (Type argType : types) {
				new_env = new ExtendEnv<Type>(new_env, names.get(index),
						argType);
				index++;
			}

			Type bodyType = (Type) e.body().accept(this, new_env);
			return new FuncT(types,bodyType);
		}
		return new ErrorT(message + ts.visit(e, null));
	}

	public Type visit(CallExp e, Env<Type> env) {
		return null;	}

	public Type visit(IfExp e, Env<Type> env) {
		return null;	}

	public Type visit(CarExp e, Env<Type> env) {
		Exp exp = e.arg();
		Type type = (Type) exp.accept(this, env);
		if(type instanceof ErrorT){
			return type;
		}else if(type instanceof PairT){
			return ((PairT) type).fst();
		}else{
			return new ErrorT("The car expect an expression of type Pair, found " + type.tostring() +
					" in " + ts.visit(e, null));
		}
	}

	public Type visit(CdrExp e, Env<Type> env) {
		Exp exp = e.arg();
		Type type = (Type)exp.accept(this, env);
		if(type instanceof ErrorT){
			return type;
		}else if(type instanceof PairT){
			return ((PairT) type).snd();
		}else{
			return new ErrorT("The cdr expect an expression of type pair, found " + type.tostring() +
					" in " + ts.visit(e, null));
		}
	}

	public Type visit(ConsExp e, Env<Type> env) {
		Exp fst = e.fst(); 
		Exp snd = e.snd();

		Type t1 = (Type)fst.accept(this, env);
		if (t1 instanceof ErrorT) { return t1; }

		Type t2 = (Type)snd.accept(this, env);
		if (t2 instanceof ErrorT) { return t2; }

		return new PairT(t1, t2);
	}

	public Type visit(ListExp e, Env<Type> env) {
		List<Exp> elements = e.elems();
		Type type = e.type();
		for(int i = 0; i < elements.size(); i++){
			Exp element = elements.get(i);
			Type elemType = (Type)element.accept(this, env);
			//If errort return type
			if(elemType instanceof ErrorT){
				return elemType;
			}else if(!assignable(type, elemType)){
				//"If type of any ei is an expression of an element of a list is not t then type oflist is errort with given message
				return new ErrorT("The " + i + " expression should have type " + type.tostring() + " found " +
						elemType.tostring() + " in " + ts.visit(e, null));
			}
		}
		//else type is listt
		return new ListT(type);
	}

	public Type visit(NullExp e, Env<Type> env) {
		Exp arg = e.arg();
		Type type = (Type)arg.accept(this, env);
		if (type instanceof ErrorT) { return type; }

		if (type instanceof ListT) { return BoolT.getInstance(); }

		return new ErrorT("The null? expect an expression of type List, found "
				+ type.tostring() + " in " + ts.visit(e, null));
	}

	public Type visit(RefExp e, Env<Type> env) {
		Exp value = e.value_exp();
		Type expressionType = (Type) value.accept(this, env);
		Type type = e.type();
		if(type instanceof  ErrorT){
			return type;
		}else if(expressionType.typeEqual(type)){
			return new RefT(type);
		}else{
			return new ErrorT("The Ref expression expect type " + type.tostring() + ", found " + expressionType.tostring() + " in " + ts.visit(e, null));
		}
	}
//
//	public Type visit(BinaryComparator e, Env<Type> env){
//
//		return null;
//	}

	public Type visit(DerefExp e, Env<Type> env) {
		return null;	}

	public Type visit(AssignExp e, Env<Type> env) {
		Exp lhs_exp = e.lhs_exp();
		Type lType = (Type)lhs_exp.accept(this, env);
		if(lType instanceof ErrorT){
			return lType;
		}else if(lType instanceof RefT){
			//Check e2's type
			Exp rhs_exp = e.rhs_exp();
			Type rType = (Type)rhs_exp.accept(this, env);
			RefT reft = (RefT) lType;
			Type reftNestType = reft.nestType();
			//If e2 type == errorT then ret rtype || If e2 type == T type then ret rtype
			if(rType instanceof ErrorT || rType.typeEqual(reftNestType)){
				return rType;
			}else{
				return new ErrorT("The inner type of the reference type is " + reftNestType.tostring() +
						" the rhs type is " + rType.tostring() + " in " + ts.visit(e, null));
			}
		}
		//(set! 0 1)   Test case via rangeet pan
		return new ErrorT("The lhs of the assignment expression expect a reference type found "
				+ lType.tostring() + " in " + ts.visit(e, null));
	}

	public Type visit(FreeExp e, Env<Type> env) {
		Exp exp = e.value_exp();
		Type type = (Type)exp.accept(this, env);

		if (type instanceof ErrorT) { return type; }

		if (type instanceof RefT) { return UnitT.getInstance(); }

		return new ErrorT("The free expression expect a reference type " +
				"found " + type.tostring() + " in " + ts.visit(e, null));
	}

	public Type visit(UnitExp e, Env<Type> env) {
		return Type.UnitT.getInstance();
	}

	public Type visit(NumExp e, Env<Type> env) {
		return NumT.getInstance();
	}

	public Type visit(StrExp e, Env<Type> env) {
		return Type.StringT.getInstance();
	}

	public Type visit(BoolExp e, Env<Type> env) {
		return Type.BoolT.getInstance();
	}

	public Type visit(LessExp e, Env<Type> env) {
		return visitBinaryComparator(e, env, ts.visit(e, null));
	}

	public Type visit(EqualExp e, Env<Type> env) {
		return visitBinaryComparator(e, env, ts.visit(e, null));
	}

	public Type visit(GreaterExp e, Env<Type> env) {
		return visitBinaryComparator(e, env, ts.visit(e, null));
	}

	private Type visitBinaryComparator(BinaryComparator e, Env<Type> env,
			String printNode) {
		Exp first_exp = e.first_exp();
		Type first_exp_type = (Type) first_exp.accept(this, env);
		Exp second_exp = e.second_exp();
		Type second_exp_type = (Type) second_exp.accept(this, env);
//		if(first_exp_type instanceof ErrorT || second_exp_type instanceof ErrorT){
//			return new ErrorT("");
//		}
		if(first_exp_type instanceof ErrorT){
			return first_exp_type;
		}else if(second_exp_type instanceof ErrorT){
			return second_exp_type;
		}else{
			//If neither are Error then check if both are num, if so then we're good if not then we're not
			//So check if first is not numt and output if its not, then the same but for snd
			if(!(first_exp_type instanceof NumT || first_exp_type instanceof ListT)){
				return new ErrorT("First expression type was " + first_exp_type.tostring() + ", should be Num");
			}else if(!(second_exp_type instanceof NumT || second_exp_type instanceof ListT)){
				return new ErrorT("Second expression type was " + second_exp_type.tostring() + ", should be Num");
			}

		}
		if(first_exp_type instanceof ListT){
			ListT first_exp_type_list = (ListT) first_exp.accept(this, env);
			ListExp one = (ListExp)first_exp.accept(this, env);
			List<Exp> elements = one.elems();

		}
		//BoolT.
		//IDK how to make it compare the list elements and return the correct boolT honestly

		return Type.BoolT.getInstance();
	}


	public Type visit(AddExp e, Env<Type> env) {
		return visitCompoundArithExp(e, env, ts.visit(e, null));
	}

	public Type visit(DivExp e, Env<Type> env) {
		return visitCompoundArithExp(e, env, ts.visit(e, null));
	}

	public Type visit(MultExp e, Env<Type> env) {
		return visitCompoundArithExp(e, env, ts.visit(e, null));
	}

	public Type visit(SubExp e, Env<Type> env) {
		return visitCompoundArithExp(e, env, ts.visit(e, null));
	}

	private Type visitCompoundArithExp(CompoundArithExp e, Env<Type> env, String printNode) {
		//DivExp and all the others latch into this so lets try to fix /0 errors here
//		List<Exp> ops = e.all();
//		for(Exp currOp: ops){
//			Type f = (Type) currOp.accept(this, env);
//			if(f instanceof NumT){
//				NumT ff = (NumT) f;
//				//Value fff = (Value) f;
//				//((NumExp) e)._val
//				//System.out.println(currOp + ":::" + printNode + ":::" + f.tostring());
//			}
//		}
		return null;
	}

	private static boolean assignable(Type t1, Type t2) {
		if (t2 instanceof UnitT) { return true; }

		return t1.typeEqual(t2);
	}
	
	public Type visit(ReadExp e, Env<Type> env) {
		return UnitT.getInstance();
	}

	public Type visit(EvalExp e, Env<Type> env) {
		return UnitT.getInstance();
	}


}
