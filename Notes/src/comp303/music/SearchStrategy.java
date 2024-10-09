package comp303.music;

import java.util.ArrayList;

/**
 * Search interface.
 * */
public interface SearchStrategy
{
	/**
	 * Searches for a song.
	 * @throws Exception if song not found
	 * */
	Song search(String pInfo, ArrayList<Song> pList) throws Exception;
}
