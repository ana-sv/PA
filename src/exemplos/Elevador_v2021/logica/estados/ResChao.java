package exemplos.Elevador_v2021.logica.estados;

import exemplos.Elevador_v2021.logica.ElevadorSituacao;
import exemplos.Elevador_v2021.logica.dados.ElevadorDados;

public class ResChao extends ElevadorEstadoAdapter {
    final static int PROB_AV_RC = 10;

    public ResChao(ElevadorDados dados){
        super(dados);
    }

    public IElevadorEstado up(){
        int prob = (int)(Math.random()*100);
        if(prob < PROB_AV_RC) {
            getDados().addPassagem("aconteceu uma avaria");
//            getDados().maisUmaAvaria();
            return new Avariado(getDados(), this);
        }
        getDados().addPassagem("vou para o primeiro andar");
        return new PrimAndar(getDados());
    }

    public ElevadorSituacao getSituacaoAtual(){
        return ElevadorSituacao.RES_CHAO;
    }
}
