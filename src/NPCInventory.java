
public class NPCInventory implements I_Inventory
{

	Item items[];
	int numItems;
	
	public NPCInventory()
	{
		this.items = new Item[40];
	}
	
	//returns index of the item in the inventory, or -1 if not found
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
	
	//need to update to involve the money aspect
	public Item getItem(int index, int number)
	{
		Item nItem;
		nItem = this.items[index];
		nItem.setQuantity(number);
		return nItem;
	}
	
	//take the item away from the user, add to store stock for buy back with extra cost
	public int sellItem(Item item, int number)
	{
		addItem(item, number);
		return (int)Math.floor((item.getPrice() * number)*.9);
	}
	
	public void displayItems()
	{
		if(this.numItems == 0)
		{
			System.out.println("NPC is sold-out");
		}
		else
		{
			 for(int i = 0; i < numItems; i++)
			 {
				 System.out.println(items[i].getName() + "x" + items[i].getQuantity());
			 }
		}
	}

	@Override
	public void addItem(Item item, int number) 
	{
		int res = inInventory(item);
		if(res >= 0)
		{
			System.out.println("You have sold " + number + " " + items[res].getName() + " to the NPC");
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
					System.out.println("You have sold " + number + " " + items[i].getName() + " to the NPC");
					numItems++;
					break;
				}
			}
		}
		
	}

}
