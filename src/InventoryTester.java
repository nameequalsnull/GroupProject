
public class InventoryTester {

	public static void main(String[] args) 
	{
		Inventory myinv = new Inventory();
		NPCInventory npcinv = new NPCInventory();
		npcinv.addItem(new Food(), 1000);
				
		myinv.addItem(new Food(), 20);
		myinv.addItem(new AccuracyPotion(), 234);
		myinv.displayItems();
		myinv.addItem(new ToughnessPotion(), 20);
		myinv.useItem(0);
		myinv.useItem(1);
		myinv.useItem(2);
		myinv.displayItems();
		System.out.println();
		myinv.addItem(npcinv.getItem(0, 500), 500);//buy item from shop, need to involve money
		myinv.displayItems();
		System.out.println();
		System.out.println("selling");
		//selling 500 food to shop
		int ret = npcinv.sellItem(npcinv.getItem(0, 1), 500);
		System.out.println("selling1");
		myinv.removeItem("Food", 500);
		System.out.println("selling2");
		myinv.displayItems();
		npcinv.displayItems();
		System.out.println();
		
	}

}
