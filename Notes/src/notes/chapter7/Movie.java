package notes.chapter7;

/**
 * Class implementing Show to create movies.
 * */
public class Movie extends AbstractShow implements Cloneable
{
    private final int aYear;
    
    /**
     * Copy constructor.
     * @param pMovie Movie to copy.
     */
//     public Movie(Movie pMovie)
//     {
// //    	this(pMovie.aTitle, pMovie.aYear, pMovie.aTime);
//     	// this(pMovie.title(), pMovie.aYear, pMovie.time());
//     }
    
    /**
     * Creates movie.
     * @pre pYear >= 1800
     * @param pTitle title of move
     * @param pYear year of movie
     * @param pTime duration
     * */
    public Movie(String pTitle, int pYear, int pTime) 
    {
    	super(pTitle, pTime);
        assert pYear >= 1800;
        aYear = pYear;
    }

    @Override
    protected String extra() 
    {
    	return String.format("(%d)", aYear);
    }
    
    @Override
    public String toString()
    {
        return description();
    }

    @Override
    public Movie copy(){
        return (Movie) super.copy();
    }
}
