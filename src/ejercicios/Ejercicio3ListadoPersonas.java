package ejercicios;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import utilidades.ES;

/**
 * Ejercicio 3. Una lista de personas.
 *
 * Crea un programa que utilizando una lista de personas permita hacer
 * operaciones de inserción de un registro, eliminación de un registro y listar
 * un registro.
 *
 * @author Adrián Romero Ramírez
 */
public class Ejercicio3ListadoPersonas implements Comparator<Persona> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creo la lista y las variables oportunas
        LinkedList<Persona> lista = new LinkedList<>();
        String opcion;

        // Dentro de un bucle, reitero hasta que el usuario teclee salir o exit
        do {

            // Pido al usuario que escriba lo que quiere hacer
            opcion = ES.leeCadena("¿Qué desea hacer ahora?");

            switch (opcion) {

                case "list":
                    ;
                case "listar":
                    System.out.println(listar(lista));
                    break;
                case "insertar":
                    ;
                case "add":
                    if (añadir(lista)) {
                        System.out.println("Añadido.");
                    } else {
                        System.out.println("No ha sido posible añadir a nadie.");
                    }
                    break;
                case "eliminar":
                    ;
                case "delete":
                    System.out.println(borrar(lista));
                    break;
                default:
                    if (!"salir".equalsIgnoreCase(opcion) && !"exit".equalsIgnoreCase(opcion)) {
                        System.out.println("      Operaciones válidas son:\n"
                                + "	   --> list o listar\n"
                                + "	   --> insertar o add\n"
                                + "	   --> eliminar o delete\n"
                                + "	   --> salir o exit");
                    }
            }

        } while (!"salir".equalsIgnoreCase(opcion) && !"exit".equalsIgnoreCase(opcion));
    }

    /**
     * Método que sirve para crear un String Con la lista de Personas creadas
     *
     * @param lista que se quiere listar
     * @return cadena con la lista
     */
    private static String listar(List<Persona> lista) {
        StringBuilder cad = new StringBuilder();
        for (Persona p : lista) {
            cad.append("      ");
            cad.append(p.getNombre());
            cad.append(" (").append(p.getEdad()).append(")");
            cad.append("\n");
        }
        return cad.toString();
    }

    /**
     * Método para añadir personas a la lista
     *
     * @param lista donde se quiere añadir la persona
     * @return boolean para saber si se ha añadido correctamente o no
     */
    private static boolean añadir(List<Persona> lista) {
        boolean añadido = false;
        String nombre = ES.leeCadena("Introduce el nombre de la persona:");
        int edad = ES.leeEntero("Introduce su edad (entre 1 y 99):", 1, 99);

        String respuesta = ES.leeRespuesta("¿Desea continuar con la operación (s/n)?");

        if ("S".equals(respuesta)) {
            lista.add(new Persona(nombre, edad));
            Collections.sort(lista, new Ejercicio3ListadoPersonas());
            añadido = true;
        }
        return añadido;
    }

    /**
     * Método para borrar Personas a partir del nombre
     *
     * @param lista donde se quiere borrar a la Persona
     * @return cadena que indica cuantos elementos han sido borrados
     */
    private static String borrar(List<Persona> lista) {
        String frase = "";
        LinkedList<Persona> listaABorrar = new LinkedList<>();
        int eliminados = 0;
        String nombre = ES.leeCadena("Introduce el nombre:");
        String respuesta = ES.leeRespuesta("¿Desea continuar con la operación (s/n)?");
        if ("S".equals(respuesta)) {
            for (Persona p : lista) {
                if (p.getNombre().equals(nombre)) {
                    listaABorrar.add(p);
                    eliminados++;
                }
            }
            lista.removeAll(listaABorrar);
            System.out.println("      Eliminados " + eliminados + " registros.");
        }
        return frase;
    }

    /**
     * Método para ordenar a las Personas por su edad
     *
     * @param p1 primera persona que se compara
     * @param p2 segunda persona que se compara
     * @return entero que dictamina si las personas comparadaras son mayores,
     * menores o iguales
     */
    @Override
    public int compare(Persona p1, Persona p2) {
        return new Integer(p1.getEdad()).compareTo(p2.getEdad());

    }
}
