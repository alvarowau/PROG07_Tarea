package com.alvarobajo.banco.models;

/**
 * Clase que representa a una persona con información básica.
 * Implementa la interfaz Imprimible para proporcionar una representación de cadena.
 *
 * @author Álvaro Bajo Tabero
 */
public class Persona implements Imprimible {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;

    /**
     * Constructor para inicializar una instancia de Persona.
     *
     * @param nombre    Nombre de la persona.
     * @param apellido1 Primer apellido de la persona.
     * @param apellido2 Segundo apellido de la persona.
     * @param dni       Documento Nacional de Identidad (DNI) de la persona.
     */
    public Persona(String nombre, String apellido1, String apellido2, String dni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
    }

    // Métodos de acceso y modificación para los atributos

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el primer apellido de la persona.
     *
     * @return El primer apellido de la persona.
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Establece el primer apellido de la persona.
     *
     * @param apellido1 El nuevo primer apellido de la persona.
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Obtiene el segundo apellido de la persona.
     *
     * @return El segundo apellido de la persona.
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Establece el segundo apellido de la persona.
     *
     * @param apellido2 El nuevo segundo apellido de la persona.
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Obtiene el Documento Nacional de Identidad (DNI) de la persona.
     *
     * @return El DNI de la persona.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el Documento Nacional de Identidad (DNI) de la persona.
     *
     * @param dni El nuevo DNI de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve la información de la persona en formato de cadena.
     *
     * @return Información de la persona en formato de cadena.
     */
    @Override
    public String devolverInfoString() {
        return "Información de la persona:\n" +
                "---------------------------\n" +
                "Nombre:      " + nombre + "\n" +
                "Apellido 1:  " + apellido1 + "\n" +
                "Apellido 2:  " + apellido2 + "\n" +
                "DNI:         " + dni + "\n" +
                "---------------------------";
    }
}
