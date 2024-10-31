package comp303.music;

import java.util.ArrayList;
import java.util.List;

/**
 * A music library containing multiple songs, that can
 * be organized in different ways.
 */
public class Library extends MusicComponent
{
	private List<MusicComponent> aElements = new ArrayList<>();

	public Library(ArrayList<MusicComponent> pComponents) 
	{
		for (MusicComponent elem: pComponents) 
		{
			assert elem != null;
		}
		aElements = new ArrayList<MusicComponent>(pComponents);
	}
	
	@Override
	public void play()
	{
		for (MusicComponent elem: aElements) 
		{
			elem.play();
		}
	}
	
	@Override
	public Library clone() throws CloneNotSupportedException 
	{
		Library clone = (Library) super.clone();
		ArrayList<MusicComponent> oldElements = new ArrayList<MusicComponent>(aElements);
		// Make sure to deep copy the MusicComponents:
		clone.aElements.clear(); //Clear the shallow copied clone aElements.
		
		for (MusicComponent elem: oldElements) 
		{
			MusicComponent clonedElem = elem.clone();
			clone.aElements.add(clonedElem);
		}
		return clone;
	}
}
