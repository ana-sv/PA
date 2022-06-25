package exercises.e03;

import java.util.Scanner;

public class ArrayApp {

    public static int[] array;

    public static void AprintArray() {
        System.out.print("> Array: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i] + " ");

    }

    public static void BcalculaMaiorMenor() {
        int maior = 0;
        int menor = 100;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maior)
                maior = array[i];
            if (array[i] < menor)
                menor = array[i];
        }
        System.out.println(">Maior: " + maior + " Menor: " + menor);

    }

    public static void CsomaElementos() {
        int soma = 0;
        for (int i = 0; i < array.length; i++) {
            soma = +array[i];
        }
        System.out.println(">Soma: " + soma);
    }

    public static void DcalculaMedia() {
        int soma = 0;
        for (int i = 0; i < array.length; i++) {
            soma = +array[i];
        }
        System.out.println(">Media: " + soma / array.length);

    }

    public static void EinverteArray() {
        int[ ] arrayInvertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
             arrayInvertido[ array.length-11 - i] = array[i];
        }
        array = arrayInvertido; 
        for (int i = 0; i < array.length; i++)
        System.out.print(" " + array[i] + " ");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tam;

        System.out.println("Insira o tamanho do Array : ");
        tam = sc.nextInt();

        array = new int[tam];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Insira o elemento " + i + " do array : ");
            array[i] = sc.nextInt();
        }
        sc.close();

        AprintArray();
        BcalculaMaiorMenor();
        CsomaElementos();
        DcalculaMedia();
        EinverteArray();



    }

}
