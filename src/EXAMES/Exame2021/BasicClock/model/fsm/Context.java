package EXAMES.Exame2021.BasicClock.model.fsm;

import EXAMES.Exame2021.BasicClock.model.data.ClockData;

public class Context {
    private ClockData data; 
    private IState state;


    public Context() {
        this.data = new ClockData(00, 00, 00);           // referencia para o modelo de dados 
        this.state= State.DESLIGADO.createState(this, data);
    }

    public Context(int h,int m,int s) {
        this.data = new ClockData(h,m,s);           // referencia para o modelo de dados 
        this.state= State.DESLIGADO.createState(this, data);
    }

    // metodo package private para alterar o estado atual 
    void changeState(IState newState) {
        this.state = newState; 
    } 

    public State getState(){  // metodo public que permita obter o estado atual
        return state.getState();
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

    public void onOff() {
        state.OnOff();
    }

    public void increment() {
        state.increment();
    }

    public void decrement() {
        state.increment();
    }


    public String mostraRelogio(){
       return data.toString();
    }


    public int getH() {
        return data.getH();
    }

    public int getM() {
        return data.getM();
    }

    public int getS() {
        return data.getS();
    }    
}
