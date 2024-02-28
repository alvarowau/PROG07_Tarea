package com.alvarobajo.banco.view;

import com.alvarobajo.banco.controller.Banco;
import com.alvarobajo.banco.controller.LecturaTeclado;
import com.alvarobajo.banco.controller.cuentas.MostrarCuenta;
import com.alvarobajo.banco.controller.cuentas.OperarCuenta;
import com.alvarobajo.banco.controller.cuentas.CrearCuenta;
import com.alvarobajo.banco.models.CuentaBancaria;

/**
 * La clase Menu proporciona un menú de consola para interactuar con un Banco.
 * Permite abrir cuentas, ver información de cuentas, realizar operaciones y más.
 *
 * @author Álvaro Bajo Tabero
 */
public class Menu {

    /**
     * Muestra el menú principal en la consola.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n" +
                "    1. Abrir una nueva cuenta.\n" +
                "    2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).\n" +
                "    3. Obtener los datos de una cuenta concreta.\n" +
                "    4. Realizar un ingreso en una cuenta.\n" +
                "    5. Retirar efectivo de una cuenta.\n" +
                "    6. Consultar el saldo actual de una cuenta.\n" +
                "    7. Salir de la aplicación.\n");
    }

    /**
     * Muestra el menú de apertura de cuentas en la consola.
     */
    private static void mostrarMenuCuentas() {
        System.out.println("\n" +
                "    1. Abrir una nueva cuenta de ahorro.\n" +
                "    2. Abrir una nueva cuenta corriente personal.\n" +
                "    3. Abrir una nueva cuenta corriente de empresa.\n" +
                "    4. Volver atrás.\n");
    }

    /**
     * Permite al usuario seleccionar una opción del menú dentro de un rango.
     *
     * @param mensaje Mensaje a mostrar para solicitar la selección.
     * @param min     Valor mínimo permitido.
     * @param max     Valor máximo permitido.
     * @return La opción seleccionada por el usuario.
     */
    private static int seleccionMenu(String mensaje, int min, int max) {
        int seleccion;
        do {
            System.out.print(mensaje);
            seleccion = LecturaTeclado.recogerEntero("");
            if (seleccion < min || seleccion > max) {
                System.out.println("Por favor, ingrese un número válido entre " + min + " y " + max + ".");
            }
        } while (seleccion < min || seleccion > max);
        return seleccion;
    }

    /**
     * Muestra el menú principal y gestiona las acciones asociadas a cada opción.
     *
     * @param banco Banco sobre el cual se realizarán las operaciones.
     */
    public static void menuPrincipal(Banco banco) {
        int opcion;

        do {
            mostrarMenuPrincipal();
            opcion = seleccionMenu("\nSeleccione una opción del menú principal: ", 1, 7);

            switch (opcion) {
                case 1:
                    abrirMenuCuentas(banco);
                    break;
                case 2:
                    MostrarCuenta.mostrarListado(banco);
                    break;
                case 3:
                    mostrarCuentaConcreta(banco);
                    break;
                case 4:
                    realizarIngreso(banco);
                    break;
                case 5:
                    retirarEfectivo(banco);
                    break;
                case 6:
                    consultarSaldo(banco);
                    break;
                case 7:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Por favor, ingrese un número válido entre 1 y 7.");
            }
        } while (opcion != 7);
    }

    /**
     * Muestra el menú de apertura de cuentas y gestiona las acciones asociadas a cada opción.
     *
     * @param banco Banco sobre el cual se realizarán las operaciones.
     */
    private static void abrirMenuCuentas(Banco banco) {
        int opcion;
        do {
            mostrarMenuCuentas();
            opcion = seleccionMenu("\nSeleccione una opción del menú de cuentas: ", 1, 4);

            switch (opcion) {
                case 1:
                    CuentaBancaria nuevaCuentaAhorro = CrearCuenta.cuentaAhorro(banco);
                    if (nuevaCuentaAhorro != null) {
                        banco.abrirCuenta(nuevaCuentaAhorro);
                    }
                    break;
                case 2:
                    CuentaBancaria nuevaCuentaCorrientePersonal = CrearCuenta.cuentaCorrientePersonal(banco);
                    if (nuevaCuentaCorrientePersonal != null) {
                        banco.abrirCuenta(nuevaCuentaCorrientePersonal);
                    }
                    break;
                case 3:
                    CuentaBancaria nuevaCuentaCorrienteEmpresa = CrearCuenta.cuentaCorrienteEmpresa(banco);
                    if (nuevaCuentaCorrienteEmpresa != null) {
                        banco.abrirCuenta(nuevaCuentaCorrienteEmpresa);
                    }
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Por favor, ingrese un número válido entre 1 y 4.");
            }
        } while (opcion != 4);
    }

    /**
     * Muestra la información de una cuenta específica.
     *
     * @param banco Banco que contiene la cuenta.
     */
    private static void mostrarCuentaConcreta(Banco banco) {
        String Iban = LecturaTeclado.recogerTexto("Ingrese el IBAN de la cuenta:");
        MostrarCuenta.mostrarCuentaConcreta(banco, Iban);
    }

    /**
     * Realiza un ingreso en la cuenta seleccionada por el usuario.
     *
     * @param banco Banco que contiene la cuenta.
     */
    private static void realizarIngreso(Banco banco) {
        CuentaBancaria cuenta = seleccionarCuenta(banco);
        if (cuenta != null) {
            double cantidad = LecturaTeclado.recogerDecimal("Ingrese la cantidad a ingresar: ");
            OperarCuenta.realizarIngreso(cuenta, cantidad);
        }
    }

    /**
     * Retira efectivo de la cuenta seleccionada por el usuario.
     *
     * @param banco Banco que contiene la cuenta.
     */
    private static void retirarEfectivo(Banco banco) {
        CuentaBancaria cuenta = seleccionarCuenta(banco);
        if (cuenta != null) {
            double cantidad = LecturaTeclado.recogerDecimal("Ingrese la cantidad a retirar: ");
            OperarCuenta.retirarEfectivo(cuenta, cantidad);
        }
    }

    /**
     * Consulta el saldo de la cuenta seleccionada por el usuario.
     *
     * @param banco Banco que contiene la cuenta.
     */
    private static void consultarSaldo(Banco banco) {
        CuentaBancaria cuenta = seleccionarCuenta(banco);
        if (cuenta != null) {
            OperarCuenta.consultarSaldo(cuenta);
        }
    }

    /**
     * Permite al usuario seleccionar una cuenta por su IBAN.
     *
     * @param banco Banco que contiene la cuenta.
     * @return La cuenta seleccionada por el usuario.
     */
    private static CuentaBancaria seleccionarCuenta(Banco banco) {
        String Iban = LecturaTeclado.recogerTexto("Ingrese el IBAN de la cuenta:");
        return banco.buscarCuentaPorIBAN(Iban);
    }
}
