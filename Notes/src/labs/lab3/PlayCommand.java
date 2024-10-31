package labs.lab3; 

public class PlayCommand implements Command
{
	private final MusicComponent aMusicComponent;
	
	public PlayCommand(MusicComponent pMusicComponent) {
		assert pMusicComponent != null;
		aMusicComponent = pMusicComponent;
	}
	
	@Override
	public void execute()
	{
		aMusicComponent.play();
	}

	@Override
	public void undo()
	{
		aMusicComponent.pause();
	}
	
}
