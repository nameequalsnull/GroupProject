public class Assassin extends Player
{
   public Assassin()
   {
      super("", "Assassin", 40, 30, .80, .15, .60, 4, 10, 20, 4);
      this.setWeapon(new Dagger());
   }
   
   public void displayStats()
   {
      System.out.println("Class: Assassin");
      System.out.println("Starting HP: 40");
      System.out.println("AP: 30");
      System.out.println("Hit Chance: 80%");
      System.out.println("Defense chance: 15%");
      System.out.println("Crit chance: 60%");
      System.out.println("Strength: 4");
      System.out.println("Unarmed min dam: 10HP");
      System.out.println("Unarmed max dam: 20HP");
      System.out.println("Attack speed: 4");    
   }
}