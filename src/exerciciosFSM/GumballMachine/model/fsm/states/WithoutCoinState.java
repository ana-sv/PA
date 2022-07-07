package exerciciosFSM.GumballMachine.model.fsm.states;
import exerciciosFSM.GumballMachine.model.data.GumballMachineData;
import exerciciosFSM.GumballMachine.model.fsm.Context;
import exerciciosFSM.GumballMachine.model.fsm.State;
import exerciciosFSM.GumballMachine.model.fsm.StateAdapter;

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