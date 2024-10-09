package notes.chapter6;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 *  Program manager. 
 * */
public class Program
{
	private static Map<Day, ArrayList<Show>> aShows = new HashMap<Day, ArrayList<Show>>();
	
	/**
	 *  Adds show to a day. 
	 *  @pre pDay != null && pShow != null
	 * */
	public void set(Day pDay, Show pShow)
	{
		assert pDay != null && pShow != null;
		if (!aShows.containsKey(pDay))
		{
			aShows.put(pDay, new ArrayList<Show>());
		}
		if (!aShows.get(pDay).contains(pShow))
		{
			aShows.get(pDay).add(pShow);
		}
	}
	
	/**
	 *  Gets shows in a day. 
	 *  @pre pDay != null
	 * */
	public ArrayList<Show> get(Day pDay)
	{
		assert pDay != null;
		if (!aShows.containsKey(pDay))
		{
			ArrayList<Show> toReturn = new ArrayList<Show>();
			toReturn.add(Show.NONE);
			return toReturn;
		}
		return aShows.get(pDay);
	}
	
	/** Clears the program. */
	public void clear() 
	{
		aShows.clear();		
	}
}
