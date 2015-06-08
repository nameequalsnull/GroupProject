import java.util.*;
public class StoreNPC {

	
	String name;
	String description;
	NPCInventory npcinv;
	int gold;
	Scanner kb = new Scanner(System.in);
	
	public StoreNPC() 
	{
		this.name = "Olivia";
		this.description = "Here to help you out!";
		this.gold = 1000;
		this.npcinv=new NPCInventory();
	}
	public void interact(Character player) 
	{
		System.out.println("Hello, my name is " + this.name + ", what can I do for you?");
		int choice;
		do{
			System.out.println("1) View " + this.name + "'s inventory");
			System.out.println("2) Buy an item");
			System.out.println("3) Sell an item");
			System.out.println("0) Nevermind");
			choice = kb.nextInt();
			while(choice < 0 || choice > 3)
			{
				System.out.println("Invalid choice, try again");
				choice = kb.nextInt();
			}
			
			if(choice == 1)
			{
				npcinv.displayItems();
			}
			else if (choice == 2)
			{
				buyMenu(player);
			}
			else if(choice == 3)
			{
				sellMenu(player);
			}
			else
				return;
		System.out.println();
		}while(choice != 0);
	}
	private void sellMenu(Character player) 
	{
		System.out.println("Here are the items you have: ");
		player.getInventory().displayItems();
		System.out.println("Which item would you like to sell? (-1 to sell nothing)");
		int choice = kb.nextInt();
		if(choice == -1)
		{
			System.out.println("Leaving sell");
			return;
		}
		Item item = player.getInventory().getItem(choice);
		System.out.println("How many would you like to sell?");
		int maxamt = player.getInventory().getItem(choice).getQuantity();
		System.out.println("The amount of "+ item.getName() + " you have is " + maxamt);
		int amt = kb.nextInt();
		if (amt > maxamt)
			amt = maxamt;
		else if(amt < 0)
			amt = 0;
		player.getInventory().removeItem(item.getName(), amt);
		int gold = npcinv.sellItem(item, amt);
		gold = gold + player.getGold();
		player.setGold(gold);
		this.gold = this.gold - gold;
		System.out.println("You have sold " + amt + " of your " + item.getName() + " to " + this.name);
		System.out.println("You now have " + item.getQuantity() + " " + item.getName() + " and " + player.getGold() + " gold");
	}
	
	private void buyMenu(Character player) 
	{
		System.out.println("Here are the items " + this.name + " has: ");
		npcinv.displayItems();
		System.out.println("Which item would you like to buy? (-1 to sell nothing)");
		int choice = kb.nextInt();
		if(choice == -1)
		{
			System.out.println("Leaving buy");
			return;
		}
		Item item = npcinv.getItem(choice, 1);
		System.out.println("You have " + player.getGold() + " gold");
		System.out.println("This item costs" + item.getPrice() + " gold per");
		System.out.println("How many would you like to buy?");
		int amt = kb.nextInt();
		int maxamt = 0;
		if(amt > 0)
			maxamt = (int) Math.floor((player.getGold()/(item.getPrice()*amt)));
		//System.out.println("The amount of "+ item.getName() + " you have is " + maxamt);
		if (amt > maxamt)
			amt = maxamt;
		item = npcinv.getItem(choice, amt);
		int cost = (item.getPrice() * amt);
		//player.getInventory().removeItem(item.getName(), amt);
		int gold = player.getGold();
		gold = gold - cost;
		player.setGold(gold);
		this.gold = this.gold + gold;
		player.getInventory().addItem(item, amt);
		System.out.println("You have sold " + amt + " of your " + item.getName() + " to " + this.name + " for " + cost + " gold");
		System.out.println("You now have " + player.getGold() + " gold");
	}

}
