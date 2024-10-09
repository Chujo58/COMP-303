package notes.chapter6;

/**
 * Show interface to be used for movie, comedies, etc.
 * */
public interface Show
{
	Show NONE = new Show() 
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
		
	};
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
}