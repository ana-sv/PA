package exemplos.GumballMachine.model.states;
import exemplos.GumballMachine.model.Context;
import exemplos.GumballMachine.model.State;
import exemplos.GumballMachine.model.StateAdapter;
import exemplos.GumballMachine.model.data.GumballMachineData;

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