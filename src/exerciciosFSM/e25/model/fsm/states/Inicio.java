package exerciciosFSM.e25.model.fsm.states;

import exerciciosFSM.e25.model.data.Jogo;
import exerciciosFSM.e25.model.fsm.Contexto;
import exerciciosFSM.e25.model.fsm.Estado;
import exerciciosFSM.e25.model.fsm.EstadoEnum;
import exerciciosFSM.e25.model.fsm.TipoPeca;

public class Inicio extends Estado {

    public Inicio(Contexto c, Jogo d) {
        super(c, d);
    }

    @Override
    public void escolheu(TipoPeca p) {
        // TODO Auto-generated method stub
        super.escolheu(p);
    }

    @Override
    public void escolheu(TipoPeca p, boolean maior) {
        // TODO Auto-generated method stub
        super.escolheu(p, maior);
    }

    @Override
    public EstadoEnum getState() {
        return EstadoEnum.INICIO; 
    }



}
