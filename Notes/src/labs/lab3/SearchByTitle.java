package labs.lab3; 

import java.util.ArrayList;

/**
 * Search by title.
 * */
public class SearchByTitle implements SearchStrategy
{

	@Override
	public Song search(String pTitle, ArrayList<Song> pList) throws Exception
	{
		for (Song song: pList) 
		{
			if (song.getArtist().equals(pTitle)) 
			{
				return song;
			}
		}
		throw new Exception("Song not found");
	}

}
