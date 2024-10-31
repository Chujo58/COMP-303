package comp303.music;

public abstract class MusicComponent implements Cloneable
{
	public abstract void play();
	
	public void pause() {
		System.out.println("Paused");
	}
	
	public MusicComponent clone() throws CloneNotSupportedException 
	{
		return (MusicComponent) super.clone();
	}
}