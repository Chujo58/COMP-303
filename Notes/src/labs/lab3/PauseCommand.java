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
		aMusicComponent.pause();
	}

	@Override
	public void undo()
	{
		aMusicComponent.play();
	}

}
