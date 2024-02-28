package com.alvarobajo.banco.controller.cuentas;

import com.alvarobajo.banco.controller.LecturaTeclado;
import com.alvarobajo.banco.models.Persona;

/**
 * Clase que proporciona métodos para la creación de objetos Persona con datos ingresados por el usuario.
 *
 * @author Álvaro Bajo Tabero
 */
public class CrearPersona {

    /**
     * Crea un objeto Persona con datos ingresados por el usuario.
     *
     * @return Objeto Persona creado.
     */
    public static Persona crearPersona() {
        String nombre = obtenerTexto("Ingrese el nombre:");
        String apellido1 = obtenerTexto("Ingrese el primer apellido:");
        String apellido2 = obtenerTexto("Ingrese el segundo apellido (puede ser vacío):");
        String dni = obtenerDNI("Ingrese el DNI:");

        return new Persona(nombre, apellido1, apellido2, dni);
    }

    /**
     * Obtiene un texto ingresado por el usuario, asegurándose de que no esté vacío.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return Texto ingresado por el usuario.
     */
    private static String obtenerTexto(String mensaje) {
        String texto;
        do {
            texto = LecturaTeclado.recogerTexto(mensaje + " (no puede estar vacío):");
            if (texto.isEmpty()) {
                System.out.println("Por favor, ingrese un valor válido.");
            }
        } while (texto.isEmpty());
        return capitalizarCadaPalabra(texto);
    }

    /**
     * Capitaliza la primera letra de cada palabra en un texto.
     *
     * @param texto Texto a capitalizar.
     * @return Texto con la primera letra de cada palabra en mayúscula.
     */
    private static String capitalizarCadaPalabra(String texto) {
        if (texto.isEmpty()) {
            return texto;
        }

        // Divide el texto en palabras y capitaliza la primera letra de cada palabra
        String[] palabras = texto.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                resultado.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1).toLowerCase()).append(" ");
            }
        }

        // Elimina el espacio adicional al final
        return resultado.toString().trim();
    }

    /**
     * Obtiene un DNI ingresado por el usuario, asegurándose de que tenga el formato correcto.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return DNI ingresado por el usuario.
     */
    private static String obtenerDNI(String mensaje) {
        String dni;
        do {
            dni = LecturaTeclado.recogerTexto(mensaje + " (debe tener 8 números seguidos por una letra):");
            if (dni.isEmpty() || !validarDNI(dni)) {
                System.out.println("Por favor, ingrese un DNI válido.");
            }
        } while (dni.isEmpty() || !validarDNI(dni));
        return dni;
    }

    /**
     * Valida si un DNI tiene el formato correcto.
     *
     * @param dni DNI a validar.
     * @return true si el formato es válido, false de lo contrario.
     */
    private static boolean validarDNI(String dni) {
        // Utilizar una expresión regular para validar el formato del DNI
        String regex = "\\d{8}[a-zA-Z]";

        if (!dni.matches(regex)) {
            System.out.println("El DNI debe tener 8 números seguidos por una letra.");
            return false;
        }

        // La validación fue exitosa
        return true;
    }
}
