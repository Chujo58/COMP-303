package labs.lab3; 

public class PauseCommand implements Command
{
	private final MusicComponent aMusicComponent;
	
	public PauseCommand(MusicComponent pMusicComponent) {
		assert pMusicComponent != null;
		aMusicComponent = pMusicComponent;
	}
	
	@Override
	public void execute()
	{
		// TODO Auto-generated method stub
		aMusicComponent.pause();
	}

	@Override
	public void undo()
	{
		// TODO Auto-generated method stub
		aMusicComponent.play();
	}

}
