package notes.chapter6;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.ArrayList;
import java.util.EnumMap;


public class ProgramV2
{
	private static Map<Day, Show> aShows = new EnumMap<Day, Show>(Day.class);
	
	/**Prototype pattern design*/
	private Show aPrototype = Show.NONE;
	private void setDefault(Show pShow) {
		aPrototype = pShow;
	}
	
	public void set(Day pDay, Show pShow) {
		assert pDay != null && pShow != null;
		aShows.put(pDay, pShow);
	}
	
	public void unset(Day pDay) {
		assert pDay != null;
		aShows.put(pDay, aPrototype.copy()); //This is where we use the prototype design pattern.
	}
	
	public Show get(Day pDay) {
		return aShows.get(pDay);
	}
	
	public void clear() {
		aShows.clear();
		for (Day day: Day.values()) {
			aShows.put(day, aPrototype.copy()); //This is also another place where we use the prototype design pattern. Basically we go back to a default state.
		}
	}
	
	public ProgramV2() {
		for (Day day: Day.values()) {
			set(day, aPrototype.copy());
		}
	}
	
	public Command createClearCommand() 
	{
		return new Command()
		{
			private Map<Day, Show> aPrevious = new EnumMap<Day, Show>(Day.class);
			
			@Override
			public void execute()
			{
				for (Day day : Day.values())
				{
					aPrevious.put(day, get(day));
				}
				clear();
			}

			@Override
			public void undo()
			{
				aShows = aPrevious;
			}
		};
	}
	
	public Command createSetCommand(Day pDay, Show pShow) 
	{
		return new Command()
		{
			private Show aPrevious;
			
			@Override
			public void execute()
			{
				aPrevious = get(pDay);
				set(pDay, pShow);
			}

			@Override
			public void undo()
			{
//				for (Show show: aPrevious) {
//					set(pDay, show);
//				}
				set(pDay, aPrevious);
			}
		};
	}
	
	public String toString() {
		StringJoiner description = new StringJoiner(",","[","]");
		for (Day day: Day.values()) {
			description.add(day.toString() + ": " + get(day).description());
		}
		return description.toString();
	}
}
