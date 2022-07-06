package exerciciosFSM.e24.model.fsm;


import exerciciosFSM.e24.model.data.ElevatorData;
import exerciciosFSM.e24.model.fsm.states.ElevatorState;

public abstract class ElevatorStateAdapter implements IElevatorState {
    protected ElevatorContext context; 
    protected ElevatorData data;

    protected ElevatorStateAdapter(ElevatorContext c, ElevatorData d){
        this.context = c;
        this.data = d; 
    }

    protected void changeState( ElevatorState newState ){
        context.changeState(newState.createState(context,data));
    }
   @Override
    public ElevatorState getState() {
        return null;
    }


    @Override
    public void down(){}


    @Override
    public void safetykey() {
        data.addINFO("ERROR - GOING TO GROUND_FLOOR");
        changeState(ElevatorState.GROUND_FLOOR);
    }


    @Override
    public void up() {}
}
