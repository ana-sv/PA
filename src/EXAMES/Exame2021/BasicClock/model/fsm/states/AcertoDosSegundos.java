package EXAMES.Exame2021.BasicClock.model.fsm.states;

import EXAMES.Exame2021.BasicClock.model.data.ClockData;
import EXAMES.Exame2021.BasicClock.model.fsm.Adapter;
import EXAMES.Exame2021.BasicClock.model.fsm.Context;
import EXAMES.Exame2021.BasicClock.model.fsm.State;

public class AcertoDosSegundos extends Adapter {

    public AcertoDosSegundos(Context context, ClockData data) {
        super(context, data);
    }

    @Override
    public State getState() {
        return State.ACERTODOSSEGUNDOS;
    }
    
}
