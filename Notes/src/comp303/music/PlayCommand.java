package comp303.music;

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
		// TODO Auto-generated method stub
		aMusicComponent.play();
	}

	@Override
	public void undo()
	{
		// TODO Auto-generated method stub
		aMusicComponent.pause();
	}
	
}
