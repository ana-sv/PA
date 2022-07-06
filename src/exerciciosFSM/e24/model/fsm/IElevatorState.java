package exerciciosFSM.e24.model.fsm;

import exerciciosFSM.e24.model.fsm.states.ElevatorState;

public interface IElevatorState {

    void up();
    void down();
    void safetykey();
    ElevatorState getState();  

}
