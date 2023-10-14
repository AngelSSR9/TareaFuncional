package clasesTarea;

import interfacesTarea.Predicado;

public class ImpairFilter implements Predicado {
    @Override
    public boolean test(Integer num) {
        return !(num % 2 == 0);
    }
}
