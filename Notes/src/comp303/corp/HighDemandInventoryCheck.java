package comp303.corp;

public class HighDemandInventoryCheck extends InventoryCheckTemplate
{
	@Override
	protected int threshold(Item item)
	{
		return 20;
	}
}
