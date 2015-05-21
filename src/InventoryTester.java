
public class InventoryTester {

	public static void main(String[] args) 
	{
		Inventory myinv = new Inventory();
		NPCInventory npcinv = new NPCInventory();
		
		
		
		myinv.addItem(new Food(), 1);
		myinv.addItem(new AccuracyPotion(), 234);
		myinv.displayItems();
		myinv.addItem(new ToughnessPotion(), 20);
		myinv.useItem(0);
		myinv.useItem(1);
		myinv.useItem(2);
		myinv.displayItems();

	}

}
