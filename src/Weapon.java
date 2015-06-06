
public abstract class Weapon extends Item {

	int dmin;
	int dmax;
	public Weapon() 
	{
		super("Basic Weapon", "Useful for attacking", 4, 350);
	    this.dmin = 10;
	    this.dmax = 30;
	}

    public Weapon(int c, int tv, String ty, String n, int dmin, int dmax)
    {
	    super(n, ty, c, tv);
	    this.dmin = dmin < 5 ? 5 : (dmin > 70 ? 70 : dmin);
	    this.dmax = dmax < 5 ? 5 : (dmax > 70 ? 70 : dmax);
	 }
	
	
	@Override
	public int useItem() 
	{
		//attack bonuses
		return 0;
	}

	 public int getDmin(){return this.dmin;}
	 public int getDmax(){return this.dmax;}
	 public void setDmin(int d){this.dmin = d;}
	 public void setDmax(int d){this.dmax = d;}
}
