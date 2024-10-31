package notes.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Implementation of our Composite Design Pattern as mentioned in DoubleBill.
 * */
public class CompositeShow implements Show, Cloneable
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

	@Override
	public Show copy()
	{
		List<Show> copies = new ArrayList<Show>();
		for (Show show: aShows) 
		{
			copies.add(show.copy());
		}
		return new CompositeShow(copies.toArray(new Show[0]));

		//The original solution is better. Look right above.
		// try
		// {
		// 	// return (CompositeShow) super.clone();
		// 	List<Show> copied = new ArrayList<>();
		// 	CompositeShow copy = (CompositeShow) super.clone();

		// 	for (Show show: aShows){
		// 		copied.add(show.copy());
		// 	}
		// 	copy.aShows = copied; //Would need to remove the final keyword which isn't ideal.
		// 	return copy;
		// }
		// catch (CloneNotSupportedException e)
		// {
		// 	assert false;
		// 	System.out.println("Error");
		// 	return null;
		// }
	}	
}
