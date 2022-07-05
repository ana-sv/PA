package exemplos.Elevador_v2021.logica.estados;

import exemplos.Elevador_v2021.logica.ElevadorSituacao;
import exemplos.Elevador_v2021.logica.dados.ElevadorDados;

public class Avariado extends ElevadorEstadoAdapter {
    private IElevadorEstado estadoAnterior;

    public Avariado(ElevadorDados dados, IElevadorEstado estadoAnterior) {
        super(dados);
        this.estadoAnterior = estadoAnterior;
    }

    public IElevadorEstado safetyKey() {
        getDados().addPassagem("vou para o andar onde aconteceu a avaria");
        return estadoAnterior;
    }

    public ElevadorSituacao getSituacaoAtual() {
        return ElevadorSituacao.AVARIADO;
    }
}
