package exercises.e22.model.Restaurantes;

import exercises.e22.model.PublicidadeGastronomica;

public class GaleriaDeSabores extends Restaurante
{
    protected static final String NOME = "Galeria dos sabores";
    protected final String [] MENUS_BASE_GERAIS = {"Bifes de peru com molho de cenoura", "Bacalhau com natas", "Salmao grelhado", "Arroz doce"};
    protected final String [] MENUS_BASE_VEGETARIANOS = {"Empadao de tofu", "Requeijao com molho de ervas e mel", "Sorvete de maca"};
    protected final String [] MENUS_BASE_DIETA = {"Salada meditarranica","Salada nicoise", "Maca acada"};
    protected final String [] MENUS_BASE_ITALIANOS = {"Tagliateli a la carbonara", "Risoto de legumes", "Gelado de cafe"};
        
    public GaleriaDeSabores(PublicidadeGastronomica agenciaPub)
    {
        //Invoca o construtor da super classe, inicia os atributos da classe de base e regista-se na agencia de publicidade
        super(NOME);
        this.setMenusGerais(MENUS_BASE_GERAIS);
        this.setMenusVegetarianos(MENUS_BASE_VEGETARIANOS);
        this.setMenusDieta(MENUS_BASE_DIETA);
        this.setMenusItalianos(MENUS_BASE_ITALIANOS);
        agenciaPub.addRestaurante(this);

     
    }        
    
}