package clasesTarea;

import interfacesTarea.*;

import java.util.List;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        new Main2();
    }

    // Declarativo
    public Main2() {
        // a. Crear una lista de enteros.
        List<Integer> numbers = SuperFuncion.proveer(4, new
                Proveedor() {
                    Random random = new Random();

                    @Override
                    public Integer obtener() {
                        return random.nextInt(10);
                    }
                });
        System.out.println("Nueva Lista -->" + numbers);

        // b. Filtrar solo los números pares.
        List<Integer> pairs = SuperFuncion.filter(numbers, new
                Predicado() {
                    @Override
                    public boolean test(Integer num) {
                        return num % 2 == 0;
                    }
                });
        System.out.println("Números pares -->" + pairs);

        // c. Filtrar solo los números perfectos.
        List<Integer> impairs = SuperFuncion.filter(pairs, new Predicado() {
            @Override
            public boolean test(Integer num) {
                int resultado = 0;
                for (int divisor = num - 1; divisor > 0; divisor--) {
                    if (num % divisor == 0) {
                        resultado += divisor;
                    }
                }
                return num.equals(resultado);
            }
        });

        // d. Obtener el cuadrado de cada número.
        List<Integer> squareNumbers = SuperFuncion.transform(pairs, new Funcion() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor*valor;
            }
        });
        System.out.println("Números pares elevados al cuadrado -->" + squareNumbers);

        // e.1 Mostrar cada cuadrado por pantalla retornando lista.
        List<Integer> realNumbers = SuperFuncion.perform(squareNumbers, new Consumidor() {
            @Override
            public void aceptar(Integer numero) {
                System.out.println(numero);
            }
        });

        // e.2 Mostrar cada cuadrado por pantalla no retornando nada.
        SuperFuncion.consume(squareNumbers, new Consumidor() {
            @Override
            public void aceptar(Integer numero) {
                System.out.println(numero);
            }
        });

        // f. Obtener la suma de los cuadrados.
        int result = SuperFuncion.reduce(squareNumbers, 0, new FuncionBinaria() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1+valor2;
            }
        });
        System.out.println("La suma de los cuadrados --> " + result);

    }
}
