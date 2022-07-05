package exemplos.GumballMachine.model.states;

import exemplos.GumballMachine.model.Context;
import exemplos.GumballMachine.model.State;
import exemplos.GumballMachine.model.StateAdapter;
import exemplos.GumballMachine.model.data.GumballMachineData;

public class WithCoinState extends StateAdapter {
    WithCoinState(Context context, GumballMachineData data) {
        super(context, data);
    }

    @Override
    public boolean ejectCoin() {
        changeState(new WithoutCoinState(context, data));
        return true;
    }

    @Override
    public boolean turnsCrank() {
        if (data.getGumball() && data.getCount() > 0) {
            changeState(new WithoutCoinState(context, data));
            return true;
        }
        changeState(new MaintenanceState(context, data));
        return false;
    }

    @Override
    public State getState() {
        return State.WITH_COIN;
    }
}