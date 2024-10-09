package labs.lab1;

/**
 * Represents an audio file and its meta-data.
 */
public class Song
{
	@SuppressWarnings("unused")
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
	 * Sets the title of the song.
	 * @pre Checks if title is not empty or null
	 * */
	public void setTitle(String pTitle) 
	{
		assert pTitle != null || pTitle.length() == 0;
		aName = pTitle;
	}
	
	
	/**
	 * Sets the artist for the song.
	 * */
	public void setArtist(String pArtist) 
	{
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
	
	
}
