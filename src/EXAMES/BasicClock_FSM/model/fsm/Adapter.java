package EXAMES.BasicClock_FSM.model.fsm;

import EXAMES.BasicClock_FSM.model.data.ClockData;

public abstract class Adapter implements IState  {
    protected Context context;
    protected ClockData data;

    protected Adapter(Context context, ClockData data){
        this.context = context; 
        this.data = data;
    }

    protected void changeState(State newState){
        context.changeState(newState.createState(context, data));
    }

    @Override
    public void OnOff(){
        if( data.getOnOff() == true ){
            data.setOnOff(false);
            changeState(State.DESLIGADO);
         } else{
            data.setOnOff(true); 
            changeState(State.DISPLAY);
        }
    }


    @Override
    public void decrement(){}

    @Override
    public void display() {}

    @Override
    public void increment() {}

    @Override
    public void off(){
        data.setOnOff(false);
    }

    @Override
    public void set(){}

    @Override
    public void setHours() {}

    @Override
    public void setMinutes() {}

    @Override
    public void setSeconds(){};
    
}
