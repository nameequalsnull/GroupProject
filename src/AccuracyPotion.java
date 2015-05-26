
public class AccuracyPotion extends Item {

	public AccuracyPotion() {
		super("Accuracy Potion", "Boosts your hit chance", 3, 350);
	}
	
	public int useItem()
	{
		int accuracy;
		System.out.println("You take a sip of your Accuracy Potion, it tastes strange.");
		return 2;
		//accuracy = getAcc() + 2;
		//Character.setAcc(accuracy);
	}

}
