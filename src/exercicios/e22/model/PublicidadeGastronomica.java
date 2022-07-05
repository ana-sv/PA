package exercicios.e22.model;

import java.util.ArrayList;
import java.util.List;

import exercicios.e22.model.Restaurantes.Restaurante;

public class PublicidadeGastronomica
{
    protected List <Restaurante> menusGerais;
    protected List <Restaurante> menusDieta;
    protected List <Restaurante> menusFastFood;
    protected List <Restaurante> menusItalianos;
    protected List <Restaurante> menusVegetarianos;
    
    public PublicidadeGastronomica()
    {
        this.menusGerais = new ArrayList<>();
        this.menusDieta = new ArrayList<>();
        this.menusFastFood =  new ArrayList<>();
        this.menusItalianos =  new ArrayList<>();
        this.menusVegetarianos =  new ArrayList<>();

    }
    
    public void addRestaurante(Restaurante restaurante)
    {
        
        if(restaurante == null)
            return;
            
        addGeral(restaurante);
        addDieta(restaurante);
        addFastFood(restaurante);
        addItaliano(restaurante);
        addVegetariano(restaurante);                

    }
    
    public boolean addGeral(Restaurante restaurante)
    {             
        if(restaurante == null)
            return false;
        
        if(restaurante.getMenusGerais() == null)
            return false;
                
        if(restaurante.getMenusGerais().length > 0 && !menusGerais.contains(restaurante)){
            menusGerais.add(restaurante);
            return true;
        }
        
        return false;
    }
    
    public boolean addDieta(Restaurante restaurante)
    {                 
        if(restaurante == null)
            return false;
        
        if(restaurante.getMenusDieta() == null)
            return false;
                
        if(restaurante.getMenusDieta().length > 0 && !menusDieta.contains(restaurante)){
            menusDieta.add(restaurante); 
            return true;
        }
        
        return false;
    }
    
    public boolean addFastFood(Restaurante restaurante)
    {               
        if(restaurante == null)
            return false;
        
        if(restaurante.getMenusFastFood() == null)
            return false;
        
        if(restaurante.getMenusFastFood().length > 0 && !menusFastFood.contains(restaurante)){
            menusFastFood.add(restaurante);
            return true;
        }
        
        return false;
    }
    
    public boolean addItaliano(Restaurante restaurante)
    {              
        if(restaurante == null)
            return false;
        
        if(restaurante.getMenusItalianos() == null)
            return false;
        
        if(restaurante.getMenusItalianos().length > 0 && !menusItalianos.contains(restaurante)){
            menusItalianos.add(restaurante);
            return true;
        }
        
        return false;
    }
    
    public boolean addVegetariano(Restaurante restaurante)
    {              
        if(restaurante == null)
            return false;
        
        if(restaurante.getMenusVegetarianos() == null)
            return false;
        
        if(restaurante.getMenusVegetarianos().length > 0 && !menusVegetarianos.contains(restaurante)){
            menusVegetarianos.add(restaurante);
            return true;
        }
        
        return false;
    }
        
    public String divulgaGerais()
    {
        String s = "\n>>>>> Menus gerais:";
    
        for(Restaurante r:menusGerais){
            
            s += "\r\n\r\n\t" + r.getNome() + ": ";
            
            for(String m:r.getMenusGerais())
                s += "\r\n\r\n\t\t" + m;
        
        }
        
        return s;
    }
    
    public String divulgaDietas()
    {
        String s = "\n>>>>> Menus dieta:";
    
        for(Restaurante r:menusDieta){
            
            s += "\r\n\r\n\t" + r.getNome() + ": ";
            
            for(String m:r.getMenusDieta())
                s += "\r\n\r\n\t\t" + m;
        
        }
        
        return s;
    }
    
    public String divulgaFastFood()
    {
        String s = "\n>>>>> Menus \"fast food\":";
    
        for(Restaurante r:menusFastFood){
            
            s += "\r\n\r\n\t" + r.getNome() + ": ";
                    
            for(String m:r.getMenusFastFood())
                s += "\r\n\r\n\t\t" + m;
        
        }
        
        return s;
    }
    
    public String divulgaItalianos()
    {
        String s = "\n>>>>> Menus italianos:";
    
        for(Restaurante r:menusItalianos){
            
            s += "\r\n\r\n\t" + r.getNome() + ": ";
            
            for(String m:r.getMenusItalianos())
                s += "\r\n\r\n\t\t" + m;
        
        }
        
        return s;
    }
    
    public String divulgaVegetarianos()
    {
        String s = "\n>>>>> Menus vegetarianos:";
    
        for(Restaurante r:menusVegetarianos){
            
            s += "\r\n\r\n\t" + r.getNome() + ": ";
            
            for(String m:r.getMenusVegetarianos())
                s += "\r\n\r\n\t\t" + m;
        
        }
        
        return s;
    }
            
    
}