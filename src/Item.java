
public abstract class Item {
	private String name;
	private String description;
	private int price;
	private int type;
	private int quantity = 0;
	
	public Item(String name, String desc, int type, int price)
	{
		this.name = name;
		this.description = desc;
		this.type = type;
		this.price = price;
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
