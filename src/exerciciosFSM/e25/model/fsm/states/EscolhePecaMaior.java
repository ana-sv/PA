package exerciciosFSM.e25.model.fsm.states;

import exerciciosFSM.e25.model.data.Jogo;
import exerciciosFSM.e25.model.fsm.Contexto;
import exerciciosFSM.e25.model.fsm.Estado;
import exerciciosFSM.e25.model.fsm.EstadoEnum;
import exerciciosFSM.e25.model.fsm.TipoPeca;

public class EscolhePecaMaior extends Estado {

    public EscolhePecaMaior(Contexto c, Jogo d) {
        super(c, d);
    }

    @Override
    public void escolheu(TipoPeca p) {

    }

    @Override
    public void escolheu(TipoPeca p, boolean maior) {
    }

    @Override
    public EstadoEnum getState() {
        return EstadoEnum.ESCOLHEPECAMAIOR;
    }


    
    
}
