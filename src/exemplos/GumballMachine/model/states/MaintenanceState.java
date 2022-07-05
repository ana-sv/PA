package exemplos.GumballMachine.model.states;

import exemplos.GumballMachine.model.Context;
import exemplos.GumballMachine.model.State;
import exemplos.GumballMachine.model.StateAdapter;
import exemplos.GumballMachine.model.data.GumballMachineData;

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