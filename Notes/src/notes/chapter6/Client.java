package notes.chapter6;

public class Client
{
	private static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	private static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	private static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 74);
	private static final Comedy CHAVES = new Comedy("Martha Chaves", "Rebel Without a Pause", 82);
	
	public static void main(String[] pArgs) 
	{		
//		CompositeShow innerCompositeShow = new CompositeShow(ALLIGATOR, GIANT_CLAW); 
//		CompositeShow currentCompositeShow = new CompositeShow(CARVE_UP, innerCompositeShow);	
//		System.out.println(currentCompositeShow.time());
		
		CompositeShow doubleBill = new CompositeShow(CARVE_UP, GIANT_CLAW);
		Show show = new IntroducedShow(doubleBill, "Martin", 10);
		System.out.println(show.description());
		
//		Program program = new Program();
//		program.set(Day.FRIDAY, ALLIGATOR);
//		System.out.println(program);
//		
////		Command command = new Program.ClearProgram(program);
//		Command command = program.new ClearProgram(); //You can remove program because we do not have a parameterized constructor anymore.
//	
//		command.execute();
//		System.out.println(program);
//		command.undo();
//		System.out.println(program);
		
		
		ProgramV2 program = new ProgramV2();
		program.set(Day.FRIDAY, ALLIGATOR);
		System.out.println(program);
		
		Command command = program.createClearCommand();
		command.execute();
		System.out.println(program);
		
		command.undo();
		System.out.println(program);
	}
}
