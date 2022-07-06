package exerciciosFSM.e27.model.ui;

import exerciciosFSM.e27.model.fsm.GameBWContext;

public class GameBWUI {
    GameBWContext fsm;

    public GameBWUI(GameBWContext fsm) {
        this.fsm = fsm;
    }

    private boolean finish = false;
    public void start() {
        while(!finish) {
            showResults();
            if (fsm.getState() == null) System.exit(-1); // TODO: remove!
            switch (fsm.getState()) {
                //TODO: cases
            }
        }
    }

    private void showResults() {
        System.out.println("\n*** Game GW ***");
        System.out.printf("White Balls won: %d\n",fsm.getNrWhiteBallsWon());
        System.out.printf("White Balls out: %d\n",fsm.getNrWhiteBallsOut());
        System.out.printf("Black Balls out: %d\n",fsm.getNrBlackBallsOut());
    }
}
