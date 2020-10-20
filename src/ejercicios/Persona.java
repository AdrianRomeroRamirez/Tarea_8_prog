package ejercicios;

/**
 * 
 * @author Adrián Romero Ramírez
 */
public class Persona {
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad)
    {
        this.edad=edad;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
       
}