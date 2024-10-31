package notes.chapter7;

public abstract class AbstractShow implements Show
{
	private final int aTime;
	private final String aTitle;
	
	protected AbstractShow(String pTitle, int pTime) { //No one can make instances aside from subclasses/children classes.
		aTitle = pTitle;
		aTime = pTime;
	}
	
	@Override
	public int time() {
		return aTime;
	}
	
	protected String title() {
		return aTitle;
	}
	
	//Template method pattern
	protected abstract String extra(); //We want to be able to call it, but not implement it.
//	{
//		return "";
//	}
	
	public String description() {
		return String.format("[%s %s (%dmin)]", title(), extra(), time());
	}
}
