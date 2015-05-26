
public class BodyArmor extends Item {

	public BodyArmor() {
		super("Body Armor", "basic body protection", 4, 450);
	}

	@Override
	public int useItem() {
		// further buffs defence + gives some offensive bonus possible
		return 0;
	}

}
