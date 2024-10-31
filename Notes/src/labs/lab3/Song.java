package labs.lab3;

/**
 * Represents an audio file and its meta-data.
 */
public class Song extends MusicComponent
{
	private String aName;
	private String aArtist;
	@SuppressWarnings("unused")
	private AudioFormat aFormat;
	@SuppressWarnings("unused")
	private int aBpm;
	@SuppressWarnings("unused")
	private Genre aGenre;
	

	/**
	 * Creates Song object.
	 * */
	public Song(String pTitle, String pArtist)
	{
		this.setTitle(pTitle);
		this.setArtist(pArtist);
	}
	
	/**
	 * Copy constructor.
	 * */
	public Song(Song pSong) 
	{
		this(pSong.getTitle(), pSong.getArtist());
	}
	
	/**
	 * Creates a copy.
	 * */
	public Song copy(Song pSong) 
	{
		return new Song(pSong.getTitle(), pSong.getArtist());
	}
	
	public Song clone() {
		return new Song(this);
	}
	
	/**
	 * Sets the title of the song.
	 * @pre Checks if title is not empty or null
	 * */
	public void setTitle(String pTitle) 
	{
		assert pTitle != null || pTitle.length() != 0;
		aName = pTitle;
	}
	
	
	/**
	 * Sets the artist for the song.
	 * */
	public void setArtist(String pArtist) 
	{
		assert pArtist != null || pArtist.length() != 0;
		aArtist = pArtist;
	}
	
	/**
	 * Gets title of song.
	 * */
	public String getTitle() 
	{
		return aName;
	}
	
	/**
	 * Gets artist of song.
	 * */
	public String getArtist() 
	{
		return aArtist;
	}
	
//	/**
//	 * Prints out song.
//	 * */
//	private void printSong(Song pSong) 
//	{
//		System.out.println("Playing " + pSong.getTitle() + " by " + pSong.getArtist());
//	}

	@Override
	public void play()
	{
		// TODO Auto-generated method stub
		System.out.println("Playing " + getTitle() + " by " + getArtist());
	}
}
