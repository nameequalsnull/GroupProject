public abstract class Party extends GoodGuy
{
   private int armorlvl;
   private Player partyldr;
   public Party()
   {
      super();
      this.armorlvl = 10;
      this.setInventory(new Inventory());
      this.setSuper("PARTY");
   }
   
   public Party(String n, String t, int h, int a, double hc, double dc, double cc, int s, int umin, int umax, int as, int al)
   {
      super(n, t, h, a, hc,dc,cc,s,umin, umax, as);
      setArmorlvl(al);
      this.setInventory(new Inventory());
      this.setSuper("PARTY");
   }
   
   protected void setPartyLeader(Player p)
   {
      if(p != null)
         this.partyldr = p;
      else
         this.partyldr = new NullPlayer();
   }
   
   public Player getPartyLeader()
   {
      return this.partyldr;
   }
   
   public int getArmorlvl()
   {
      return this.armorlvl;
   }
   
   public void setArmorlvl(int h)
   {
      this.armorlvl = (h < 0 || h > 100) ? (h < 0 ? 0 : (h > 100 ? 100 : h)) : h; //learn ternary operators bros
                                                                                 //they make conditional statements so
                                                                                 //much easier  
   }
   
   public abstract void displayStats();
   
   public abstract void applyEffects();
   public abstract void removeEffects();
   
   public void attack(Character opponent)
   {
   
   }
   
   public boolean defend()
   {
      if(this.confirmed(this.getDefChance()))
      {
         if(armorlvl != 0)
            System.out.println(this.getName() + "'s armor stopped the blow!");
         else
            System.out.println(this.getName() + " successfully blocked the attack!");
         return true;
      }
      else
      {
         System.out.println(this.getName() + " was unable to defend against the attack!");
         return false;
      }
   }
}