package exemplos.Elevador_v2021.logica.estados;

import exemplos.Elevador_v2021.logica.ElevadorSituacao;
import exemplos.Elevador_v2021.logica.dados.ElevadorDados;

public class PrimAndar extends ElevadorEstadoAdapter{
    public PrimAndar(ElevadorDados dados) {
        super(dados);
    }

    public IElevadorEstado up(){
        getDados().addPassagem("Vou para o segundo andar");
        return new SegAndar(getDados());
    }

    public IElevadorEstado down(){
        getDados().addPassagem("Vou para o Res Chao");
        return new ResChao(getDados());
    }

    public ElevadorSituacao getSituacaoAtual(){
        return ElevadorSituacao.PRIMEIRO_ANDAR;
    }
}
