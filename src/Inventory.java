/**
 * 
 */

/**
 * @author David
 *
 */
public class Inventory 
{
	Item items[] = null;
	
	public Inventory()
	{
		this.items = new Item[20];
		for(int i = 0; i < 20; i++)
			items[i]=null;
	}
	
	public Item getItem(int index)
	{
		return items[index];
	}
	
	public void addItem(Item item, int number)
	{
		int res = inInventory(item);
		if(res >= 0)
		{
			items[res].setQuantity(items[res].getQuantity() + number);
		}
		else if(items.length == 20 && res == -1)
		{
			System.out.println("Inventory is full, cannont add another item");
		}
		else
		{
			for(int i = 0; i < items.length; i++)
			{
				if(items[i] == null)
				{
					items[i] = item;
					items[i].setQuantity(1);
					break;
				}
			}
		}
	}

	public int inInventory(Item item)
	{
		for(int i = 0; i < items.length; i++)
		{
			System.out.println("Debug");
			if(items[i] != null)
			{
				if(items[i].getType() == item.getType())
					return i;
			}
		}
		return -1;
	}
		
	public void removeItem(String name, int number)
	{
		if(number == 0)
			return;
		else
		{
			for(int i = 0; i < items.length; i++)
			{
				if(items[i].getName() == name)
				{
					if(items[i].getQuantity() <= number)
						items[i] = null;
					else
						items[i].setQuantity(items[i].getQuantity() - number);
				}
			}
		}
	}
	
	public void displayItems()
	{
		if(items.length == 0)
		{
			System.out.println("Inventory is empty");
		}
		else
		{
			 for(int i = 0; i < items.length; i++)
			 {
				 if(items[i] != null)
					 System.out.println(items[i] + "x" + items[i].getQuantity());
			 }
		}
	}
	
}
