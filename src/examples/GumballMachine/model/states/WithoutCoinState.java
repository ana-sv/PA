package examples.GumballMachine.model.states;
import examples.GumballMachine.model.Context;
import examples.GumballMachine.model.State;
import examples.GumballMachine.model.StateAdapter;
import examples.GumballMachine.model.data.GumballMachineData;

public class WithoutCoinState extends StateAdapter {
    public WithoutCoinState(Context context, GumballMachineData data) {
        super(context, data);
    }

    @Override
    public boolean insertCoin() {
        changeState(new WithCoinState(context, data));
        return true;
    }

    @Override
    public boolean startMaintenance() {
        changeState(new MaintenanceState(context, data));
        return true;
    }

    @Override
    public State getState() {
        return State.WITHOUT_COIN;
    }
}