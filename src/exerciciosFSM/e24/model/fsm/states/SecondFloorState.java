package exerciciosFSM.e24.model.fsm.states;

import exerciciosFSM.e24.model.data.ElevatorData;
import exerciciosFSM.e24.model.fsm.ElevatorContext;
import exerciciosFSM.e24.model.fsm.ElevatorStateAdapter;

public class SecondFloorState extends ElevatorStateAdapter {

    public SecondFloorState(ElevatorContext c, ElevatorData d) {
        super(c, d);
    }

    @Override
    public ElevatorState getState() {
        return ElevatorState.SECOND_FLOOR;
    }

    @Override
    public void down() {
        super.data.addINFO("GOING TO FIRST_FLOOR");
        changeState(ElevatorState.FIRST_FLOOR);
    }

    @Override
    public void up() {
    }


}
