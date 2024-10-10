package notes.chapter6;

/**
 * Two shows instead of one!
 * This isn't super useful. What if we want more shows, what if they aren't movies? Let's make a composite show using Composite Design Pattern
 * */
public class DoubleBill implements Show
{
	private final Movie aMovie1;
    private final Movie aMovie2;
    
    /**
     * @param pMovie1 The first movie to play in the show
     * @param pMovie2 The second move to play in the show
     */
    public DoubleBill(Movie pMovie1, Movie pMovie2)
    {
        aMovie1 = pMovie1;
        aMovie2 = pMovie2;
    }

    @Override
    public int time()
    {
        return aMovie1.time() + aMovie2.time();
    }

	@Override
	public String description()
	{
		return aMovie1.description() + aMovie2.description();
	}
	
	@Override
	public String toString() 
	{
		return description();
	}

	@Override
	public Show copy()
	{
		//One solution:
		return new DoubleBill(aMovie1.copy(), aMovie2.copy());
		//Better solution: covariant return type: change the return type of copy for each implementing class.
		
	}
}
