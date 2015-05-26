
public class Helmet extends Item {

	public Helmet() {
		super("Basic Helmet", "Protects your head from attack", 4, 250);
	}

	@Override
	public int useItem() {
		// Increases defence by some % or amount
		return 0;
	}

}
