package exerciciosFSM.e24.model.fsm.states;

import exerciciosFSM.e24.model.data.ElevatorData;
import exerciciosFSM.e24.model.fsm.ElevatorContext;
import exerciciosFSM.e24.model.fsm.ElevatorStateAdapter;

 class FirstFloorState extends ElevatorStateAdapter {

    public FirstFloorState(ElevatorContext c, ElevatorData d) {
        super(c, d);
    }


    @Override
    public ElevatorState getState() {
        super.data.addINFO("GOING TO FIRST_FLOOR");
        return ElevatorState.FIRST_FLOOR;
    }

    
    @Override
    public void down() {
        super.data.addINFO("GOING TO GROUND_FLOOR");
        changeState(ElevatorState.GROUND_FLOOR);    
    }


    @Override
    public void up() {
         changeState(ElevatorState.SECOND_FLOOR);     
    }



}
