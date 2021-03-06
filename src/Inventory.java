/**
 * @author David
 *
 */
public class Inventory implements I_Inventory
{
	Item items[] = null;
	int numItems = 0;
	
	public Inventory()
	{
		this.items = new Item[20];
		this.numItems = 0;
		for(int i = 0; i < 20; i++)
			items[i]=null;
		items[0] = new Food();
		items[0].setQuantity(10);
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
			System.out.println("You added " + number + " " + items[res].getName() + " to your inventory");
			items[res].setQuantity(items[res].getQuantity() + number);
		}
		else if(numItems == 20 && res == -1)
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
					items[i].setQuantity(number);
					System.out.println("You added " + number + " " + items[i].getName() + " to your inventory");
					break;
				}
			}
		}
	}

	public int inInventory(Item item)
	{
		for(int i = 0; i < items.length; i++)
		{
			if(items[i] != null)
			{
				if(items[i].getType() == item.getType())
					return i;
			}
		}
		return -1;
	}
	
	public void useItem(int index)
	{
		if(index < 0)
			return;
		else
		{
			for(int i = 0; i < items.length; i++)
			{
				if(i == index)
				{
					//if(items[i].getQuantity() <= 0)
					//	items[i] = null;
					//else
					//{
						//System.out.println("item used" + " " + items[i].getName());
						items[i].useItem();
						items[i].setQuantity(items[i].getQuantity() - 1);
						if(items[i].getQuantity() == 0)
							items[i] = null;
					//}
				}
			}
		}
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
					break;
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
			 System.out.println("----Your Inventory----");
			 for(int i = 0; i < items.length; i++)
			 {
				 if(items[i] != null)
					 System.out.println(i + ") " + items[i].getName() + "x" + items[i].getQuantity());
			 }
			 System.out.println();
		}
	}
	
//	public void lootItems(Character player, Character enemy)
//	{
//		if(enemy.hasItems() == true)
//		{
//			for(enemy.ite)
//		}
//	}
//	
}
