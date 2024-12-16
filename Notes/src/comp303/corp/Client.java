package comp303.corp;

public class Client
{

	public static void main(String[] args)
	{
		Inventory inv = new Inventory("Test");
		Item item = new Item("testing item",1,20);
		Item item2 = new Item("second item",2,20);
		inv.stock(item, 15);
		inv.stock(item2, 25);
		
		StandardInventoryCheck check = new StandardInventoryCheck();
		System.out.println(inv.checkInventory(item2, check));
		
		InventoryStockObserver obs = new InventoryStockObserver(inv, check);
		inv.addObserver(obs);
		inv.dispose(item, 10);
		inv.dispose(item2, 20);
	}
}
