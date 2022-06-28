package exercises.e14;

import java.util.ArrayList;
import java.util.HashMap;


public class Galaxy implements IGalaxy{ 

    protected String GalaxyName;       
    protected HashMap< String, HashMap< ArrayList<String>,ArrayList<String> > > systems ; 
                    //SystemName       //arrayPlanets       //arrayStars   
   
    public Galaxy() {
    }

    @Override
    public void newSystem(String SystemName) {
        // TO DO Auto-generated method stub
        
    }
    @Override
    public void addStar(String SystemName, String star) {
        // TO DO Auto-generated method stub
        
    }
    @Override
    public void addPlanet(String SystemName, String planet) {
        // TO DO Auto-generated method stub
        
    }
    @Override
    public String getPlanet(String SystemName, int index) {
        // TO DO Auto-generated method stub
        return null;
    }
    @Override
    public String getStars(String SystemName) {
        // TO DO Auto-generated method stub
        return null;
    }
    @Override
    public boolean existsSystem(String SystemName) {
        // TO DO Auto-generated method stub
        return false;
    }
    
    







}
