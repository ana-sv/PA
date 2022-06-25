package exercises.e10.model;

import java.util.*;

public class HangmanModel {
    private static final int MAX_ERRORS = 7;
    private static final String HIDDEN = "*";

    private String secret; // Secret word to discover
    private StringBuffer current; // Word discovered so far. Starts with all dots "...... etc"
    private StringBuilder used; // leters used so far
    private int attempts;

    public HangmanModel() {
        setup();
    }

    public void setup() {
        // initialize stuff
        attempts = 0;
        used = new StringBuilder();

        // get a random word from dictionary etc
        secret = HangmanDictionary.getWord(new Random().nextInt(HangmanDictionary.getNumWords()));

        // hide the secret word
        assert secret != null;
        current = new StringBuffer(HIDDEN.repeat(secret.length()));

    }

    public boolean gotIt() {
        // true if the secret word has beend found
        return secret.equalsIgnoreCase(current.toString());
    }

    public boolean finished() {
        // true if the game is finished (either won or lost)
        return gotIt() || attempts == MAX_ERRORS;
    }

    public String getCurrent() {
        // return current know word (partially discovered)
        return current.toString();
    }

    public String getUsed() {
        // return string with letters already tried ("get used letters")
        return used.toString();
    }

    public int getAttempts() {
        // number of attempts
        return attempts;
    }

    public String getWord() {
        // return secret word
        // (make sure to prevent winning the game after this is called)
        return secret.toString();
    }

    public boolean tryGuess(String guess) {
        // receives string one letter or one word
        // one leter -> replace matching in scecret
        // one word -> compare entire word
        // update counters, status etc
        // return false if guess is ignored, true otherwise~
        guess = guess.toUpperCase();

        if (finished())
            return true;

        if (guess.isBlank())
            return false;

        if (guess.length() == 1) {
            char chStr = guess.charAt(0);

            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == chStr) {
                    current.setCharAt(i, chStr);
                    attempts++;
                    return true;
                }

            }

        } else {
            if (guess.equals(secret)) {
                current = new StringBuffer(secret);
                return true;
            }

        }
        return false;

    }

}