package exemplos.GumballMachine;

import exemplos.GumballMachine.model.Context;
import exemplos.GumballMachine.ui.GumballMachineUI;

public class GumballMachineMain {
    public static void main(String[] args) {
    Context fsm = new Context(100);
    GumballMachineUI ui = new GumballMachineUI(fsm);
    ui.start();
    }
    }