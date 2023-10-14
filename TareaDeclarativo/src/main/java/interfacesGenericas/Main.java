package interfacesGenericas;

import interfacesGenericas.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int resultado = ClaseFlujo.proveer(4, new Proveedor<Integer>() {
            Random random = new Random();
            @Override
            public Integer obtener() {
                return random.nextInt(10);
            }
        }).filter(new Predicado<Integer>() {
            @Override
            public boolean test(Integer valor) {
                return valor % 2 == 0;
            }
        }).transform(new OperadorUnario<Integer>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor*valor;
            }
        }).perform(new Consumidor<Integer>() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        }).reduce(0, new OperadorBinario<Integer>() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1+valor2;
            }
        });

        System.out.println("El resultado es: " + resultado);

    }

}
