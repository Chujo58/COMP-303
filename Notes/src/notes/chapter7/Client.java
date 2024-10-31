package notes.chapter7;

public class Client
{
	private static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	private static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	private static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 74);
	private static final Comedy CHAVES = new Comedy("Martha Chaves", "Rebel Without a Pause", 82);
	private static final SponsoredComedy SPONSORED = new SponsoredComedy("McGill", 5, "Martha Chaves", "Rebel Without a Pause", 82);
	
	public static void main(String[] pArgs) 
	{		
		//We want to create a sponsored comedy where we need to change both the description and time. 
		//We want to be able to interchange it with the "normal" comedy.
		//We could make a decorator. Create a copy of the class (which is a terrible idea)
		
		
		//First problem we run into:
//		SponsoredComedy comedy = new SponsoredComedy(CHAVES, "McGill", 5);
//		Comedy comedy2 = comedy; // We can't interchange a sponsored comedy and a comedy.
		
		//Second problem we run into is getting the title of the inner comedy for the description?
		
		//How to fix, use inheritance.
//		SponsoredComedy comedy = new SponsoredComedy("McGill", 5, "Martha Chaves", "Rebel Without a Pause", 82);
//		System.out.println(comedy.description());
		
		
		//Check which .setTitle get called:
//		String title = "We're gonna rire";
//		Day day = Day.FRIDAY;
//		Object object = new NullPointerException("Laught, don't cry");
//		
//		CHAVES.setTitle(day);
		Comedy comedy = SPONSORED;
		Comedy copy = comedy.copy();
		System.out.println(copy);

		Show show = new CompositeShow(CARVE_UP, CHAVES);
		Show copy2 = show.copy();
		System.out.println(copy2);
	}
}
