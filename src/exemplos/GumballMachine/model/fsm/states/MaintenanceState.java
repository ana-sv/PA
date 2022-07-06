package exemplos.GumballMachine.model.fsm.states;

import exemplos.GumballMachine.model.data.GumballMachineData;
import exemplos.GumballMachine.model.fsm.Context;
import exemplos.GumballMachine.model.fsm.State;
import exemplos.GumballMachine.model.fsm.StateAdapter;

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