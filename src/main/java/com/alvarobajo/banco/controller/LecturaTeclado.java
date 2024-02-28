package com.alvarobajo.banco.controller;

import java.util.Scanner;

/**
 * Clase que facilita la lectura de datos desde la entrada estándar.
 * Implementa la interfaz AutoCloseable para cerrar el recurso Scanner.
 * Utilizada para recoger textos, enteros y decimales desde el teclado.
 *
 * @author Álvaro Bajo Tabero
 */
public class LecturaTeclado implements AutoCloseable {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    /**
     * Escanea la entrada del usuario y devuelve un texto no vacío.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return Texto no vacío ingresado por el usuario.
     */
    private static String escaneoEntrada(String mensaje) {
        System.out.println(mensaje);
        return entradaTeclado.nextLine();
    }

    /**
     * Recoge un texto no vacío desde la entrada del usuario.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return Texto no vacío ingresado por el usuario.
     */
    public static String recogerTexto(String mensaje) {
        String texto;
        do {
            texto = escaneoEntrada(mensaje);
        } while (texto.isEmpty());
        return texto;
    }

    /**
     * Recoge un número entero desde la entrada del usuario.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return Número entero ingresado por el usuario.
     */
    public static int recogerEntero(String mensaje) {
        String recogido;
        do {
            recogido = escaneoEntrada(mensaje);
        } while (!isNumeroEntero(recogido));
        return Integer.parseInt(recogido);
    }

    /**
     * Recoge un número decimal desde la entrada del usuario.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return Número decimal ingresado por el usuario.
     */
    public static double recogerDecimal(String mensaje) {
        String recogido;
        do {
            recogido = escaneoEntrada(mensaje);
        } while (!isNumeroDecimal(recogido));
        return Double.parseDouble(recogido);
    }

    /**
     * Verifica si la cadena proporcionada es un número entero.
     *
     * @param numeroRecogido Cadena a verificar.
     * @return true si la cadena es un número entero; false, en caso contrario.
     */
    private static boolean isNumeroEntero(String numeroRecogido) {
        try {
            Integer.parseInt(numeroRecogido);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica si la cadena proporcionada es un número decimal.
     *
     * @param numeroRecogido Cadena a verificar.
     * @return true si la cadena es un número decimal; false, en caso contrario.
     */
    private static boolean isNumeroDecimal(String numeroRecogido) {
        try {
            // Permitir "," o "." como separadores decimales
            numeroRecogido = numeroRecogido.replace(",", ".");
            Double.parseDouble(numeroRecogido);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Método close() para cerrar el recurso Scanner al finalizar.
     */
    @Override
    public void close() {
        entradaTeclado.close();
    }


}
