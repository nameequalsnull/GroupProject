
public class TestCharacter extends Character {

	public TestCharacter() 
	{
		super();
	}
	
	public static void main(String[] args)
	{
		Map map = new Map();
		Character hero = new TestCharacter();
		
		int gold = hero.getGold();
		
		System.out.println(gold);
	}
}


