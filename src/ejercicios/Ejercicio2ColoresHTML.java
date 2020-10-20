package ejercicios;

import java.util.HashMap;
import java.util.Map;
import utilidades.ES;

/**
 * Ejercicio 2. Dime el color.
 *
 * En este ejercicio debes partir de dos arrays (que no se pueden modificar).
 *
 * El array1 contiene una relación de colores tal y como los conocemos en
 * español, mientras que el array2 contiene el mismo color en formato
 * hexadecimal (tal y como se utiliza en la web). La idea es que hagas un
 * pequeño programa, que utilizando uno o dos mapas de forma adecuada (no se
 * puede utilizar ninguna colección de otro tipo) realice diferentes opciones.
 *
 * @author Adrián Romero Ramírez
 */
public class Ejercicio2ColoresHTML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declaro los arrays, el String y el mapa necesario par ael ejercicio
        String[] array1 = {"Negro", "Blanco", "Rojo", "Verde", "Azul",
            "Amarillo", "Cyan", "Magenta", "Plata", "Gris", "Granate", "Oliva",
            "Verde oscuro", "Morado", "Turquesa", "Azul oscuro"};
        String[] array2 = {"#000000", "#ffffff", "#FF0000", "#00ff00",
            "#0000FF", "#FFFF00", "#00FFFF", "#FF00FF", "#c0c0c0", "#808080", "#800000",
            "#808000", "#008000", "#800080", "#008080", "#000080"};
        String opcion;
        HashMap<String, String> mapa = new HashMap<>();

        // Relleno el mapa con los valores de los arrays, poniendolo todo en minuscula
        // y quitando el asterisco del array2
        for (int i = 0; i < array1.length; i++) {
            String sinHashtag = array2[i].substring(1);
            mapa.put(array1[i].toLowerCase(), sinHashtag.toLowerCase());
        }

        // Con un bucle do/while reitero hasta que el usuario introduce salir o exit
        do {

            // Pido al  usuario que introduzca la opcion y la paso a minuscula
            opcion = ES.leeCadena("Introduce un comando, el nombre del color o el del código:");
            String opcionMinusculas = opcion.toLowerCase();

            // Si la opcion es un llave del mapa, muestra su valor
            if (mapa.containsKey(opcionMinusculas)) {
                System.out.println("    El código es: " + mapa.get(opcionMinusculas).toUpperCase());
            }

            // Si la opcion es un valor del mapa, muestra la llave
            if (mapa.containsValue(opcionMinusculas)) {
                for (String llave : mapa.keySet()) {
                    if (mapa.get(llave).equals(opcionMinusculas)) {
                        System.out.println("    El nombre del color es: " + llave);
                    }
                }
            }

            // Si el usuario pide que se liste el mapa, se hace uso del metodo listar()
            if ("list".equalsIgnoreCase(opcion) || "listar".equalsIgnoreCase(opcion)) {
                System.out.println(listar(mapa));
            }
            

        } while (!"salir".equalsIgnoreCase(opcion) && !"exit".equalsIgnoreCase(opcion));

    }

    /**
     * Metodo que sirve para crear una lista con todos los pares de valores
     * instertados en el mapa
     *
     * @param mapa del cual se quiere listar todos sus valores
     * @return String con la lista completa
     */
    private static String listar(Map<String, String> mapa) {
        StringBuilder cad = new StringBuilder();
        for (String llave : mapa.keySet()) {
            cad.append("- ");
            cad.append(llave);
            cad.append(" = #");
            cad.append(mapa.get(llave).toUpperCase());
            cad.append("\n");
        }
        return cad.toString();
    }

}
