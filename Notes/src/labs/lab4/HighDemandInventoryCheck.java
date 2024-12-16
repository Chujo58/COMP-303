package labs.lab4;

public class HighDemandInventoryCheck extends InventoryCheckTemplate
{
	@Override
	protected int threshold(Item item)
	{
		return 20;
	}
}
