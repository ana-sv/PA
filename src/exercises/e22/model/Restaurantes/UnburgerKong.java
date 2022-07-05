package exercises.e22.model.Restaurantes;

import exercises.e22.model.PublicidadeGastronomica;

public class UnburgerKong extends Restaurante
{
    protected static final String NOME = "Burger King";
    protected static String [] MENUS_BASE_FAST_FOOD = {"FishBurger","ChickenBurger", "Tarte de maca com gelado"};
    protected static String [] MENUS_BASE_VEGETARIANOS = {"BeanBurger", "TofuBerger", "Sorvete de maca"};
        
    public UnburgerKong(PublicidadeGastronomica agenciaPub)
    {
        //Invoca o construtor da super classe, inicia os atributos da classe de base e regista-se na agencia de publicidade
        super(NOME);
        this.setMenusFastFood(MENUS_BASE_FAST_FOOD);
        this.setMenusVegetarianos(MENUS_BASE_VEGETARIANOS);
        agenciaPub.addRestaurante(this);   
    }        

}