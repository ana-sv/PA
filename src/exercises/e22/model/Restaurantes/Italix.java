package exercises.e22.model.Restaurantes;

import exercises.e22.model.PublicidadeGastronomica;

public class Italix extends Restaurante
{
    protected static final String NOME = "Italia";
    protected final String [] MENUS_BASE_GERAIS = {"Lulas recheadas com presunto", "Leite creme"};
    protected final String [] MENUS_BASE_ITALIANOS = {"Lasanha dourada com mozarella", "Lasanha do mar", "Tiramisu"};
            
    public Italix(PublicidadeGastronomica agenciaPub)
    {
        //Invoca o construtor da super classe, inicia os atributos da classe de base e regista-se na agencia de publicidade
        super(NOME); 
        this.setMenusGerais(MENUS_BASE_GERAIS);
        this.setMenusItalianos(MENUS_BASE_ITALIANOS);   
        agenciaPub.addRestaurante(this);
    }        
    
}