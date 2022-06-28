package exercises.e14;

public interface IGalaxy {

    public void newSystem( String SystemName );
    public void addStar( String SystemName, String star );
    public void addPlanet( String SystemName, String planet );

    public String getPlanet( String SystemName, int index );
    public String getStars( String SystemName );
    public boolean existsSystem( String SystemName );

    
}

