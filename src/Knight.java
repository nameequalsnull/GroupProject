public class Knight extends Player
{
   public Knight()
   {
      super("", "Knight", 75, 30, .65, .50, .30, 10, 10, 25, 5);
      this.setWeapon(new LongSword());
   }
   
   public void displayStats()
   {
      System.out.println("Class: Knight");
      System.out.println("Starting HP: 75");
      System.out.println("AP: 30");
      System.out.println("Hit Chance: 65%");
      System.out.println("Defense chance: 50%");
      System.out.println("Crit chance: 30%");
      System.out.println("Strength: 10");
      System.out.println("Unarmed min dam: 10HP");
      System.out.println("Unarmed max dam: 25HP");
      System.out.println("Attack speed: 5");    
   }
}