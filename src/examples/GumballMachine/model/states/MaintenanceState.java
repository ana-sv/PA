package examples.GumballMachine.model.states;

import examples.GumballMachine.model.Context;
import examples.GumballMachine.model.State;
import examples.GumballMachine.model.StateAdapter;
import examples.GumballMachine.model.data.GumballMachineData;

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