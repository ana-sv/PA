package EXAMES.Exame2021.BasicClock.model.fsm.states;

import EXAMES.Exame2021.BasicClock.model.data.ClockData;
import EXAMES.Exame2021.BasicClock.model.fsm.Adapter;
import EXAMES.Exame2021.BasicClock.model.fsm.Context;
import EXAMES.Exame2021.BasicClock.model.fsm.State;

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
