package exercicios.e14;

import java.util.HashMap;
import java.util.Map;

public class Galaxia implements IGalaxia {

    protected String galaxyName;
    protected Map<String, Sistema> sistemas;

    public Galaxia() {
        this.sistemas = new HashMap<String, Sistema>();
    }

    @Override
    public void newSystem(String name) {
        if (!this.sistemas.containsKey(name))
            return;

        this.sistemas.put(name, new Sistema(name));
    }

    @Override
    public void addStar(String name, String star) {
        if (!this.sistemas.containsKey(name)) {
            this.sistemas.put(name, new Sistema(name));
        }
        this.sistemas.get(name).addStar(star);

    }

    @Override
    public void addPlanet(String name, String planet) {
        if (!this.sistemas.containsKey(name)) {
            this.sistemas.put(name, new Sistema(name));
        }
        this.sistemas.get(name).addPlanet(planet);

    }

    @Override
    public String getPlanet(String name, int index) {
        if (!this.sistemas.containsKey(name)) {
            return null;
        }
        return this.sistemas.get(name).getArrayPlanets().get(index - 1);
    }

    @Override
    public String getStars(String name) {
        if (!this.sistemas.containsKey(name)) {
            return null;
        }
        return this.sistemas.get(name).getArrayEstrelasToString();

    }

    @Override
    public boolean existsSystem(String name) {
        if (!this.sistemas.containsKey(name))
            return false;

        return true;
    }

}
