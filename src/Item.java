
public abstract class Item {

	private String name;
	private String description;
	private int type;
	
	public Item(String name, String desc, int type)
	{
		this.name = name;
		this.description = desc;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}

	public String getDesc() {
		return this.description;
	}
	
	public int getType() {
		return this.type;
	}
	
}
