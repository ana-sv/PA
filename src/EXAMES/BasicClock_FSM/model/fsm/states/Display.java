package EXAMES.BasicClock_FSM.model.fsm.states;

import EXAMES.BasicClock_FSM.model.data.ClockData;
import EXAMES.BasicClock_FSM.model.fsm.Adapter;
import EXAMES.BasicClock_FSM.model.fsm.Context;
import EXAMES.BasicClock_FSM.model.fsm.State;

public class Display extends Adapter{

  
    public Display(Context context, ClockData data) {
        super(context, data);
    }

    @Override
    public State getState() {
        return State.DISPLAY;
    }

    
  @Override
    public void set() {
        setHours();
    }

    @Override
    public void setHours(){
        State.ACERTODASHORAS.createState(context, data);
    }




    
}
