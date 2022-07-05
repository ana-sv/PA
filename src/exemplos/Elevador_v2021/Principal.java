package exemplos.Elevador_v2021;

import exemplos.Elevador_v2021.logica.Elevador;
import exemplos.Elevador_v2021.ui.texto.VistaElevador;

public class Principal {

    public static void main(String[] args) {
        Elevador e = new Elevador();
        VistaElevador usaE = new VistaElevador(e);
        usaE.corre();
    }
}
