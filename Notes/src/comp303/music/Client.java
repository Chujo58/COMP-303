package comp303.music;

import java.util.ArrayList;

public class Client
{
	private static final Song song1 = new Song("Title1","Artist1");
	private static final Song song2 = new Song("Title2","Artist1");
	private static final Song song3 = new Song("Title3","Artist2");
	private static final Song song4 = new Song("Title4","Artist3");
	
	
	public static void main(String[] args)
	{
		ArrayList<MusicComponent> temp = new ArrayList<>();
		temp.add(song1);
		temp.add(song2);
//		temp.add(song3);
//		temp.add(song4);
		
		ArrayList<MusicComponent> temp2 = new ArrayList<MusicComponent>();
		temp2.add(song3);
		temp2.add(song4);
		
		Library inner = new Library(temp2);
		
		temp.add(inner);
		
		Library lib = new Library(temp);
		
		System.out.println("Playing a song: ");
		song1.play();
		System.out.println("Playing a library: ");
		lib.play();
		
		try
		{
			lib.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
