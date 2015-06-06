public class Mage extends Player
{
   public Mage()
   {
      super("", "Mage", 50, 20, .75, .30, .40, 5, 3, 15, 7);
      this.setWeapon(new FireBall());
   }
   
   public void displayStats()
   {
      System.out.println("Class: Mage");
      System.out.println("Starting HP: 50");
      System.out.println("AP: 20");
      System.out.println("Hit Chance: 75%");
      System.out.println("Defense chance: 30%");
      System.out.println("Crit chance: 40%");
      System.out.println("Strength: 5");
      System.out.println("Unarmed min dam: 3HP");
      System.out.println("Unarmed max dam: 15HP");
      System.out.println("Attack speed: 7");    
   }
}