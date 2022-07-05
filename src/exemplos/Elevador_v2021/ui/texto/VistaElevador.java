package exemplos.Elevador_v2021.ui.texto;

import java.util.Scanner;

import exemplos.Elevador_v2021.logica.Elevador;
import exemplos.Elevador_v2021.logica.ElevadorSituacao;

public class VistaElevador {
    final private Elevador elevador;
    final Scanner sc = new Scanner(System.in);
    private boolean sair=false;
    
    public VistaElevador(Elevador elevador){
        this.elevador=elevador;
    }
    public void corre(){
        while(!sair){
            ElevadorSituacao situacao = elevador.getSituacaoAtual();

            switch (situacao) {
                case RES_CHAO:
                    askForInputResChao(situacao);
                    break;
                case PRIMEIRO_ANDAR:
                    askForInputPrimAndar(situacao);
                    break;
                case SEGUNDO_ANDAR:
                    askForInputSegAndar(situacao);
                    break;
                case AVARIADO:
                    askForInputAvariado(situacao);
                default:
                    System.out.println("Elevador fora de controlo");
                    break;
            }
            //mostra passagens a cada passagem de andar
//            System.out.println(elevador);
        }
        //mostra passagens no fim
        System.out.println("log:");
        System.out.println(elevador);
    }

    public void askForInputPrimAndar(ElevadorSituacao sit) {

        System.out.println(sit);
        while (true) {
            System.out.println("(Q)uit, (U)p or (D)own?");
            char c = sc.next().charAt(0);

            if ((c == 'u') || (c == 'U')) {
                elevador.up();
                return;
            }
            if ((c == 'd') || (c == 'D')) {
                elevador.down();
                return;
            }
            if ((c == 'q') || (c == 'Q')) {
                sair = true;
                return;
            }
        }
    }

    public void askForInputSegAndar(ElevadorSituacao sit) {

        System.out.println(sit);
        while (true) {
            System.out.println("(Q)uit, (U)p or (D)own?");
            char c = sc.next().charAt(0);

            if ((c == 'd') || (c == 'D')) {
                elevador.down();
                return;
            }
            if ((c == 'q') || (c == 'Q')) {
                sair = true;
                return;
            }
        }
    }
    public void askForInputResChao(ElevadorSituacao sit) {

        System.out.println(sit);
        while (true) {
            System.out.println("(Q)uit, (U)p or (D)own?");
            char c = sc.next().charAt(0);

            if ((c == 'u') || (c == 'U')) {
                elevador.up();
                return;
            }
            if ((c == 'q') || (c == 'Q')) {
                sair = true;
                return;
            }
        }
    }

    public void askForInputAvariado(ElevadorSituacao sit) {
        System.out.println(sit);
        while (true) {
            System.out.println("(Q)uit, (K)ey?");
            char c = sc.next().charAt(0);

            if ((c == 'k') || (c == 'K')) {
                elevador.safetyKey();
                return;
            }
            if ((c == 'q') || (c == 'Q')) {
                sair = true;
                return;
            }
        }
    }

    /*public void corre(){
        while(!sair){
            System.out.println(elevador);
            char c= sc.next().charAt(0);
            if((c == 'u')|| (c=='U'))
                elevador.up();
            if((c == 'd')|| (c=='D'))
                elevador.down();
            else if((c == 'q')|| (c=='Q'))
                sair=true;
        }
    }*/
}
