
public class Food extends Item {

	private int healamt;
	
	public Food() {
		super("Food", "Heals you", 2, 350);
		// TODO Auto-generated constructor stub
	}
	
	public int useItem()
	{//returns the amount of hp you wish the food to heal
		System.out.println("You eat some food, it's decent");
		return 1; 
	}

}
