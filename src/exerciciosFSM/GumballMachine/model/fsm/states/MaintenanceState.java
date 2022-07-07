package exerciciosFSM.GumballMachine.model.fsm.states;

import exerciciosFSM.GumballMachine.model.data.GumballMachineData;
import exerciciosFSM.GumballMachine.model.fsm.Context;
import exerciciosFSM.GumballMachine.model.fsm.State;
import exerciciosFSM.GumballMachine.model.fsm.StateAdapter;

public class MaintenanceState extends StateAdapter {
    MaintenanceState(Context context, GumballMachineData data) {
        super(context, data);
    }

    @Override
    public boolean refillGumballs(int count) {
        data.refillGumballs(count);
        if (data.getCount() > 0) {
            changeState(new WithoutCoinState(context, data));
            return true;
        }
        return false;
    }

    @Override
    public State getState() {
        return State.MAINTENANCE;
    }
}