package EXAMES.BasicClock_FSM.model.fsm.states;

import EXAMES.BasicClock_FSM.model.data.ClockData;
import EXAMES.BasicClock_FSM.model.fsm.Adapter;
import EXAMES.BasicClock_FSM.model.fsm.Context;
import EXAMES.BasicClock_FSM.model.fsm.State;

public class AcertoDosMinutos extends Adapter {

    public AcertoDosMinutos(Context context, ClockData data) {
        super(context, data);
    }

    

    @Override
    public State getState() {
        return State.ACERTODOSMINUTOS;
    }


    @Override
    public void decrement() {
        data.setM( data.getM() - 1 );
    }

    @Override
    public void increment() {
        data.setM( data.getM() + 1);
    }

    @Override
    public void set() {
        setSeconds();
         
    }

    @Override
    public void setSeconds(){
        State.ACERTODOSSEGUNDOS.createState(context, data);
    }


    
}
