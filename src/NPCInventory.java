
public class NPCInventory {

	Item items[];
	int numItems;
	
	public NPCInventory()
	{
		this.items = new Item[20];
	}
	
	public Item buyItem(int index, int number)
	{
		this.items[index].setQuantity(number);
		return this.items[index];
	}
	
	public int sellItem(Item item, int number)
	{
		return (int)Math.floor((item.getPrice() * number)*.9);
	}
	
	public void displayItems(Item[] items)
	{
		if(this.numItems == 0)
		{
			System.out.println("NPC is sold-out");
		}
		else
		{
			 for(int i = 0; i < items.length; i++)
			 {
				 System.out.println(items[i] + "x" + items[i].getQuantity());
			 }
		}
	}

}
