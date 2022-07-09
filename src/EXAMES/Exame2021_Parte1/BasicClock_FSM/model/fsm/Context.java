package EXAMES.Exame2021_Parte1.BasicClock_FSM.model.fsm;

import EXAMES.Exame2021_Parte1.BasicClock_FSM.model.data.ClockData;

public class Context {
    private ClockData data; 
    private IState state;


    public Context() {
        this.data = new ClockData(00, 00, 00);
        this.state= State.DESLIGADO.createState(this, data);
    }


    void changeState(IState newState) {
        this.state = newState; 
    } 


    public String getState(){
        return state.toString();
    }

    public void ligaRelogio(){
        state.OnOff();
    }

    public void setMinutes(int min){
        state.setMinutes();
    }

    public void set(){
        state.set();
    }


    public String mostraRelogio(){
       return data.toString();
    }

    

    
}
