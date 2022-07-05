
package exercicios.e10.ui;

import exercicios.e10.model.HangmanModel;

public class HangmanGame {
    public static void main(String[] args) throws Exception {
        HangmanModel game = new HangmanModel();
        HangmanTextUI gameUI = new HangmanTextUI(game);
        gameUI.play();
    }
}