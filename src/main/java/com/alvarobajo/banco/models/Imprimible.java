package com.alvarobajo.banco.models;

/**
 * Interfaz Imprimible para proporcionar un método para obtener información en formato de cadena.
 * Implementada por clases que desean ser impresas de manera legible.
 *
 * @author Álvaro Bajo Tabero
 */
public interface Imprimible {

    /**
     * Devuelve la información de la instancia en formato de cadena.
     *
     * @return Información de la instancia en formato de cadena.
     */
    String devolverInfoString();
}
