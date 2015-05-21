
public class ToughnessPotion extends Item {

	public ToughnessPotion() 
	{
		super("Toughness Potion", "Boosts your toughness", 1, 350);
	}
	
	public int useItem()
	{
		int tough;
		System.out.println("You take a sip of your Toughness Potion, it has a spinachy taste.");
		return 2;
		//tough = GoodGuy.getToughness + 2;
		//Goodguy.setToughness(tough);
	}
}