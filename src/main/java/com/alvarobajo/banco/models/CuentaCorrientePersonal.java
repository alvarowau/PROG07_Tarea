package com.alvarobajo.banco.models;

/**
 * Clase que representa una cuenta corriente personal.
 * Extiende de la clase abstracta CuentaCorriente.
 *
 * @author Álvaro Bajo Tabero
 */
public class CuentaCorrientePersonal extends CuentaCorriente {

    private double comisionMantenimiento;

    /**
     * Constructor para inicializar una instancia de CuentaCorrientePersonal.
     *
     * @param titular                Persona titular de la cuenta.
     * @param saldo                  Saldo inicial de la cuenta.
     * @param iban                   Número de cuenta IBAN asociado a la cuenta.
     * @param listaEntidades         Lista de entidades autorizadas asociadas a la cuenta corriente.
     * @param comisionMantenimiento  Comisión de mantenimiento asociada a la cuenta corriente personal.
     */
    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, String listaEntidades,
                                   double comisionMantenimiento) {
        super(titular, saldo, iban, listaEntidades);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Obtiene la comisión de mantenimiento asociada a la cuenta corriente personal.
     *
     * @return Comisión de mantenimiento de la cuenta corriente personal.
     */
    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    /**
     * Establece la comisión de mantenimiento asociada a la cuenta corriente personal.
     *
     * @param comisionMantenimiento Nueva comisión de mantenimiento de la cuenta corriente personal.
     */
    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Devuelve la información detallada de la cuenta corriente personal en formato de cadena.
     *
     * @return Información detallada de la cuenta corriente personal en formato de cadena.
     */
    @Override
    public String devolverInfoString() {
        return String.format("Cuenta Corriente Personal\n%s\nComisión de Mantenimiento: %.2f",
                super.devolverInfoString(), comisionMantenimiento);
    }
}
