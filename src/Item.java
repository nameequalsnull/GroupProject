
public abstract class Item {
	private String name;
	private String description;
	private int price;
	private int type;
	private int quantity = 0;
	private int cn;
	public Item(String name, String desc, int cn, int price)
	{
		this.name = name;
		this.description = desc;
		this.cn = cn;
		this.price = price;
	}
	
	public int getConditionNumeric()
	{
		return this.cn;
	}	
	
	public void changeCondition(int c)
	{
		this.cn = c;
	}
	
	public abstract int useItem();
	
	public String getName() {
		return this.name;
	}

	public String getDesc() {
		return this.description;
	}
	
	public int getType() {
		return this.type;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(int newquantity) {
		this.quantity = newquantity;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
}
