package EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.states;

import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.data.ClockData;
import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.Adapter;
import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.Context;
import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm.State;

public class AcertoDasHoras extends Adapter {

    public AcertoDasHoras(Context context, ClockData data) {
        super(context, data);
    }

    @Override
    public State getState() {
        return State.ACERTODASHORAS;
    }


    @Override
    public void decrement() {
        data.setH( data.getM() - 1 );
    }

    @Override
    public void increment() {
        data.setH( data.getM() + 1);
    }

    @Override
    public void set() {
        setMinutes();
         
    }

    @Override
    public void setMinutes(){
        State.ACERTODOSMINUTOS.createState(context, data);
    }


}
