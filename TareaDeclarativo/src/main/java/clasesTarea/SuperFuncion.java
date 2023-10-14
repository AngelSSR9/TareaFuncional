package clasesTarea;

import interfacesTarea.*;

import java.util.ArrayList;
import java.util.List;

public class SuperFuncion {
    public static List<Integer> filter(List<Integer> numbers, Predicado
            predicado) {
        List<Integer> auxList = new ArrayList<Integer>();
        for (int i = 0; i < numbers.size(); i++) {
            if (predicado.test(numbers.get(i))) {
                auxList.add(numbers.get(i));
            }
        }
        return auxList;
    }
    public static List<Integer> proveer(int size, Proveedor proveedor) {
        List<Integer> auxList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            auxList.add(proveedor.obtener());
        }
        return auxList;
    }


    public static List<Integer> transform(List<Integer> pairs, Funcion squareFunction) {
        List<Integer> auxList = new ArrayList<Integer>();
        for(Integer integer : pairs){
            auxList.add(squareFunction.aplicar(integer));
        }
        return auxList;
    }


    public static List<Integer> perform(List<Integer> squareNumbers, Consumidor impresor) {
        List<Integer> auxList = new ArrayList<Integer>();
        for(Integer integer : squareNumbers){
            impresor.aceptar(integer);
            auxList.add(integer);
        }
        return auxList;
    }

    public static void consume(List<Integer> squareNumbers, Consumidor impresor) {
        for(Integer integer : squareNumbers){
            impresor.aceptar(integer);
        }
    }

    public static int  reduce(List<Integer> squareNumbers, int i, FuncionBinaria sumFunction) {
        int resultado = i;
        for(Integer numero : squareNumbers){
                resultado = sumFunction.aplicar(resultado, numero);
        }
        return resultado;
    }
}
