package com.alvarobajo.banco.controller;

import com.alvarobajo.banco.models.CuentaBancaria;

/**
 * Clase que representa un banco y gestiona cuentas bancarias.
 *
 * @author Álvaro Bajo Tabero
 */
public class Banco {

    private static final int MAX_CUENTAS = 100;
    private static CuentaBancaria[] cuentas;
    private static int numCuentas;

    /**
     * Constructor para inicializar una instancia de Banco.
     * Inicializa el array de cuentas y el número de cuentas registradas.
     */
    public Banco() {
        cuentas = new CuentaBancaria[MAX_CUENTAS];
        numCuentas = 0;
    }

    /**
     * Abre una nueva cuenta bancaria y la agrega al banco.
     *
     * @param nuevaCuenta Nueva cuenta bancaria a abrir.
     * @return true si la cuenta se abrió con éxito; false, si no se pudo abrir la cuenta.
     * @throws RuntimeException si se alcanza el límite de cuentas.
     */
    public boolean abrirCuenta(CuentaBancaria nuevaCuenta) {
        if (numCuentas < MAX_CUENTAS && !estaIBANEnUso(nuevaCuenta.getIban())) {
            cuentas[numCuentas] = nuevaCuenta;
            numCuentas++;
            return true;
        } else {
            throw new RuntimeException("No se pueden abrir más cuentas. Límite alcanzado.");
        }
    }

    /**
     * Lista todas las cuentas registradas en el banco.
     */
    public void listarCuentas() {
        if (numCuentas > 0) {
            System.out.println("Listado de cuentas:");
            for (int i = 0; i < numCuentas; i++) {
                System.out.println(cuentas[i]);
            }
        } else {
            System.out.println("No hay cuentas registradas en el banco.");
        }
    }

    /**
     * Busca una cuenta bancaria por el nombre del titular.
     *
     * @param nombreTitular Nombre del titular de la cuenta a buscar.
     * @return Cuenta bancaria encontrada o null si no se encuentra.
     */
    public CuentaBancaria buscarCuentaPorTitular(String nombreTitular) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getTitular().getNombre().equalsIgnoreCase(nombreTitular)) {
                return cuentas[i];
            }
        }
        return null;
    }

    /**
     * Busca una cuenta bancaria por el número de IBAN.
     *
     * @param iban Número de IBAN de la cuenta a buscar.
     * @return Cuenta bancaria encontrada o null si no se encuentra.
     */
    public CuentaBancaria buscarCuentaPorIBAN(String iban) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getIban().equalsIgnoreCase(iban)) {
                return cuentas[i];
            }
        }
        return null;
    }

    /**
     * Verifica si un número de IBAN está en uso en el banco.
     *
     * @param iban Número de IBAN a verificar.
     * @return true si el IBAN está en uso; false, si no está en uso.
     */
    public boolean estaIBANEnUso(String iban) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getIban().equalsIgnoreCase(iban)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra las cuentas del banco.
     */
    public void imprimirCuentas() {
        listarCuentas();
    }

    /**
     * Imprime la información de la cuenta bancaria asociada al titular.
     *
     * @param nombreTitular Nombre del titular de la cuenta a imprimir.
     */
    public void imprimirCuentaPorTitular(String nombreTitular) {
        CuentaBancaria cuenta = buscarCuentaPorTitular(nombreTitular);
        if (cuenta != null) {
            System.out.println("Cuenta encontrada para el titular " + nombreTitular + ":");
            System.out.println(cuenta);
        } else {
            System.out.println("No se encontró ninguna cuenta para el titular " + nombreTitular + ".");
        }
    }

    /**
     * Imprime la información de la cuenta bancaria asociada al número de IBAN.
     *
     * @param iban Número de IBAN de la cuenta a imprimir.
     */
    public void imprimirCuentaPorIBAN(String iban) {
        CuentaBancaria cuenta = buscarCuentaPorIBAN(iban);
        if (cuenta != null) {
            System.out.println("Cuenta encontrada para el IBAN " + iban + ":");
            System.out.println(cuenta);
        } else {
            System.out.println("No se encontró ninguna cuenta para el IBAN " + iban + ".");
        }
    }

    /**
     * Obtiene el número total de cuentas registradas en el banco.
     *
     * @return Número total de cuentas registradas.
     */
    public int getNumCuentas() {
        return numCuentas;
    }

    /**
     * Obtiene el array de cuentas bancarias registradas en el banco.
     *
     * @return Array de cuentas bancarias.
     */
    public CuentaBancaria[] getCuentas() {
        return cuentas;
    }
}
