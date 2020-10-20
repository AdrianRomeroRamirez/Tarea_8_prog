package ejercicios;

import java.util.LinkedHashSet;
import java.util.Random;
import utilidades.ES;

/**
 * Ejercicio 0. Una combinación aleatoria.
 * 
 * Utilizando un conjunto (Set), que como ya sabrás no almacenan duplicados, 
 * genera N números aleatorios en el rango de 1 a 2*N donde no haya repetidos. 
 * N será un número introducido por el usuario.
 * 
 * Por ejemplo, si N fuese 10, se escogerían 10 números aleatorios no repetidos 
 * en el rango que va desde 1 hasta 20 (2*10). Pero si N fuera 5, se escogerían 
 * 5 números aleatorios desde 1 hasta 10 (2*5).
 * 
 * Ten en cuenta que el N no podrá ser un número inferior a 1, por lo que se 
 * deberá volver a preguntar al usuario en caso de que introduzca un número erróneo. 
 * Recuerda que el único tipo de colección que puedes utilizar son conjuntos.
 * 
 * @author Adrián Romero Ramírez
 */
public class Ejercicio0Aleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        // Declaro el conjunto, una instancia de objeto random y la variable que guarda
        // la cantidad de números elejida por el usuario
        LinkedHashSet<Integer> conjunto = new LinkedHashSet<>();
        Random rndm = new Random();
        int cantidadNumeros;

        // Pido al usuario que elija la cantidad de números a mostrar
        cantidadNumeros = ES.leeEntero("Introduce el valor de N", 1);

        // Mientra el conjunto no alcanze el tamaño elejido por el usuario, estará
        // reiterando por el bucle añadiendo números aleatorios
        while (conjunto.size() != cantidadNumeros) {
            conjunto.add(rndm.nextInt(cantidadNumeros * 2) + 1);
        }

        // Se muestra por pantalla los números del conjunto
        System.out.print("Los numeros son: ");
        for (int i : conjunto) {
            System.out.print(i + " ");
        }
    }

}
