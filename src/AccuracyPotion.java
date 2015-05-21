
public class AccuracyPotion extends Item {

	public AccuracyPotion() {
		super("Accuracy Potion", "Boosts your hit chance", 3, 350);
	}
	
	public void useAccuracyPotion()
	{
		double accuracy;
		accuracy = GoodGuy.getHitChance + 2;
		Goodguy.setHitChance(accuracy);
	}

}
