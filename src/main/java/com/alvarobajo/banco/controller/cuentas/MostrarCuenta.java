package com.alvarobajo.banco.controller.cuentas;

import com.alvarobajo.banco.controller.Banco;
import com.alvarobajo.banco.controller.LecturaTeclado;
import com.alvarobajo.banco.models.CuentaBancaria;

/**
 * Clase que proporciona métodos para mostrar información detallada de cuentas bancarias.
 *
 * @author Álvaro Bajo Tabero
 */
public class MostrarCuenta {

    private static final String MENSAJE_BUSCAR_TITULAR = "Ingrese el nombre del titular:";
    private static final String MENSAJE_BUSCAR_IBAN = "Ingrese el IBAN de la cuenta:";

    /**
     * Muestra la información de una cuenta bancaria por titular.
     *
     * @param banco El banco en el que buscar la cuenta.
     */
    public static void mostrarCuentaPorTitular(Banco banco) {
        String nombreTitular = LecturaTeclado.recogerTexto(MENSAJE_BUSCAR_TITULAR);
        CuentaBancaria cuenta = banco.buscarCuentaPorTitular(nombreTitular);

        if (cuenta != null) {
            System.out.println("Información de la cuenta para el titular " + nombreTitular + ":");
            System.out.println(cuenta.devolverInfoString());
        } else {
            System.out.println("No se encontró ninguna cuenta para el titular " + nombreTitular + ".");
        }
    }

    /**
     * Muestra la información de una cuenta bancaria por IBAN.
     *
     * @param banco El banco en el que buscar la cuenta.
     */
    public static void mostrarCuentaPorIBAN(Banco banco) {
        String iban = LecturaTeclado.recogerTexto(MENSAJE_BUSCAR_IBAN);
        CuentaBancaria cuenta = banco.buscarCuentaPorIBAN(iban);

        if (cuenta != null) {
            System.out.println("Información de la cuenta para el IBAN " + iban + ":");
            System.out.println(cuenta.devolverInfoString());
        } else {
            System.out.println("No se encontró ninguna cuenta para el IBAN " + iban + ".");
        }
    }

    /**
     * Muestra la información de una cuenta bancaria por IBAN.
     *
     * @param banco El banco en el que buscar la cuenta.
     * @param iban  El IBAN de la cuenta a mostrar.
     */
    public static void mostrarCuentaConcreta(Banco banco, String iban) {
        CuentaBancaria cuenta = banco.buscarCuentaPorIBAN(iban);

        if (cuenta != null) {
            System.out.println("Información de la cuenta para el IBAN " + iban + ":");
            System.out.println(cuenta.devolverInfoString());
        } else {
            System.out.println("No se encontró ninguna cuenta para el IBAN " + iban + ".");
        }
    }

    /**
     * Muestra un listado de todas las cuentas disponibles en el banco.
     *
     * @param banco El banco del que mostrar el listado.
     */
    public static void mostrarListado(Banco banco) {
        CuentaBancaria[] cuentas = banco.getCuentas();
        int numCuentas = banco.getNumCuentas();

        if (numCuentas > 0) {
            System.out.println("Listado de cuentas:");
            for (int i = 0; i < numCuentas; i++) {
                System.out.println(cuentas[i].devolverInfoString());
            }
        } else {
            System.out.println("No hay cuentas registradas en el banco.");
        }
    }
}
