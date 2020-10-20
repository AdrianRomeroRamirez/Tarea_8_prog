package ejercicios;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import utilidades.ES;

/**
 * Ejercicio 1. Vaciando la lista.
 *
 * En este ejercicio tendrás que crear una lista de enteros. En dicha lista
 * debes introducir números entre 1 y 5 (ambos incluidos), los cuales serán
 * generados aleatoriamente. La cantidad de números a introducir en la lista
 * será solicitada al usuario (que deberá indicar un mínimo de 10 y un máximo de
 * 20).
 *
 * Después se irá preguntando progresivamente al usuario que número eliminar,
 * hasta que la lista esté vacía. Si un número no está en la lista, se indicará
 * al usuario que dicho número no está en la lista, pero si un número si está en
 * la lista, se eliminará todas las apariciones del mismo.
 *
 * @author Adrián Romero Ramírez
 */
public class Ejercicio1VaciandoLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declaro los objetos y variables necesarios
        LinkedList<Integer> lista = new LinkedList<>();
        Random rndm = new Random();
        int tamañoLista, numAEliminar;

        // Pido al usuario el tamaño de la lista
        tamañoLista = ES.leeEntero("Introduce un número entre 10 y 20:", 10, 20);

        // Relleno la lista con número aleatorios
        while (lista.size() < tamañoLista) {
            lista.add(rndm.nextInt(5) + 1);
        }

        // Creo un bucle que no termina hasta que la lista no esté vacía
        while (!lista.isEmpty()) {

            // Muestro la lista por pantalla
            System.out.print("*");
            for (int i : lista) {
                System.out.print(i);
            }
            System.out.println("*");

            // Pido el número a borrar
            numAEliminar = ES.leeEntero("Introduce el número a eliminar:");

            // Uso un metodo que he creado para borrar todos los objetos iguales de la lista
            // y muestra un mensaje en caso que no exista ese número en la lista
            System.out.print(eliminarNumero(lista, numAEliminar));
        }
    }

    /**
     * Metodo que se usa para borrar todas las instancias de un objeto integer
     * pasado or parametro en la lista pasada también por parametro
     *
     * @param lista donde se quiere borrar todas las instancias de integer
     * @param numero que se quiere borrar
     * @return frase que retorna si no encuentra ninguna instancia de ese objeto
     */
    private static String eliminarNumero(List<Integer> lista, Integer numero) {
        String noEsta = "";

        if (lista.indexOf(numero) == -1) {
            noEsta = "El número " + numero + " no está en la lista\n";
        }

        while (lista.indexOf(numero) != -1) {
            lista.remove(numero);
        }

        return noEsta;
    }

}
