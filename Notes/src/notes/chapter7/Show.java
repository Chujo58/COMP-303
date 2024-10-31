package notes.chapter7;

/**
 * Show interface to be used for movie, comedies, etc.
 * */
public interface Show
{
	Show NONE = createShowNone();
	
	private static Show createShowNone() //Create a None factory to make copies (different objects) of the NONE object.
	{
		return new Show() 
		{
			@Override
			public int time()
			{
				return 0;
			}

			@Override
			public String description()
			{
				return "No show";
			}
			
			@Override
			public boolean isNone() 
			{
				return true;
			}

			@Override
			public Show copy()
			{
				return createShowNone();
			}
			
		};
	}
	
    /**
     * @return The running time in minutes
     * @post > 0
     */
    int time();
    
    /**
     * @return A description of the show
     * @post != null && !isBlank()
     */
    String description();
    
    /** Returns if object is null/none or not.*/
    default boolean isNone() 
    {
    	return false;
    }
    
    /**
     * @return A different object which is a conceptual copy of current object.
     * */
    Show copy();
}