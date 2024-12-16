package labs.lab4;

public class StandardInventoryCheck extends InventoryCheckTemplate
{
	@Override
	protected int threshold(Item item)
	{
		return 10;
	}
	
}
