package notes.chapter7;

// import java.lang.reflect.Field;

/** 
 * Class implementing Show to create comedies.
 * */ 
public class Comedy extends AbstractShow implements Cloneable 
{
	private final String aComedian;
	
	/**
	 * Creates a comedy.
	 * @pre pComedian != null && !pComedian.isBlank()
	 * */
	public Comedy(String pComedian, String pTitle, int pTime)
	{
		super(pTitle, pTime);
		assert !pComedian.isBlank();
		aComedian = pComedian;
	}
	
// 	/**
// 	 * Copy constructor.
// 	 * @param pComedy Comedy to copy.
// 	 */
// 	public Comedy(Comedy pComedy) 
// 	{
// //		this(pComedy.aComedian, pComedy.aTitle, pComedy.aTime);
// 		this(pComedy.aComedian, pComedy.title(), pComedy.time());
// 	}

	@Override
	public String toString() 
	{
		return description();
	}

	@Override
	protected String extra()
	{
		return "by " + aComedian;
	}

	public Comedy copy(){
		//Using a getter title() just for the sake of accessing the aTitle field of AbstractShow is not the best.
		//Using meta programming we can get the aTitle field:
		// try {
		// 	Field field = AbstractShow.class.getDeclaredField("aTitle");
		// 	field.setAccessible(true);
		// 	String title = (String) field.get(this);
		// 	field.setAccessible(false);
		// 	return new Comedy(title, aComedian, time());
		// }
		// catch (ReflectiveOperationException e){
		// 	assert false;
		// 	return null;
		// }
		//This is not ideal ^

		//Use cloning instead
		return (Comedy) super.copy();	
	}
}
