package exerciciosFSM.four_in_a_row;

import exerciciosFSM.four_in_a_row.model.data.FourInARowData;
import exerciciosFSM.four_in_a_row.ui.FourInARowUI;

public class FourInARow {
    public static void main(String[] args) {
        FourInARowData game = new FourInARowData();
        FourInARowUI gameui= new FourInARowUI(game);
        gameui.start();
    }
}
