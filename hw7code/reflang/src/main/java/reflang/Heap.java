package reflang;

public interface Heap {

    Value ref (Value value);
    Value deref (Value.RefVal loc);
    Value setref (Value.RefVal loc, Value value);
    Value free (Value.RefVal value);

    static public class Heap16Bit implements Heap {
        static final int HEAP_SIZE = 65_536;

        Value[] _rep = new Value[HEAP_SIZE];
        int index = 0;

        public Value ref (Value value) {
            if(index >= HEAP_SIZE)
                return new Value.DynamicError("Out of memory error");
            Value.RefVal new_loc = new Value.RefVal(index);
            _rep[index++] = value;
            return new_loc;
        }

        public Value deref (Value.RefVal loc) {
            try {
                return _rep[loc.loc()];
            } catch (ArrayIndexOutOfBoundsException e) {
                return new Value.DynamicError("Segmentation fault at access " + loc);
            }
        }

        public Value setref (Value.RefVal loc, Value value) {
            try {
                return _rep[loc.loc()] = value;
            } catch (ArrayIndexOutOfBoundsException e) {
                return new Value.DynamicError("Segmentation fault at access " + loc);
            }
        }

        public Value free (Value.RefVal loc) {
            try {
                if(_rep[loc.loc()] == null){
                    System.out.println("Wrong memory location(" + loc.tostring() + "). Already freed.");
                }else {
                    _rep[loc.loc()] = null;
                    return loc;
                }
                return null;
            } catch (ArrayIndexOutOfBoundsException e) {
                return new Value.DynamicError("Segmentation fault at access " + loc);
            }
        }

        public Heap16Bit(){}
    }

}