package notes.chapter6;

/** 
 * Class implementing Show to create comedies.
 * */ 
public class Comedy implements Show
{
	private final int aTime;
	private final String aTitle;
	private final String aComedian;
	
	/**
	 * Creates a comedy.
	 * @pre pTime > 0 && pTitle != null && pComedian != null && !pTitle.isBlank() && !pComedian.isBlank()
	 * */
	public Comedy(String pComedian, String pTitle, int pTime)
	{
		assert pTitle != null;
		assert pTime > 0;
		assert pComedian != null;
		assert !pTitle.isBlank();
		assert !pComedian.isBlank();
		
		aTime = pTime;
		aTitle = pTitle;
		aComedian = pComedian;
	}

	@Override
	public int time()
	{
		return aTime;
	}

	@Override
	public String description()
	{
		return String.format("%s with %s: %d minutes", aTitle, aComedian, time());
	}
	
	@Override
	public String toString() 
	{
		return description();
	}
}
