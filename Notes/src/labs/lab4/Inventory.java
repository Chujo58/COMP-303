package labs.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents the inventory of a 
 * physical grocery store.
 */
public class Inventory implements Iterable<Item>
{
	private final String aName; // Unique
	private final Map<Item, Integer> aInventory = new HashMap<>();
	private List<Observer> aObservers = new ArrayList<Observer>();
	
	/**
	 * Creates a new inventory with no items in it,
	 * and identified uniquely with pName.
	 * @param pName A unique identifier for this inventory.
	 */
	public Inventory(String pName)
	{
		aName = pName;
	}
	
	/**
	 * @return The unique name of this inventory.
	 */
	public String getName()
	{
		return aName;
	}
	
	/**
	 * Adds pQuantity number of items to the inventory.
	 * @param pItem The type of item to add.
	 * @param pQuantity The amount to add.
	 */
	public void stock(Item pItem, int pQuantity)
	{
		int amount = 0;
		if( aInventory.containsKey(pItem))
		{
			amount = aInventory.get(pItem);
		}
		amount += pQuantity;
		aInventory.put(pItem, amount);
	}
	
	/**
	 * Removes pQuantity of items from the inventory.
	 * @param pItem The type of item to dispose of
	 * @param pQuantity The amount to dispose.
	 * @pre aInventory.containsKey(pItem) && pQuantity <= available(pItem)
	 */
	public void dispose(Item pItem, int pQuantity)
	{
		int amount = aInventory.get(pItem);
		amount -= pQuantity;
		aInventory.put(pItem, amount);
		
		for (Observer observer: aObservers) 
		{
			observer.notify(pItem);
		}
	}
	
	/**
	 * @param pItem The item to check for availability.
	 * @return How many of the items are available in the inventory.
	 */
	public int available(Item pItem)
	{
		if( aInventory.containsKey(pItem))
		{
			return aInventory.get(pItem);
		}
		else
		{
			return 0;
		}
	}

	@Override
	public Iterator<Item> iterator()
	{
		return aInventory.keySet().iterator();
	}
	
	/**
	 * Add method to check inventory.
	 * */
	public boolean checkInventory(Item item, InventoryCheckTemplate check) {
		return check.needRestock(this, item);
	}
	
	/**
	 * Observers methods down here
	 * */
	
	public void addObserver(Observer pObserver) {
		aObservers.add(pObserver);
	}
	
	public void removeObserver(Observer pObserver) {
		aObservers.remove(pObserver);
	}
	
	
}