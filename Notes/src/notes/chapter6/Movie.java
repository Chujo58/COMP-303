package notes.chapter6;

/**
 * Class implementing Show to create movies.
 * */
public class Movie implements Show 
{
	private final int aTime;
    private final String aTitle;
    private final int aYear;
    
    /**
     * Copy constructor.
     * @param pMovie Movie to copy.
     */
    public Movie(Movie pMovie)
    {
    	this(pMovie.aTitle, pMovie.aYear, pMovie.aTime);
    }
    
    /**
     * Creates movie.
     * @pre pTime > 0 && pTitle != null && pYear >= 1800 && !pTitle.isBlank().
     * @param pTitle title of move
     * @param pYear year of movie
     * @param pTime duration
     * */
    public Movie(String pTitle, int pYear, int pTime) 
    {
        assert pTime > 0;
        assert pTitle != null;
        assert pYear >= 1800;
        assert !pTitle.isBlank();
        aYear = pYear;
        aTitle = pTitle;
        aTime = pTime;
    }
    
    @Override
    public int time()
    {
        return aTime;
    }

    @Override
    public String description()
    {
        return String.format("%s (%d) : %d minutes", aTitle, aYear, time());
    }
    
    @Override
    public String toString()
    {
        return description();
    }

	@Override
	public Movie copy()
	{
		return new Movie(this);
	}
}
