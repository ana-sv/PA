package EXAMES.BasicClock_FSM.model.fsm;

public interface IState {

    void off(); 
    void display(); 

    void setHours();
    void setMinutes();
    void setSeconds(); 

    void set();
    void OnOff();

    void increment();
    void decrement(); 

    State getState();
       
}
