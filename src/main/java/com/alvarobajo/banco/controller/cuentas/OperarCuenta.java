package com.alvarobajo.banco.controller.cuentas;

import com.alvarobajo.banco.models.CuentaBancaria;

import java.text.DecimalFormat;

/**
 * Clase que proporciona métodos para realizar operaciones en una cuenta bancaria,
 * como retiros, consultas de saldo e ingresos.
 *
 * @author Álvaro Bajo Tabero
 */
public class OperarCuenta {

    private static final String MENSAJE_RETIRO_EXITOSO = "Retiro exitoso. Nuevo saldo: %s";
    private static final String MENSAJE_ERROR_RETIRO = "Error en el retiro de efectivo. Verifique la cantidad ingresada.";

    private static final String MENSAJE_SALDO_ACTUAL = "Saldo actual de la cuenta: %s";

    private static final String MENSAJE_INGRESO_EXITOSO = "Ingreso exitoso. Nuevo saldo: %s";
    private static final String MENSAJE_ERROR_INGRESO = "Error en el ingreso. Verifique la cantidad ingresada.";

    private static final DecimalFormat FORMATO_MONEDA = new DecimalFormat("###,###,##0.00");

    /**
     * Realiza un retiro de efectivo en la cuenta bancaria.
     *
     * @param cuenta   La cuenta en la que realizar el retiro.
     * @param cantidad La cantidad a retirar.
     */
    public static void retirarEfectivo(CuentaBancaria cuenta, double cantidad) {
        if (cantidad > 0 && cantidad <= cuenta.getSaldo()) {
            cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            System.out.println(String.format(MENSAJE_RETIRO_EXITOSO, formatoMoneda(cuenta.getSaldo())));
        } else {
            System.out.println(MENSAJE_ERROR_RETIRO);
        }
    }

    /**
     * Consulta el saldo actual de la cuenta bancaria.
     *
     * @param cuenta La cuenta de la que obtener el saldo.
     */
    public static void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println(String.format(MENSAJE_SALDO_ACTUAL, formatoMoneda(cuenta.getSaldo())));
    }

    /**
     * Realiza un ingreso en la cuenta bancaria.
     *
     * @param cuenta   La cuenta en la que realizar el ingreso.
     * @param cantidad La cantidad a ingresar.
     */
    public static void realizarIngreso(CuentaBancaria cuenta, double cantidad) {
        if (cantidad > 0) {
            cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            System.out.println(String.format(MENSAJE_INGRESO_EXITOSO, formatoMoneda(cuenta.getSaldo())));
        } else {
            System.out.println(MENSAJE_ERROR_INGRESO);
        }
    }

    private static String formatoMoneda(double cantidad) {
        return FORMATO_MONEDA.format(cantidad);
    }
}
