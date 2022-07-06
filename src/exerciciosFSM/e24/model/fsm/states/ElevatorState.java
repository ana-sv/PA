package exerciciosFSM.e24.model.fsm.states;

import exerciciosFSM.e24.model.data.ElevatorData;
import exerciciosFSM.e24.model.fsm.ElevatorContext;
import exerciciosFSM.e24.model.fsm.IElevatorState;

public enum ElevatorState {
    GROUND_FLOOR, FIRST_FLOOR, SECOND_FLOOR, UNDER_MAINTENANCE;

    // factory - instance method
    public IElevatorState createState(ElevatorContext context, ElevatorData data) {
        return switch (this) {
            case GROUND_FLOOR -> new GroundFloorState(context, data);
            case FIRST_FLOOR -> new FirstFloorState(context, data);
            case SECOND_FLOOR -> new SecondFloorState(context, data);
            case UNDER_MAINTENANCE -> new UnderMaintenanceState(context, data);
        };
    }
}