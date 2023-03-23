package Controlador;

import Vista.Ventana;

public class Main {
    public static void main(String[] args) {
        Ventana v = new Ventana();
        Controlador controlador = new Controlador(v);
        controlador.unidadDeControl();
    }
}
