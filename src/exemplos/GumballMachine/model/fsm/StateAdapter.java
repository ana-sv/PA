package exemplos.GumballMachine.model.fsm;
import exemplos.GumballMachine.model.data.GumballMachineData;

public abstract class StateAdapter implements IState {
    protected Context context;
    protected GumballMachineData data;

    protected StateAdapter(Context context, GumballMachineData data) {
        this.context = context;
        this.data = data;
    }

    protected void changeState(IState newState) {
        context.changeState(newState);
    }

    @Override
    public boolean insertCoin() {
        return false;
    }

    @Override
    public boolean ejectCoin() {
        return false;
    }

    @Override
    public boolean turnsCrank() {
        return false;
    }

    @Override
    public boolean startMaintenance() {
        return false;
    }

    @Override
    public boolean refillGumballs(int count) {
        return false;
    }
}