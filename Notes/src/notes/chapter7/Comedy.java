package notes.chapter7;

/** 
 * Class implementing Show to create comedies.
 * */ 
public class Comedy extends AbstractShow 
{
//	private final int aTime;
//	private String aTitle;
	private final String aComedian;
	
	/**
	 * Creates a comedy.
	 * @pre pTime > 0 && pTitle != null && pComedian != null && !pTitle.isBlank() && !pComedian.isBlank()
	 * */
	public Comedy(String pComedian, String pTitle, int pTime)
	{
		super(pTitle, pTime);
//		assert pTitle != null;
//		assert pTime > 0;
//		assert pComedian != null;
//		assert !pTitle.isBlank();
//		assert !pComedian.isBlank();
//		
//		aTime = pTime;
//		aTitle = pTitle;
		aComedian = pComedian;
	}

	/**
	 * Empty constructor for the SponsoredComedy class.
	 * */
//	public Comedy() 
//	{
//		aTime = 0;
//		aComedian = "";
//		aTitle = "";
//	}
	
	/**
	 * Copy constructor.
	 * @param pComedy Comedy to copy.
	 */
	public Comedy(Comedy pComedy) 
	{
//		this(pComedy.aComedian, pComedy.aTitle, pComedy.aTime);
		this(pComedy.aComedian, pComedy.title(), pComedy.time());
	}
	
//	@Override
//	public int time()
//	{
//		return aTime;
//	}
	
//	protected String title() 
//	{
//		return aTitle;
//	}
	
	// Which one gets called? 
//	public void setTitle(String pTitle) {
//		aTitle = pTitle;
//	}
//	
//	public void setTitle(Day pDay) {
//		aTitle = String.format("%s Night Comedy", pDay.name().charAt(0) + pDay.name().toLowerCase().substring(1));
//	}
//	
//	public void setTitle(Object pObject) {
//		aTitle = pObject.toString();
//	}
//	
//	public void setSimilar(Comedy pSimilar) {
//		System.out.println("Comedy");
//	}

//	@Override
//	public String description()
//	{
//		return String.format("%s with %s: %d minutes", title(), aComedian, time());
//	}

	@Override
	public String toString() 
	{
		return description();
	}

	@Override
	public Comedy copy()
	{
		return new Comedy(title(), aComedian, time());
	}

	@Override
	protected String extra()
	{
		return "by " + aComedian;
	}
}
