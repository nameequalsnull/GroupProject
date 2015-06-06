import java.util.*;
public abstract class BadGuy extends Character
{
   private int dmin, dmax;
   private double schance, rchance, hchance;
   private int ptol, armorlvl;
   private boolean armored;
   private boolean armed;
   private String weapon;
   
   public BadGuy()
   {
      super();
      this.dmin = 10;
      this.dmax = 30;
      this.schance = .20;
      this.rchance = .10;
      this.hchance = .40;
      this.ptol = 5;
      this.armorlvl = 0;
      this.armored = false;
      this.armed = false;
      this.weapon = "MY MOTHERFUCKING FISTS";
      this.setSuper("BADGUY");
      this.setInventory(new Inventory());
   }
   
   public boolean isArmored(){return this.armored;}
   public int getArmorlvl(){return this.armorlvl;}
   public String getWeapon(){return this.weapon;}
   public void setArmorlvl(int dam)
   {
      if(dam <= 0)
      {
         this.armorlvl = 0;
         this.armored = false;   
      }
      else
         this.armorlvl = dam;  
   }
   
   public BadGuy(int h, double dc, int umin, int umax, String n, String t, int dmin, int dmax)
   {
      super(h, dc, umin, umax, n, t);
      this.dmin = dmin;
      this.dmax = dmax;
      this.schance = .20;
      this.rchance = .10;
      this.hchance = .40;
      this.ptol = 5;
      this.armorlvl = 0;
      this.armored = false;
      this.armed = false;
      this.weapon = "MY MOTHERFUCKING FISTS";
      this.setSuper("BADGUY");
      this.setInventory(new Inventory());
   }
   
   public BadGuy(int h, double dc, double sc, double rc, double hc, int umin, int umax, int dmin, int dmax, int ptol, int alvl, boolean armd, String w, String n, String t)
   {
      super(h, dc, umin, umax, n, t);
      this.dmin = dmin;
      this.dmax = dmax;
      this.schance = sc;
      this.rchance = rc;
      this.hchance = hc;
      this.ptol = ptol;
      this.armorlvl = alvl;
      this.armored = !(this.armorlvl <= 0);
      this.armed = armd;
      this.weapon = w == null ? "Unarmed" : w;
      this.armed = weapon.equals("Unarmed") ? false : true;
      this.setSuper("BADGUY");
      this.setInventory(new Inventory());
   } 
   
   protected void setSpecChance(double chc)
   {
      if(chc < 0)
      {
         this.schance = chc * -1.0;
         if(this.schance - .50 >= 0.000000001)
            this.schance = .50;
      }
      else if(chc - .50 >= 0.000000001)
         this.schance = .50;
      else
         this.schance = chc;
   }
   
   protected void setRageChance(double chc)
   {
      if(chc < 0)
      {
         this.schance = chc * -1.0;
         if(this.schance - .40 >= 0.000000001)
            this.schance = .40;
      }
      else if(chc - .40 >= 0.000000001)
         this.schance = .40;
      else
         this.schance = chc;
   }
   
   protected void setPainTolerance(int p)
   {
      if(p < 0)
         this.ptol = 1;
      else if(p > 30)
         this.ptol = 30;
      else
         this.ptol = p;
   }
   
   public boolean defend()
   {
      if(this.confirmed(this.getDefChance()))
      {
         if(armored && armorlvl > 0)
            System.out.println(this.getName() + " armor stopped the blow!");
         else
            System.out.println(this.getName() + " was able to dodge the attack!");
         return true;
      }
      else
      {
         System.out.println(this.getName() + " was unable to defeat the attack!");
         return false;
      }
   }
   
   public void rage() //rage for enemies is essentially healing some amount of HP, default is 5
   {                  //successfulness is determined by rchance (rage chance)
      if(this.confirmed(this.rchance))
      {
         Random rng = new Random();
         int tolerated = rng.nextInt(this.ptol + 1);
         this.setHP(this.getHP() + tolerated);
         System.out.println(this.getName() + " raged and tolerated some of the pain!");
      }
      else
         System.out.println(this.getName() + " couldn't tolerate the pain!");
   }
   
   public void attack(Character c)
   {
      if(this.confirmed(this.hchance))
      {
         Random rng = new Random();
         int dam;
         //int ohp = c.getHP();
         if(this.armed)
         {
            dam = rng.nextInt((this.dmax - this.dmin) + 1) + this.dmin;
            this.getCommunicator().applyDamage(c, dam);
         }
         else
         {
            dam = rng.nextInt((this.getUmax() - this.getUmin()) + 1) + this.getUmin();
            this.getCommunicator().applyDamage(c, dam);   
         }
         if(c.isDead())
         {
            System.out.println(this.getName() + " killed " + c.getName() + " with " + this.getWeapon());
            if(c.hasItems())
               this.takeItems(c);
            this.takeGold(c);
         }
         else
            System.out.println(this.getName() + " failed to kill " + c.getName());  
      }
      else
         System.out.println(this.getName() + " was unable to land a blow on " + c.getName());
   }
   public void displayInfo()
   {
      System.out.println("NAME: " + this.getName());
      System.out.println("HEALTH: " + this.getHP());
      System.out.println("WEAPON: " + this.getWeapon());
   }
}