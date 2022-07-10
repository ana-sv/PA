package EXAMES.Exame2021.BasicClock.model.fsm.states;

import EXAMES.Exame2021.BasicClock.model.data.ClockData;
import EXAMES.Exame2021.BasicClock.model.fsm.Adapter;
import EXAMES.Exame2021.BasicClock.model.fsm.Context;
import EXAMES.Exame2021.BasicClock.model.fsm.State;

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
