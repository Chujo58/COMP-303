package notes.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Implementation of our Composite Design Pattern as mentioned in DoubleBill.
 * */
public class CompositeShow implements Show
{
	private final List<Show> aShows;
	
	/**
	 * Constructor.
	 * */
	public CompositeShow(Show...pShows)
    {
		for (Show show: pShows)
		{
			assert show != null;
		}
        // Check for nulls, etc.
        aShows = Arrays.asList(pShows);
    }  

	@Override
	public int time()
	{
		int result = 0;
		for (Show show: aShows)
		{
			result += show.time();
		}
		return result;
	}

	@Override
    public String description()
    {
        StringJoiner description = new StringJoiner(",", "[", "]");
        for( Show show : aShows )
        {
            description.add(show.description());
        }
        return description.toString();
    }	
}
