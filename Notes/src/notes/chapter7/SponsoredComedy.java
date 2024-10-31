package notes.chapter7;

public class SponsoredComedy extends Comedy
{
	private int aSponsorTime;
	private String aSponsor;
	
	public SponsoredComedy(String pSponsor, int pSponsorTime, String pComedian, String pTitle, int pTime) {
		//Call constructor of Comedy. The one without any arguments.
		
		//If there isn't a constructor without arguments, what do we do? 
		//For a really bad solution, we could make the elements of Comedy public. That's a terrible idea.
		//Protected: within the same package and subclasses. The field is almost public.	
		
		//We call super with the arguments.
		super(pComedian, pTitle, pTime);
		
		assert pSponsor != null;
		aSponsor = pSponsor;
		aSponsorTime = pSponsorTime;
	}
	
	public void setSimilar(SponsoredComedy pSimilar) {
		System.out.println("Sponsored Comedy");
	}
	
	public int time() {
		return super.time() + aSponsorTime;
	}
	
	@Override
	protected String extra()
	{
		return super.extra() + " sponsored by " + aSponsor;
	}
	
//	public String description() {
//		return String.format("%s sponsored by %s (%d)", super.title(), aSponsor, time());
//	}
	
	
	
//	@Override
//	public int time()
//	{
//		return 0;
//	}
//
//	@Override
//	public String description()
//	{
//		return String.format("%s sponsored by %s (%d)", title(), aSponsor, time());
//	}
//	
//	//How do we get the title?
//	private String title() {
//		return "";
//	}
//
//	@Override
//	public Show copy()
//	{
//		return null;
//	}
//	
}
