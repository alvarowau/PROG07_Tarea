package com.alvarobajo.banco.models;

/**
 * Clase que representa una cuenta de ahorro.
 * Extiende de la clase abstracta CuentaBancaria.
 *
 * @author Álvaro Bajo Tabero
 */
public class CuentaAhorro extends CuentaBancaria {

    private double tipoInteres;

    /**
     * Constructor para inicializar una instancia de CuentaAhorro.
     *
     * @param titular     Persona titular de la cuenta.
     * @param saldo       Saldo inicial de la cuenta.
     * @param iban        Número de cuenta IBAN asociado a la cuenta.
     * @param tipoInteres Tasa de interés asociada a la cuenta de ahorro.
     */
    public CuentaAhorro(Persona titular, double saldo, String iban, double tipoInteres) {
        super(titular, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    /**
     * Obtiene la tasa de interés asociada a la cuenta de ahorro.
     *
     * @return Tasa de interés de la cuenta de ahorro.
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * Establece la tasa de interés asociada a la cuenta de ahorro.
     *
     * @param tipoInteres Nueva tasa de interés de la cuenta de ahorro.
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * Devuelve la información detallada de la cuenta de ahorro en formato de cadena.
     *
     * @return Información detallada de la cuenta de ahorro en formato de cadena.
     */
    @Override
    public String devolverInfoString() {
        return String.format("Cuenta de Ahorro:\n" +
                        "Titular: %s\n" +
                        "Saldo: %.2f\n" +
                        "IBAN: %s\n" +
                        "Tasa de Interés: %.2f%%",
                getTitular().devolverInfoString(),
                getSaldo(),
                getIban(),
                tipoInteres);
    }
}
