package EXAMES.BasicClock_FSM.model.fsm.states;

import EXAMES.BasicClock_FSM.model.data.ClockData;
import EXAMES.BasicClock_FSM.model.fsm.Adapter;
import EXAMES.BasicClock_FSM.model.fsm.Context;
import EXAMES.BasicClock_FSM.model.fsm.State;

public class AcertoDosSegundos extends Adapter {

    public AcertoDosSegundos(Context context, ClockData data) {
        super(context, data);
    }

    @Override
    public State getState() {
        return State.ACERTODOSSEGUNDOS;
    }
    
}
