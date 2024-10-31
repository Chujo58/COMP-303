package notes.chapter6;

import java.util.Map;
import java.util.ArrayList;
import java.util.EnumMap;

/**
 *  Program manager. 
 * */
public class Program
{
	private static Map<Day, ArrayList<Show>> aShows = new EnumMap<Day, ArrayList<Show>>(Day.class);
			//new HashMap<Day, ArrayList<Show>>();
	
	/**Prototype pattern design*/
	private Show aPrototype = Show.NONE;
	private void setDefault(Show pShow) 
	{
		aPrototype = pShow;
	}
	
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
	
	public void unset(Day pDay) {
		assert pDay != null;
//		aShows.put(pDay, aPrototype.copy()); //Once again assuming we only have one show per day.
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
		// This part is assuming that there is only one show per day.
		for (Day day: Day.values()) {
			aShows.get(day).clear(); //Clear the arraylist
			aShows.get(day).add(aPrototype.copy());
//			aShows.put(day, aPrototype.copy());			
		}
	}
	
	
	public class ClearProgram implements Command
	{
//		private final Program aProgram;
//		
//		public ClearProgram(Program pProgram) {
//			aProgram = pProgram;
//		}
		
		@Override
		public void execute()
		{
//			aProgram.clear();
			Program.this.clear(); //Call upon parent class
		}

		@Override
		public void undo()
		{
			
		}

	}
	
	public Command createClearCommand() 
	{
		return new Command()
		{
			private Map<Day, ArrayList<Show>> aPrevious;
			
			@Override
			public void execute()
			{
				for (Day day : Day.values())
				{
					aPrevious.put(day, get(day));
				}
				Program.this.clear();
			}

			@SuppressWarnings("static-access")
			@Override
			public void undo()
			{
				Program.this.aShows = aPrevious;
			}
		};
	}
	
	public Command createSetCommand(Day pDay, Show pShow) 
	{
		return new Command()
		{
			private ArrayList<Show> aPrevious;
			
			@Override
			public void execute()
			{
				aPrevious = Program.this.get(pDay);
				Program.this.set(pDay, pShow);
			}

			@Override
			public void undo()
			{
				for (Show show: aPrevious) {
					set(pDay, show);
				}
			}
		};
	}

}
