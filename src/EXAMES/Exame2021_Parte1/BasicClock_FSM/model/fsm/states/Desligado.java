package EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.states;


import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.data.ClockData;
import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.Adapter;
import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.Context;
import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.State;

public class Desligado extends Adapter{


    public Desligado(Context context, ClockData data ) {
        super(context,data);
    }

    

    @Override
    public State getState() {
        return State.DESLIGADO;
    }
    
}
