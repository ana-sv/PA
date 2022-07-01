package exercises.e14;

public interface IGalaxia {

    public void newSystem( String nnome );
    public void addStar( String name, String star );
    public void addPlanet( String name, String planet );

    public String getPlanet( String name, int index );
    public String getStars( String name );
    public boolean existsSystem( String name );

    
}

