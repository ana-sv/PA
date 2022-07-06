package exerciciosFSM.e27;

import exerciciosFSM.e27.model.fsm.GameBWContext;
import exerciciosFSM.e27.model.ui.GameBWUI;

public class Main {
    public static void main(String[] args) {
        GameBWContext fsm = new GameBWContext();
        GameBWUI ui = new GameBWUI(fsm);
        ui.start();
    }
}
