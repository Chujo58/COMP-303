package comp303.corp;

public abstract class InventoryCheckTemplate
{
	public final boolean needRestock(Inventory inv, Item item) {
		int currentStock = inv.available(item);
		int minimumStock = threshold(item);
		if (currentStock != 0) {
			return currentStock < minimumStock;
		}
		return true; //If item not in inventory, then you need to restock.
	}
	
	protected abstract int threshold(Item item);
}
