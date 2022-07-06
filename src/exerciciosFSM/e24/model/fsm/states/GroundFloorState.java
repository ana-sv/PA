package exerciciosFSM.e24.model.fsm.states;

import exerciciosFSM.e24.model.data.ElevatorData;
import exerciciosFSM.e24.model.fsm.ElevatorContext;
import exerciciosFSM.e24.model.fsm.ElevatorStateAdapter;

public class GroundFloorState extends ElevatorStateAdapter {

    protected GroundFloorState(ElevatorContext c, ElevatorData d) {
        super(c, d);
    }


    @Override
    public ElevatorState getState() {
        return ElevatorState.GROUND_FLOOR;
    }


    @Override
    public void down() {
    }


    @Override
    public void up() {  
        // Falta adicionar probabilidade de avaria
        super.data.addINFO("GOING TO FIRST_FLOOR");
        changeState(ElevatorState.FIRST_FLOOR);
    }


}
