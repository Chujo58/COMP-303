package notes.chapter7;

/**
 * Decorator Class.
 * */
public class IntroducedShow implements Show
{
	private final Show aShow;
	private final String aSpeaker;
	private final int aTime;

	
	
	/**
	 * Constructor.
	 * @param pShow Show to wrap
	 * @param pSpeaker String for the name of the speaker
	 * @param pTime int for the length of the introduction
	 */
	public IntroducedShow(Show pShow, String pSpeaker, int pTime)
	{
		aShow = pShow;
		aSpeaker = pSpeaker;
		aTime = pTime;
	}

	/**
	 * Copy constructor.
	 * @param pShow Show to copy.
	 */
	public IntroducedShow(IntroducedShow pShow)
	{
		//Bellow might not work if aShow is mutable.
		this(pShow.aShow, pShow.aSpeaker, pShow.aTime);
		
		//Bad fix:
//		aSpeaker = pShow.aSpeaker;
//		aTime = pShow.aTime;
//		Show copy = null;
//		if (pShow.aShow instanceof Movie movie) {
//			copy = new Movie(movie);
//		}
//		else if (pShow.aShow instanceof Comedy) {
//			copy = new Comedy((Comedy) pShow.aShow);
//		}
		
		//Better fix:
		//Create a copy method in the Show class.
	}
	
	@Override
	public int time()
	{
		return aTime + aShow.time();
	}

	@Override
	public String description()
	{
		return String.format("%s introduced by %s (%d minutes)", aShow.description(), aSpeaker, time());  
	}

	@Override
	public Show copy()
	{
		return new IntroducedShow(aShow.copy(), aSpeaker, aTime);
	}
	
}
