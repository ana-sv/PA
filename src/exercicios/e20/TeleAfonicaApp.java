package exercicios.e20;

public class TeleAfonicaApp {

    public static void main(String[] args) {

        TeleAfonica t = new TeleAfonica();

        t.addCartaoTagarela(917744392, 5);
        t.addCartaoTagarela(917744390, 15);
        t.addCartaoPoucoTempo(917744391, 25);
        t.addCartaoPoucoTempo(917744393, 30);

        System.out.println("Lista Cartoes: \n" + t.listaCartoes());
        System.out.println("Ordenados por Numero : \n" + t.listaCartoesOrdenadosNumero());
        System.out.println("Ordenados por Saldo : \n" + t.listaCartoesOrdenadosSaldo());

        t.carregarCartao(917744390, 50);
        System.out.println("Ordenados por Saldo2 : \n" + t.listaCartoesOrdenadosSaldo());

        t.registarChamada(917744390, 935083844 , 2.37);
        t.registarChamada(917744390, 935083845 , 5.28);
        t.imprimeFaturaTXT(917744390);

        t.exportarInfoTXT();


    }

}
