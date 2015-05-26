
public class Weapon extends Item {

	public Weapon() 
	{
		super("Basic Weapon", "Useful for attacking", 4, 350);
	}

	@Override
	public int useItem() 
	{
		//attack bonuses
		return 0;
	}

	
}
