package exerciciosFSM.e24.model.fsm;

import exerciciosFSM.e24.model.data.ElevatorData;
import exerciciosFSM.e24.model.fsm.states.ElevatorState;

// NOTE : nao deve disponibilizar metodos que oermitem a alteração direta de dados

public class ElevatorContext {
	// tem referencia para estado atual e dados 
	private ElevatorData data; 
	private IElevatorState state;

	public ElevatorContext() {
		this.data =  new ElevatorData();
		this.state = ElevatorState.GROUND_FLOOR.createState(this, data);
	}


	// metodo publico que permite  obter o estado atual 
 	 public ElevatorState getState(){
       return state.getState();
    }

	// metodo package private que permite alterar o estado atual 
	void changeState(IElevatorState newState) {
		state = newState; 
	}

	// metodos necessários à interação do programa com o utilizador 
	public String toString(){
        return data.toString();
    }

    public void up(){
        state.up(); 
    }
    public void down(){
       state.down();
    }

    public void safetyKey() { state.safetykey(); }




}
