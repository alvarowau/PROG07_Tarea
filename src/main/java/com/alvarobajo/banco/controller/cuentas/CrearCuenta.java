package com.alvarobajo.banco.controller.cuentas;

import com.alvarobajo.banco.controller.Banco;
import com.alvarobajo.banco.controller.LecturaTeclado;
import com.alvarobajo.banco.models.CuentaAhorro;
import com.alvarobajo.banco.models.CuentaCorrienteEmpresa;
import com.alvarobajo.banco.models.CuentaCorrientePersonal;
import com.alvarobajo.banco.models.Persona;

import java.util.Random;

/**
 * Clase que proporciona métodos para la creación de diferentes tipos de cuentas bancarias.
 *
 * @author Álvaro Bajo Tabero
 */
public class CrearCuenta {

    private static final String MENSAJE_SALDO = "Ingrese el saldo inicial:";
    private static final String MENSAJE_TIPO_INTERES = "Ingrese el tipo de interés:";
    private static final String MENSAJE_LISTA_ENTIDADES = "Ingrese la lista de entidades autorizadas:";
    private static final String MENSAJE_COMISION_MANTENIMIENTO = "Ingrese la comisión de mantenimiento:";
    private static final String MENSAJE_TIPO_INTERES_DESCUBIERTO = "Ingrese el tipo de interés por descubierto:";
    private static final String MENSAJE_MAXIMO_DESCUBIERTO = "Ingrese el máximo descubierto permitido:";
    private static final String FORMATO_IBAN = "ES%010d";

    /**
     * Crea una cuenta de ahorro.
     *
     * @param banco Banco al que se asociará la cuenta.
     * @return La cuenta de ahorro creada.
     */
    public static CuentaAhorro cuentaAhorro(Banco banco) {
        Persona titular = CrearPersona.crearPersona();
        double saldoInicial = obtenerSaldoInicial();
        double tipoInteres = obtenerTipoInteres();

        return new CuentaAhorro(titular, saldoInicial, generarIBAN(banco), tipoInteres);
    }

    /**
     * Crea una cuenta corriente personal.
     *
     * @param banco Banco al que se asociará la cuenta.
     * @return La cuenta corriente personal creada.
     */
    public static CuentaCorrientePersonal cuentaCorrientePersonal(Banco banco) {
        Persona titular = CrearPersona.crearPersona();
        double saldoInicial = obtenerSaldoInicial();
        String listaEntidades = LecturaTeclado.recogerTexto(MENSAJE_LISTA_ENTIDADES);
        double comisionMantenimiento = obtenerComisionMantenimiento();

        return new CuentaCorrientePersonal(titular, saldoInicial, generarIBAN(banco), listaEntidades, comisionMantenimiento);
    }

    /**
     * Crea una cuenta corriente de empresa.
     *
     * @param banco Banco al que se asociará la cuenta.
     * @return La cuenta corriente de empresa creada.
     */
    public static CuentaCorrienteEmpresa cuentaCorrienteEmpresa(Banco banco) {
        Persona titular = CrearPersona.crearPersona();
        double saldoInicial = obtenerSaldoInicial();
        String listaEntidades = LecturaTeclado.recogerTexto(MENSAJE_LISTA_ENTIDADES);
        double tipoInteresDescubierto = obtenerTipoInteresDescubierto();
        double maximoDescubierto = obtenerMaximoDescubierto();

        return new CuentaCorrienteEmpresa(titular, saldoInicial, generarIBAN(banco), listaEntidades,
                tipoInteresDescubierto, maximoDescubierto);
    }

    private static double obtenerSaldoInicial() {
        double saldoInicial;
        do {
            saldoInicial = LecturaTeclado.recogerDecimal(MENSAJE_SALDO);
        } while (saldoInicial <= 0);
        return saldoInicial;
    }

    private static double obtenerTipoInteres() {
        double tipoInteres;
        do {
            tipoInteres = LecturaTeclado.recogerDecimal(MENSAJE_TIPO_INTERES);
        } while (tipoInteres <= 0);
        return tipoInteres;
    }

    private static double obtenerComisionMantenimiento() {
        double comisionMantenimiento;
        do {
            comisionMantenimiento = LecturaTeclado.recogerDecimal(MENSAJE_COMISION_MANTENIMIENTO);
        } while (comisionMantenimiento <= 0);
        return comisionMantenimiento;
    }

    private static double obtenerTipoInteresDescubierto() {
        double tipoInteresDescubierto;
        do {
            tipoInteresDescubierto = LecturaTeclado.recogerDecimal(MENSAJE_TIPO_INTERES_DESCUBIERTO);
        } while (tipoInteresDescubierto <= 0);
        return tipoInteresDescubierto;
    }

    private static double obtenerMaximoDescubierto() {
        double maximoDescubierto;
        do {
            maximoDescubierto = LecturaTeclado.recogerDecimal(MENSAJE_MAXIMO_DESCUBIERTO);
        } while (maximoDescubierto <= 0);
        return maximoDescubierto;
    }

    private static String generarIBAN(Banco banco) {
        String nuevoIBAN;
        do {
            nuevoIBAN = String.format(FORMATO_IBAN, new Random().nextInt(Integer.MAX_VALUE));
        } while (banco.estaIBANEnUso(nuevoIBAN));

        return nuevoIBAN;
    }
}
