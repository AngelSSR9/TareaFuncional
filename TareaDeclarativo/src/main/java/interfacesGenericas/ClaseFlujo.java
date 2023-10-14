package interfacesGenericas;

import java.util.ArrayList;
import java.util.List;

public class ClaseFlujo {

    private List<Integer> lista;

    private ClaseFlujo(List<Integer> lista) {
        this.lista = lista;
    }

    public static ClaseFlujo proveer(int size, Proveedor<Integer> proveedor) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lista.add(proveedor.obtener());
        }
        System.out.println("Nueva lista --> " + lista);
        return new ClaseFlujo(lista);
    }

    public ClaseFlujo filter(Predicado<Integer> predicate) {
        lista.removeIf(numero -> !predicate.test(numero));
        System.out.println("Lista filtrada --> " + lista);
        return this;
    }

    public ClaseFlujo transform(OperadorUnario<Integer> operadorUnario) {
        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, operadorUnario.aplicar(lista.get(i)));
        }
        System.out.println("Lista transformada --> " + lista);
        return this;
    }

    public ClaseFlujo perform(Consumidor<Integer> consumidor) {
        for (Integer numero : lista) {
            consumidor.aceptar(numero);
        }
        return this;
    }

    public Integer reduce(Integer identity, OperadorBinario<Integer> operadorBinario) {
        Integer resultado = identity;

        for (Integer numero : lista) {
            resultado = operadorBinario.aplicar(resultado, numero);
        }

        return resultado;
    }
}
