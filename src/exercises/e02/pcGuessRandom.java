package exercises.e02;

import java.util.Scanner;

public class pcGuessRandom {


    public final static int MIN = 0; 
    public final static int MAX = 100; 


    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        int sup = MAX; 
        int inf = MIN;
        int guess, option, tries=0 ; 

        System.out.println(" \n**  Pense num numero .... ** ");

        do{


            guess = inf + (int)( Math.random() * (sup-inf) );
            System.out.println("O numero e' " + guess + " ? ");
            System.out.println("[1] Pensei num numero maior!  ");
            System.out.println("[2] Pensei num numero menor!  ");
            System.out.println("[3] Acertou !  ");
            option =  sc.nextInt(); 

            if(option == 1 )
                inf = guess; 
            if (option == 2 )
                sup = guess; 

                tries++; 


        }while(option != 3 );

        System.out.println(" Acertei com " + tries + " tentativas! O numero é o "  + guess + " ! " );
        sc.close();

    }
    
    
}
