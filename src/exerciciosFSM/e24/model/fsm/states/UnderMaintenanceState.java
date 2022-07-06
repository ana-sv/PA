package exerciciosFSM.e24.model.fsm.states;

import exerciciosFSM.e24.model.data.ElevatorData;
import exerciciosFSM.e24.model.fsm.ElevatorContext;
import exerciciosFSM.e24.model.fsm.ElevatorStateAdapter;

public class UnderMaintenanceState extends ElevatorStateAdapter {

    protected UnderMaintenanceState(ElevatorContext c, ElevatorData d) {
        super(c, d);
    }


    @Override 
    public void safetykey() {

        changeState(ElevatorState.GROUND_FLOOR);
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.UNDER_MAINTENANCE;
    }


}
