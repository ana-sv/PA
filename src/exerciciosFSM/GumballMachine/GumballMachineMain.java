package exerciciosFSM.GumballMachine;

import exerciciosFSM.GumballMachine.model.fsm.Context;
import exerciciosFSM.GumballMachine.ui.GumballMachineUI;

public class GumballMachineMain {
    public static void main(String[] args) {
        Context fsm = new Context(100);
        GumballMachineUI ui = new GumballMachineUI(fsm);
        ui.start();
    }
}