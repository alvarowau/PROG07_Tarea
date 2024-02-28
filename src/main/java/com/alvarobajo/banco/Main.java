package com.alvarobajo.banco;

import com.alvarobajo.banco.controller.Banco;
import com.alvarobajo.banco.view.Menu;

public class Main {

    Banco banco = new Banco();
    public static void main(String[] args) {
        Banco banco = new Banco();
        Menu.menuPrincipal(banco);
    }
}