package comp303.corp;

public class StandardInventoryCheck extends InventoryCheckTemplate
{
	@Override
	protected int threshold(Item item)
	{
		return 10;
	}
	
}
