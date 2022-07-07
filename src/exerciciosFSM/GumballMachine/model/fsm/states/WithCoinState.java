package exerciciosFSM.GumballMachine.model.fsm.states;

import exerciciosFSM.GumballMachine.model.data.GumballMachineData;
import exerciciosFSM.GumballMachine.model.fsm.Context;
import exerciciosFSM.GumballMachine.model.fsm.State;
import exerciciosFSM.GumballMachine.model.fsm.StateAdapter;

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