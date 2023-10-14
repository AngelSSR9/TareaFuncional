package clasesTarea;

import interfacesTarea.Proveedor;

import java.util.Random;

public class AleatorioPositivo implements Proveedor {
    Random random = new Random();
    @Override
    public Integer obtener() {
        return random.nextInt(10);
    }
}
