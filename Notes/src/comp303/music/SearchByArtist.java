package comp303.music;

import java.util.ArrayList;

/**
 * Search song by artist.
 * */
public class SearchByArtist implements SearchStrategy
{

	@Override
	public Song search(String pArtist, ArrayList<Song> pList) throws Exception
	{
//		Song songFound = null;
		for (Song song: pList) 
		{
			if (song.getArtist().equals(pArtist)) 
			{
				return song;
			}
		}
		throw new Exception("Song not found");
	}

}
