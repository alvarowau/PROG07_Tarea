package com.alvarobajo.banco.models;

/**
 * Clase abstracta que representa una cuenta bancaria genérica.
 * Implementa la interfaz Imprimible para proporcionar una representación de cadena.
 * Las clases concretas deben extender esta clase para crear tipos específicos de cuentas bancarias.
 *
 * @author Álvaro Bajo Tabero
 */
public abstract class CuentaBancaria implements Imprimible {

    private Persona titular;
    private double saldo;
    private String iban;

    /**
     * Constructor para inicializar una instancia de CuentaBancaria.
     *
     * @param titular Persona titular de la cuenta.
     * @param saldo   Saldo inicial de la cuenta.
     * @param iban    Número de cuenta IBAN asociado a la cuenta.
     */
    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    // Métodos de acceso y modificación para los atributos

    /**
     * Obtiene el titular de la cuenta.
     *
     * @return Persona titular de la cuenta.
     */
    public Persona getTitular() {
        return titular;
    }

    /**
     * Establece el titular de la cuenta.
     *
     * @param titular Nuevo titular de la cuenta.
     */
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return Saldo actual de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo actual de la cuenta.
     *
     * @param saldo Nuevo saldo de la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el número de cuenta IBAN asociado a la cuenta.
     *
     * @return Número de cuenta IBAN.
     */
    public String getIban() {
        return iban;
    }

    /**
     * Establece el número de cuenta IBAN asociado a la cuenta.
     *
     * @param iban Nuevo número de cuenta IBAN.
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Devuelve la información de la cuenta en formato de cadena.
     *
     * @return Información de la cuenta en formato de cadena.
     */
    @Override
    public String devolverInfoString() {
        StringBuilder info = new StringBuilder();
        info.append("Tipo de cuenta: ").append(this.getClass().getSimpleName()).append("\n");
        info.append("Titular: ").append(titular.getNombre()).append(" ").append(titular.getApellido1());
        if (!titular.getApellido2().isEmpty()) {
            info.append(" ").append(titular.getApellido2());
        }
        info.append("\n");
        info.append("IBAN: ").append(iban).append("\n");
        info.append("Saldo actual: ").append(saldo).append(" €\n");
        return info.toString();
    }
}
