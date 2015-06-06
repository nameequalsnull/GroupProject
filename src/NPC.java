import java.util.*;
public abstract class NPC extends Character
{
   public NPC()
   {
      super();
      this.setSuper("NPC");
      this.setInventory(new Inventory());
   }
   
   public NPC(int h, double dc, int umin, int umax, String n, String t)
   {
      super(h, dc, umin, umax, n, t);
      this.setSuper("NPC");
      this.setInventory(new Inventory());
   }
   
   public void displayInfo()
   {
      System.out.println("NAME: " + this.getName());
      System.out.println("HEALTH: " + this.getHP());
      System.out.println("CLASS: " + this.getType());
   }
   
   public boolean defend()
   {
      if(this.confirmed(this.getDefChance()))
      {
         System.out.println(this.getName() + " was able to successfully dodge the attack!");
         return true;
      }
      else
      {
         System.out.println(this.getName() + " was unable to dodge the attack!");
         return false;
      }
   }
   
   public void fightBack(Character c)
   {
      Random rng = new Random();
      
      int dam;
      int ohp = c.getHP();
      if(this.confirmed(this.getDefChance()))
      {
         dam = rng.nextInt(this.getUmax() - this.getUmin()) + this.getUmin();
         this.getCommunicator().applyDamage(c, dam);
         System.out.println(this.getName() + " landed a blow on " + c.getName());
         if(!c.isDead())
         {
            System.out.println(c.getName() + " is still standing! That bastard!");
         }
         else
         {
            System.out.println(this.getName() + " punched " + c.getName() + " to death!");
            if(c.hasItems())
               this.takeItems(c);
            this.takeGold(c);
         }
      }
      else
         System.out.println(this.getName() + " failed to land a successful blow on " + c.getName());   
   }
   
   //public abstract void behavior(Character c);
}