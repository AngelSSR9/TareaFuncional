package clasesTarea;

import interfacesTarea.Consumidor;

public class Impresor implements Consumidor {
    @Override
    public void aceptar(Integer numero) {
        System.out.println(numero);
    }
}
