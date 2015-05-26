
public abstract class Character {

	private String name; 
	private Inventory inv;
	private int hp;
    private int accuracy;
    private int tough;
    private int defense;
    private int atkspd;
    private int gold;
    
	public Character() 
	{
		this.name = "man";
		this.inv = new Inventory();
		this.setHp(10);
		this.setAcc(1);
		this.setTough(1);
		this.setDef(1);
		this.setAtkspd(3);
		this.setGold(1);
	}
	
	
	public void setGold(int gold)
	{
		this.gold = gold;
	}
	
	public int getGold()
	{
		return this.gold;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAcc() {
		return accuracy;
	}

	public void setAcc(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getTough() {
		return tough;
	}

	public void setTough(int tough) {
		this.tough = tough;
	}

	public int getDef() {
		return defense;
	}

	public void setDef(int defense) {
		this.defense = defense;
	}

	public int getAtkspd() {
		return atkspd;
	}

	public void setAtkspd(int atkspd) {
		this.atkspd = atkspd;
	}
	
	
	

}
