package notes.chapter7;

public abstract class AbstractShow implements Show
{
	private final int aTime;
	private final String aTitle;
	
	protected AbstractShow(String pTitle, int pTime) { //No one can make instances aside from subclasses/children classes.
		assert !pTitle.isBlank() && pTitle != null;
		assert pTime > 0;
		aTitle = pTitle;
		aTime = pTime;
	}
	
	@Override
	public int time() {
		return aTime;
	}
	
	//Template method pattern
	protected abstract String extra(); //We want to be able to call it, but not implement it.
	
	public String description() {
		return String.format("[%s %s (%dmin)]", aTitle, extra(), time());
	}

	@Override
	public Show copy(){
		try
		{
			return (Show) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			System.out.println("Error!");
			return null;
		}
	}
}
