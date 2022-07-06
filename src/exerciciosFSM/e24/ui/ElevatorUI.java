package exerciciosFSM.e24.ui;

import exerciciosFSM.e24.model.fsm.ElevatorContext;

public class ElevatorUI {
    ElevatorContext context; 

    public ElevatorUI(ElevatorContext context) {
        this.context = context; 
    }

    public void start() {
        System.out.println(context.getState().toString());
        context.up();
        System.out.println(context.getState().toString());
        context.up();
        System.out.println(context.getState().toString());
        context.up();
        System.out.println(context.getState().toString());
        context.down();
        System.out.println(context.getState().toString());

    }

}