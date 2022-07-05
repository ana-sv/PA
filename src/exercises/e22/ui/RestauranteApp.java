package exercises.e22.ui;

import java.util.Arrays;

import exercises.e22.model.PublicidadeGastronomica;
import exercises.e22.model.Restaurantes.GaleriaDeSabores;
import exercises.e22.model.Restaurantes.Italix;
import exercises.e22.model.Restaurantes.Restaurante;
import exercises.e22.model.Restaurantes.UnburgerKong;
import exercises.e22.utils.Input;

public class RestauranteApp {

    public static void main(String[] args) {

        PublicidadeGastronomica publicidade = new PublicidadeGastronomica();

        Restaurante galeria = new GaleriaDeSabores(publicidade);
        Restaurante burger = new UnburgerKong(publicidade);
        Restaurante italix = new Italix(publicidade);

        String[] opcoes = { "[1]Vegetariano", "[2]Dieta", "[3]Italiano", "[4]Fast food", "[5]Geral", "[6]Sair" };
        int opcao = 0;
        // …
        
        while (opcao != 6) {
            opcao = Input.readInt( "\n " + Arrays.toString(opcoes) + "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Insicao opcao 1 a 6 : ");
            switch (opcao) {
                case 1:
                    System.out.println(publicidade.divulgaVegetarianos());
                    break;
                case 2:
                    System.out.println(publicidade.divulgaDietas());
                    break;
                case 3:
                    System.out.println(publicidade.divulgaItalianos());
                    break;
                case 4:
                    System.out.println(publicidade.divulgaFastFood());
                    break;
                case 5:
                    System.out.println(publicidade.divulgaGerais());
                    break;
            }
        }
    }
}