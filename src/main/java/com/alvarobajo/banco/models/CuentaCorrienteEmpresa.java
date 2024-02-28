package com.alvarobajo.banco.models;

/**
 * Clase que representa una cuenta corriente para una empresa.
 * Extiende de la clase abstracta CuentaCorriente.
 *
 * @author Álvaro Bajo Tabero
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private double tipoInteresDescubierto;
    private double maximoDescubierto;

    /**
     * Constructor para inicializar una instancia de CuentaCorrienteEmpresa.
     *
     * @param titular                Persona titular de la cuenta.
     * @param saldo                  Saldo inicial de la cuenta.
     * @param iban                   Número de cuenta IBAN asociado a la cuenta.
     * @param listaEntidades         Lista de entidades autorizadas asociadas a la cuenta corriente.
     * @param tipoInteresDescubierto Tasa de interés por descubierto asociada a la cuenta.
     * @param maximoDescubierto      Máximo descubierto permitido para la cuenta.
     */
    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, String listaEntidades,
                                  double tipoInteresDescubierto, double maximoDescubierto) {
        super(titular, saldo, iban, listaEntidades);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubierto = maximoDescubierto;
    }

    /**
     * Obtiene la tasa de interés por descubierto asociada a la cuenta.
     *
     * @return Tasa de interés por descubierto de la cuenta.
     */
    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    /**
     * Establece la tasa de interés por descubierto asociada a la cuenta.
     *
     * @param tipoInteresDescubierto Nueva tasa de interés por descubierto de la cuenta.
     */
    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    /**
     * Obtiene el máximo descubierto permitido para la cuenta.
     *
     * @return Máximo descubierto permitido para la cuenta.
     */
    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    /**
     * Establece el máximo descubierto permitido para la cuenta.
     *
     * @param maximoDescubierto Nuevo máximo descubierto permitido para la cuenta.
     */
    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    /**
     * Devuelve la información detallada de la cuenta corriente de empresa en formato de cadena.
     *
     * @return Información detallada de la cuenta corriente de empresa en formato de cadena.
     */
    @Override
    public String devolverInfoString() {
        return String.format("Cuenta Corriente Empresa\n%s\nTipo de Interés Descubierto: %.2f\nMáximo Descubierto: %.2f",
                super.devolverInfoString(), tipoInteresDescubierto, maximoDescubierto);
    }
}
