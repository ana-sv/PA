package exerciciosFSM.e25.model.fsm;

import exerciciosFSM.e25.model.data.Jogo;
import exerciciosFSM.e25.model.fsm.states.EscolhePeca;
import exerciciosFSM.e25.model.fsm.states.EscolhePecaMaior;
import exerciciosFSM.e25.model.fsm.states.Inicio;

public enum EstadoEnum {
    ESCOLHEPECA, ESCOLHEPECAMAIOR, INICIO; 

    public IEstado createState(Contexto c, Jogo d ){
        return switch (this) {
            case INICIO -> new Inicio(c,d);
            case ESCOLHEPECA -> new EscolhePeca(c,d);
            case ESCOLHEPECAMAIOR -> new EscolhePecaMaior(c,d);
        };
    }
    
}
