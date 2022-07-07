package exerciciosFSM.GumballMachine.model.fsm;

public interface IState {
    boolean insertCoin();

    boolean ejectCoin();

    boolean turnsCrank();

    boolean startMaintenance();

    boolean refillGumballs(int count);

    State getState();
}