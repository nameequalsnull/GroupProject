
public class Potion extends Item {

	public Potion() 
	{
		super("Potion", "Boosts a stat", 1, 350);
	}
	
	public int useItem()
	{
		int tough;
		System.out.println("You take a sip of your Potion, it has a spinachy taste.");
		return 2;
		//tough = GoodGuy.getToughness + 2;
		//Goodguy.setToughness(tough);
	}

}
