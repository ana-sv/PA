package EXAMES.Exame2021.BasicClock_FSM.model.fsm;

import EXAMES.Exame2021.BasicClock_FSM.model.data.ClockData;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.states.AcertoDasHoras;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.states.AcertoDosMinutos;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.states.AcertoDosSegundos;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.states.Desligado;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.states.Display;

public enum State {
    DESLIGADO, DISPLAY, ACERTODASHORAS, ACERTODOSMINUTOS, ACERTODOSSEGUNDOS;

    public IState createState( Context context, ClockData data){
        return switch(this){
            case DESLIGADO -> new Desligado(context,data);
            case ACERTODOSMINUTOS -> new AcertoDosMinutos(context,data);
            case ACERTODASHORAS -> new AcertoDasHoras(context, data);
            case ACERTODOSSEGUNDOS -> new AcertoDosSegundos(context, data);
            case DISPLAY -> new Display(context, data);
           // default -> null;
        };
    }
    
}