package notes.chapter6;

public class Client
{
	private static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	private static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	private static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 74);
	private static final Comedy CHAVES = new Comedy("Martha Chaves", "Rebel Without a Pause", 82);
	
	public static void main(String[] pArgs) 
	{		
		CompositeShow innerCompositeShow = new CompositeShow(ALLIGATOR, GIANT_CLAW); 
		CompositeShow currentCompositeShow = new CompositeShow(CARVE_UP, innerCompositeShow);	
		System.out.println(currentCompositeShow.time());
	}
}
