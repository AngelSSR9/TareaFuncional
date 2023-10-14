package clasesTarea;

import interfacesTarea.Predicado;

public class PairFilter implements Predicado {
    @Override
    public boolean test(Integer num) {
        return num % 2 == 0;
    }
}
