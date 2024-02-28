package com.alvarobajo.banco.models;

/**
 * Clase abstracta que representa una cuenta corriente genérica.
 * Extiende de la clase abstracta CuentaBancaria.
 *
 * @author Álvaro Bajo Tabero
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    private String listaEntidades;

    /**
     * Constructor para inicializar una instancia de CuentaCorriente.
     *
     * @param titular         Persona titular de la cuenta.
     * @param saldo           Saldo inicial de la cuenta.
     * @param iban            Número de cuenta IBAN asociado a la cuenta.
     * @param listaEntidades  Lista de entidades autorizadas asociadas a la cuenta corriente.
     */
    public CuentaCorriente(Persona titular, double saldo, String iban, String listaEntidades) {
        super(titular, saldo, iban);
        this.listaEntidades = listaEntidades;
    }

    /**
     * Obtiene la lista de entidades autorizadas asociadas a la cuenta corriente.
     *
     * @return Lista de entidades autorizadas.
     */
    public String getListaEntidades() {
        return listaEntidades;
    }

    /**
     * Establece la lista de entidades autorizadas asociadas a la cuenta corriente.
     *
     * @param listaEntidades Nueva lista de entidades autorizadas.
     */
    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    /**
     * Devuelve la información detallada de la cuenta corriente en formato de cadena.
     *
     * @return Información detallada de la cuenta corriente en formato de cadena.
     */
    @Override
    public String devolverInfoString() {
        return String.format("Cuenta Corriente\nTitular: %s\nSaldo: %.2f\nIBAN: %s\nLista de Entidades Autorizadas: %s",
                getTitular().devolverInfoString(), getSaldo(), getIban(), listaEntidades);
    }
}
