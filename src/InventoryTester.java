
public class InventoryTester {

	public static void main(String[] args) 
	{
		Inventory myinv = new Inventory();
		System.out.println(myinv.items.length);
		myinv.addItem(new Food(), 1);
		myinv.displayItems();

	}

}
