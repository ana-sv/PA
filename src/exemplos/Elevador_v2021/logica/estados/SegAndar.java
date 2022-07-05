package exemplos.Elevador_v2021.logica.estados;

import exemplos.Elevador_v2021.logica.ElevadorSituacao;
import exemplos.Elevador_v2021.logica.dados.ElevadorDados;

public class SegAndar extends ElevadorEstadoAdapter{

    public SegAndar(ElevadorDados dados) {
        super(dados);
    }

    public IElevadorEstado down(){
        getDados().addPassagem("Vou para o primeiro andar");
        return new PrimAndar(getDados());
    }

    public ElevadorSituacao getSituacaoAtual(){
        return ElevadorSituacao.SEGUNDO_ANDAR;
    }
}
