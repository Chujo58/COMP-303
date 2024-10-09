package comp303.music;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Playlist class.
 * */
public class Playlist implements Iterable<Song>
{
	private ArrayList<Song> aSongs;
	/**
	 * Creates a Playlist object.
	 * */
	public Playlist(ArrayList<Song> pSongs)
	{
		aSongs = new ArrayList<Song>(pSongs);
	}
	
	/**
	 * Prints out song.
	 * */
	private void printSong(Song pSong) 
	{
		System.out.println("Playing " + pSong.getTitle() + " by " + pSong.getArtist());
	}
	
	/**
	 * Plays all songs in playlist.
	 * */
	public void playAllSongs() 
	{
		for (Song song: this)
		{
			printSong(song);
		}
	}
	
	/**
	 * Play single song given a title.
	 * */
	public void playSongByTitle(String pTitle)
	{
		SearchByTitle searchMethod = new SearchByTitle();
		try
		{
			Song toPlay = searchMethod.search(pTitle, aSongs);
			printSong(toPlay);
		}
		catch (Exception e)
		{
			System.out.println("Couldn't play selected title");
		}
	}
	
	/**
	 * Play single song given an artist.
	 * */
	public void playSongByArtist(String pArtist)
	{
		SearchByArtist searchMethod = new SearchByArtist();
		try
		{
			Song toPlay = searchMethod.search(pArtist, aSongs);
			printSong(toPlay);
		}
		catch (Exception e)
		{
			System.out.println("Couldn't play selected artist");
		}
	}

	@Override
	public Iterator<Song> iterator()
	{
		return aSongs.iterator();
	}
}
