package utilidades ;

import java.util.Scanner;

/**
 * Esta clase define algunos métodos para entrada de datos, de forma que se 
 * capturen los errores de entrada sin abortar, en caso de que el usuario 
 * introduzca datos no válidos.
 * También incluye un par de métodos para simplificar la escritura de mensajes
 * en pantalla, abreviando la escritura de las sentencias System.out.println()
 * y System.out.print(). Se hace uso también de la sobrecarga de métodos, 
 * que es algo que se había visto con los constructores, pero sin entrar en
 * detalle. Así, podemos tener tres métodos para leer enteros, que se llaman 
 * todos igual, pero que se diferencian en su lista de parámetros. 
 * 
 * @author Profesor
 */
public class ES {
    
    /**
     * Códigos de color para ser usados a la hora de mostrar texto por pantalla
     * o como colores de fondo.     
     */
    public enum ColorTexto {  
        RESET(0),
        NEGRO(30),
        ROJO(31),
        VERDE(32),
        AMARILLO(33),
        AZUL(34),
        MAGENTA(35),
        CYAN(36),
        BLANCO(37)
        ;

        private final int colorCode;

        ColorTexto(int colorCode) {
            this.colorCode = colorCode;
        }
        
        /**
         * Obtiene la secuencia de escape ANSI asociada al color de texto.
         * @return Cadena con la secuencia de escape.
         */
        public final String codigoColorTexto() {
            return "\33[".concat(String.valueOf(this.colorCode)).concat("m");
        }
        /**
         * Obtiene la secuencia de escape ANSI asociada al color de fondo.
         * @return Cadena con la secuencia de escape.
         */
        public final String codigoColorFondo ()
        {
            return "\33[".concat(String.valueOf(this.colorCode+10)).concat("m");
        }        
    }
    
    /**
     * Este método sirve para leer desde teclado cualquier número entero en el
     * rango de números del tipo int. La lectura se estará repitiendo hasta que
     * el valor suministrado esté en ese rango.
     *
     * @return El número entero leído.
     */
    public static int leeEntero() {
        boolean leido = false;
        int numero = 0;
        Scanner teclado = null;
        do {
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                leido = true;
            } catch (Exception e) {
                ES.msgln("Error: No es un número entero válido. ");
            }

        } while (!leido);
        return numero;
    }

    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int, que será el
     * dato leído. La lectura se estará repitiendo hasta que el valor
     * suministrado esté en ese rango.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @return El número entero leído.
     */
    public static int leeEntero(String mensaje) {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        do {
            ES.msgln(mensaje);
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                leido = true;
            } catch (Exception e) {
                ES.msgln("Error: No es un número entero válido. ");
            }
        } while (!leido);
        return numero;
    }

    /**
     * Este método sirve para leer desde teclado cualquier número entero en el
     * rango de números del tipo int que además sea mayor o igual que el valor
     * mínimo indicado como parámetro. La lectura se estará repitiendo hasta que
     * el valor suministrado esté en ese rango.
     *
     * @param minimo Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     */
    public static int leeEntero(int minimo) {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        do {
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                if (numero >= minimo) {
                    leido = true;
                } else {
                    ES.msgln("Error: Debe ser un número entero mayor o igual que " + minimo + ". ");
                }
            } catch (Exception e) {
                ES.msgln("Error: No es un número entero válido. ");
            }
        } while (!leido);
        return numero;
    }

    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int que además
     * sea mayor o igual que el valor mínimo indicado como parámetro. La lectura
     * se estará repitiendo hasta que el valor suministrado esté en ese rango.
     *
     * @param mensaje  Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param minimo  Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     */
    public static int leeEntero(String mensaje, int minimo) {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        do {
            ES.msgln(mensaje);
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                if (numero >= minimo) {
                    leido = true;
                } else {
                    ES.msgln("Error: Debe ser un número entero mayor o igual que " + minimo + ".");
                }
            } catch (Exception e) {
                ES.msgln("Error: No es un número entero válido. ");
            }

        } while (!leido);
        return numero;
    }

    /**
     * Este método sirve para leer desde teclado cualquier número entero en el
     * rango de números del tipo int que además sea mayor o igual que el valor
     * mínimo indicado como primer parámetro y menor o igual que el valor m?ximo
     * indicado como segundo parámetro. La lectura se estará repitiendo hasta
     * que el valor suministrado esté en ese rango.
     *
     * @param minimo Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @param maximo Es el valor más alto dentro del rango de los números
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     * @throws IllegalArgumentException Lanza excepci?n si el parámetro mínimo
     *   es mayor que el mínimo.
     */
    public static int leeEntero(int minimo, int maximo) throws IllegalArgumentException {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;

        // Si el valor mínimo es mayor que el m?ximo, lanzamos una excepción
        if (minimo <= maximo) {
            do {
                try {
                    teclado = new Scanner(System.in);
                    numero = teclado.nextInt();
                    if (numero >= minimo && numero <= maximo) {
                        leido = true;
                    } else {
                        ES.msgln("Error: Debe ser un número entero mayor o igual que " + minimo + " y menor o igual que " + maximo + ". ");
                    }
                } catch (Exception e) {
                    ES.msgln("Error: No es un número entero válido. ");
                }
            } while (!leido);
        } else {
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor m?ximo");
        }
        return numero;
    }

    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int que además
     * sea mayor o igual que el valor mínimo indicado como primer parámetro y
     * menor o igual que el valor m?ximo indicado como segundo parámetro. La
     * lectura se estará repitiendo hasta que el valor suministrado esté en ese
     * rango.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param minimo Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptar? como válido.
     * @param maximo Es el valor más alto dentro del rango de los números.
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     * @throws IllegalArgumentException Lanza excepci?n si el parámetro mínimo
     *   es mayor que el mínimo.
     */
    public static int leeEntero(String mensaje, int minimo, int maximo) throws IllegalArgumentException {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;

        // Si el valor mínimo es mayor que el m?ximo, lanzamos una excepción
        if (minimo <= maximo) {
            do {
                ES.msgln(mensaje);
                try {
                    teclado = new Scanner(System.in);
                    numero = teclado.nextInt();
                    if (numero >= minimo && numero <= maximo) {
                        leido = true;
                    } else {
                        ES.msgln("Error: Debe ser un número entero mayor o igual que " + minimo + " y menor o igual que " + maximo + ". ");
                    }
                } catch (Exception e) {
                    ES.msgln("Error: No es un número entero válido. ");
                }
            } while (!leido);
        } else {
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor m?ximo");
        }
        return numero;
    }    

    /**
     * Este método lee una cadena de caracteres desde teclado, y comprueba que
     * efectivamente la lectura se ha producido correctamente, mandando un
     * mensaje de error en caso de que haya fallado.
     *
     * @return La cadena de caracteres leído desde el teclado.
     */
    public static String leeCadena() {
        Scanner teclado = new Scanner(System.in);
        String cadena = "";
        try {
            cadena = teclado.nextLine();
        } catch (Exception e) {
            ES.msgln("Error: Ha fallado la entrada de datos.");
        }
        return cadena;
    }

    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, espera la introducción de una
     * cadena de caracteres desde teclado, y comprueba que efectivamente la
     * lectura se ha producido correctamente, mandando un mensaje de error en
     * caso de que haya fallado.
     *
     * @param mensaje Es el mensaje que se env?a solicitando la introducción
     * de la cadena de texto.
     * @return La cadena de caracteres leído desde el teclado.
     */
    public static String leeCadena(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        String cadena = "";
        try {
            ES.msgln(mensaje);
            cadena = teclado.nextLine();
        } catch (Exception e) {
            ES.msgln("Error: Ha fallado la entrada de datos.");
        }
        return cadena;
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.print(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param entero  Es es el valor entero de tipo int a imprimir como texto.
     */
    public static void msg(int entero) {
        System.out.print(entero);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.print(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param enteroLargo Es es el valor entero de tipo long a imprimir como
     * texto.
     */
    public static void msg(long enteroLargo) {
        System.out.print(enteroLargo);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.print(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param real  Es es el valor real de tipo float a imprimir como texto.
     */
    public static void msg(float real) {
        System.out.print(real);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.print(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param realLargo Es es el valor entero de tipo double a imprimir como
     * texto.
     */
    public static void msg(double realLargo) {
        System.out.print(realLargo);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.print(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param cadenaAImprimir Es la cadena de texto que hay que escribir en
     * el dispositivo de salida estándar.
     */
    public static void msg(String cadenaAImprimir) {
        System.out.print(cadenaAImprimir);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.println(),
     * cuando se invoca sin parámetros, pero tiene la ventaja de que su
     * escritura es más corta y ahorra algo de trabajo en programas donde la
     * sentencia System.out.println() se use mucho.
     */
    public static void msgln() {
        System.out.println();
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.println(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param entero Es es el valor entero de tipo int a imprimir como texto.
     */
    public static void msgln(int entero) {
        System.out.println(entero);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.println(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param enteroLargo Es es el valor entero de tipo long a imprimir como
     * texto.
     */
    public static void msgln(long enteroLargo) {
        System.out.println(enteroLargo);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.println(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param real Es es el valor real de tipo float a imprimir como texto.
     */
    public static void msgln(float real) {
        System.out.println(real);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.println(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param realLargo Es es el valor entero de tipo double a imprimir como
     * texto.
     */
    public static void msgln(double realLargo) {
        System.out.println(realLargo);
    }

    /**
     * Este método hace exactamente lo mismo que el método System.out.println(),
     * pero tiene la ventaja de que su escritura es más corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param cadenaAImprimir Es la cadena de texto que hay que escribir en
     * el dispositivo de salida estándar.
     */
    public static void msgln(String cadenaAImprimir) {
        System.out.println(cadenaAImprimir);
    }

    /**
     * Lee desde teclado una respuesta para una pregunta de tipo Sí o No,
     * mostrando por pantalla la pregunta en cuestión. Sólo se admiten como
     * respuestas S, s, N o bien n.
     *
     * @param mensaje  Es el mensaje que se env?a con la pregunta cuya
     * respuesta se espera que sea S o N.
     * @return la cadena "S" si se ha respondido "S" o "s" y la cadena "N" si se
     * ha respondido "N" o "n".
     */
    public static String leeRespuesta(String mensaje) {
        boolean correcta = false;
        String cadena = "";
        Scanner teclado = null;
        do {
            ES.msgln(mensaje);
            try {
                teclado = new Scanner(System.in);
                cadena = teclado.nextLine();
                if ( cadena!= null && cadena.length() == 1 && ((cadena.equalsIgnoreCase("S")) || (cadena.equalsIgnoreCase("N")))) {
                    correcta = true;
                } else {
                    ES.msgln("Error: Solo se admite como respuesta un único carácter, que debe ser 's', 'S', 'n' o 'N'.");
                }
            } catch (Exception e) {
                ES.msgln("Error: Ha fallado la entrada de datos.");
            }
        } while (!correcta);
        return cadena.toUpperCase();
    }
    
    
    /**
     * Lee un carácter de teclado.
     * @param mensaje Mensaje a mostrar por pantalla
     * @return El carácter leído por teclado.
     */
    public static char leeCaracter(String mensaje) {
      
        Scanner teclado = null;
        teclado = new Scanner(System.in);
        ES.msgln(mensaje);
        String cadena=teclado.next();
        char caracter = cadena.charAt(0); 
        return caracter ;
    }
    
    /**
     * Método que permite establecer el color de texto mostrado por pantalla.
     * @param c Uno de los valores del enumerado ColorTexto.
     * @see ES.ColorTexto
     */
    public static void establecerColorTexto (ColorTexto c)
    {
        System.out.print(c.codigoColorTexto());
    }
    
    /**
     * Método que permite establecer el color de fondo para el texto mostrado por pantalla.
     * @param c Uno de los valores del enumerado ColorTexto.
     * @see ES.ColorTexto
     */
    public static void establecerColorFondo (ColorTexto c)
    {
        System.out.print(c.codigoColorFondo());
    }
    
    /**
     * Método que permite reestablecer a los valores por defecto el color del 
     * texto y el color de fondo.     
     */
    public static void resetearColores ()
    {
        System.out.print("\33[0m");
    }
    
    /**
     * Metodo que evalua el NIF del paciente para saber si es correcto
     * @param nif NIF o NIE del paciente
     * @return true o false dependiendo si es correcto o no el nif pasado por parametro
     */
    public static boolean checkNif(String nif){
        boolean check = false;
        String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKET";
        String patternNif = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        String patternNie = "^[XYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKET]$";
        
        if(nif.matches(patternNif) || nif.matches(patternNie)){
            if(nif.matches(patternNie)){
                nif = nif.replaceFirst("X", "0");
                nif = nif.replaceFirst("Y", "1");
                nif = nif.replaceFirst("Z", "2");
            }
            
            int numero = Integer.parseInt(nif.substring(0, 8));
            char letra = nif.charAt(8);
            int resto = numero%23;
            
            check = (letra==letrasValidas.charAt(resto));
        }
        return check;
    }
    
    /**
     * Metodo que evalua el email del paciente para saber si es correcto
     * @param email Email del paciente
     * @return true o false dependiendo si es correcto o no el email pasado por parametro
     */
    public static boolean checkEmail(String email){
        boolean check;
        String pattern = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        check = email.matches(pattern);
        return check;
    }
    
}//class ES