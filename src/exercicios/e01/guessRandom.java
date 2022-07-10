package exercicios.e01;

import java.util.Scanner;

public class guessRandom {

    public final static int MIN = 0;
    public final static int MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sup = MAX;
        int inf = MIN;
        int guess, option;

        guess = inf + (int) (Math.random() * (sup - inf));

        do {
            System.out.println(" \n** Guess the number ! ** ");
            System.out.print("> ");
            option = sc.nextInt();

            if (guess == option) {
                System.out.println("- THAT'S THE NUMBER , YOU WIN! ");
                sc.close();
            } else if (guess > option) {
                System.out.println("- That number is too low ");
            } else if (guess < option) {
                System.out.println("-  That number is too high ");
            }

        } while (guess != option);

    }
}
