package exercises.e14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Galaxy implements IGalaxy{ 

    protected String GalaxyName;       
    protected HashMap< String, HashMap< ArrayList<String>,ArrayList<String> > > systems ; 
                    //SystemName       //arrayPlanets       //arrayStars   
   
    public Galaxy() {
    }

    @Override
    public void newSystem(String SystemName) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void addStar(String SystemName, String star) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void addPlanet(String SystemName, String planet) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public String getPlanet(String SystemName, int index) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getStars(String SystemName) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean existsSystem(String SystemName) {
        // TODO Auto-generated method stub
        return false;
    }
    
    







}
