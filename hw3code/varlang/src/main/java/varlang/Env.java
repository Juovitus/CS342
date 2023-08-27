package varlang;

/**
 * Representation of an environment, which maps variables to values.
 * 
 * @author hridesh
 *
 */
public interface Env {
	Value get (String search_var);

	@SuppressWarnings("serial")
	static public class LookupException extends RuntimeException {
		LookupException(String message){
			super(message);
		}
	}
	
	static public class EmptyEnv implements Env {
		public Value get (String search_var) {
			if(search_var.length() == 1){
				char c = search_var.charAt(0);
				if(Character.isLetter(c)){
					int thisQuestionIsWordedSoFuckingBadly = c;
					Env ascii = new AsciiEnv(thisQuestionIsWordedSoFuckingBadly);
				}
			}
			throw new LookupException("No binding found for name: " + search_var);
		}
	}
	
	static public class ExtendEnv implements Env {
		private Env _saved_env; 
		private String _var; 
		private Value _val; 
		public ExtendEnv(Env saved_env, String var, Value val){
			_saved_env = saved_env;
			_var = var;
			_val = val;
		}
		public Value get (String search_var) {
			if (search_var.equals(_var))
				return _val;
			return _saved_env.get(search_var);
		}
	}

	static public class AngyEnv implements Env {
		public AngyEnv(String s){
			throw new LookupException("PROGRAM ANGRY!!!!!!" + "   Sidenote: " + s + "    (hopefully)");
		}
		public Value get (String search_var) {
			throw new LookupException("?????????");
		}
	}

	static public class AsciiEnv implements Env {
		public AsciiEnv(int num){
			//print out ascii IG
			throw new LookupException(String.valueOf(num));
		}
		public Value get (String search_var) {
			throw new LookupException("?????????");
		}
	}

	static public class EncEnv implements Env {
		private Env _saved_env;
		private String _var;
		private Value _val;

		public EncEnv(Env saved_env, String var, Value val, Value enc){
				_saved_env = saved_env;
				_var = var;
				double encryptedVal = Double.parseDouble(enc.toString()) + Double.parseDouble(val.toString());
				_val = new Value.NumVal(encryptedVal);
		}

		public Value get (String search_var) {
			if (search_var.equals(_var))
				return _val;
			return _saved_env.get(search_var);
		}
	}

	static public class DecEnv implements Env {
		private Env _saved_env;
		private String _var;
		private Value _val;

		public DecEnv(Env saved_env, String var, Value val, Value dec){
			_saved_env = saved_env;
			_var = var;
			double encryptedVal = Double.parseDouble(dec.toString()) + Double.parseDouble(val.toString());
			_val = new Value.NumVal(encryptedVal);
		}

		public Value get (String search_var) {
			if (search_var.equals(_var))
				return _val;
			return _saved_env.get(search_var);
		}
	}
	
}
