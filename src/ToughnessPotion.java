
public class ToughnessPotion extends Item {

	public ToughnessPotion() 
	{
		super("Toughness Potion", "Boosts your toughness", 1, 350);
	}
	
	public int useToughnessPotion()
	{
		int tough;
		tough = GoodGuy.getToughness + 2;
		Goodguy.setToughness(tough);
	}
}