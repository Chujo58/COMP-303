package comp303.corp;

public class InventoryStockObserver implements Observer
{
	private final Inventory aInventory;
	private final InventoryCheckTemplate aCheck;
	
	public InventoryStockObserver(Inventory pInventory, InventoryCheckTemplate pCheck) {
		assert pInventory != null && pCheck != null;
		aInventory = pInventory;
		aCheck = pCheck;
	}
	
	@Override
	public void notify(Item item)
	{
		if (aInventory.checkInventory(item, aCheck)) {
			System.out.println("Item " + item.getName() + " is low on stock.");
		}
	}

}
