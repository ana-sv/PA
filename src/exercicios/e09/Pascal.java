package exercicios.e09;

import java.util.Scanner;

public class Pascal {
    public static final int MAX_LINHAS = 10;
    public static final int TAM_ESPACO_NUMERO = 4;
    protected int nLinhas;
    protected int[][] triangulo;

    public Pascal(int n) {
        nLinhas = n;

        triangulo = new int[nLinhas][];

        int i;
        int j;
        for (i = 0; i < nLinhas; ++i) {
            triangulo[i] = new int[i + 1];
            triangulo[i][0] = triangulo[i][i] = 1;

            for (j = 1; j < i; ++j) {
                triangulo[i][j] = triangulo[i - 1][j] + triangulo[i - 1][j - 1];
            }
        }
    }

    public void printPascal() {
        int i, j;

        for (i = 0; i < nLinhas; ++i) {
            System.out.format("%" + (nLinhas - i) * 4 / 2 + "s", "");

            for (j = 0; j <= i; ++j) {
                System.out.format("%4s", triangulo[i][j]);
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de linhas (1-10): ");

        int nLinhas;
        nLinhas = sc.nextInt();

        System.out.println();
        if (nLinhas < 1 || nLinhas > 10) {
            System.out.print("Apenas valores entre 1 e 10!");
        } else {
            Pascal p = new Pascal(nLinhas);
            p.printPascal();

        }
        sc.close();
    }
}
