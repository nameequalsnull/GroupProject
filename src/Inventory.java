/**
 * 
 */

/**
 * @author David
 *
 */
public class Inventory 
{
	Item items[] = new Item[20];
	
	public Item getItem(int index)
	{
		return items[index];
	}
	
	public void addItem(Item item)
	{
		if(items.length == 20)
			System.out.println("inventory is full");
		else
		{
			for(int i = 0; i < items.length; i++)
			{
				if(items[i] != null)
					items[i] = item; 
			}
		}	
	}
	
	public void sortItem()
	{
		
	}
	
	public void displayItems()
	{
		
	}
	
}
