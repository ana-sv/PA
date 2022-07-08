package EXAMES.Exame2021.BasicClock_FSM.model.fsm.states;

import EXAMES.Exame2021.BasicClock_FSM.model.data.ClockData;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.Adapter;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.Context;
import EXAMES.Exame2021.BasicClock_FSM.model.fsm.State;

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
