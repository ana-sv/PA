package exercises.e10.ui;

import java.util.Scanner;

import exercises.e10.model.HangmanModel;

public class HangmanTextUI {

    HangmanModel game;

    public HangmanTextUI(HangmanModel game) {
        this.game = game;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        String guess;

        while (!game.finished()) {
            System.out.println("Current: " + game.getCurrent());

            // read guess
            System.out.println("> ");
            guess = sc.next().toUpperCase();

            game.tryGuess(guess);

        }
        if (game.gotIt())
            // congrats. show word and attempts etc
            System.out.println("Congrats! " + game.getWord() + " on " + game.getAttempts() + " tries ");
        else
            // too bad. show word and attempts etc
            System.out.println("You Lost! The Word was " + game.getWord());

        sc.close();
    }

}