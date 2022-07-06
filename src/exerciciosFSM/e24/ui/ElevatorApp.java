package exerciciosFSM.e24.ui;

import exerciciosFSM.e24.model.fsm.ElevatorContext;

public class ElevatorApp {

 
        public static void main(String[] args) {
            ElevatorContext fsm = new ElevatorContext();
            ElevatorUI ui = new ElevatorUI(fsm);
            ui.start();
        }
    
}