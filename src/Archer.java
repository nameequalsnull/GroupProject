public class Archer extends Player
{
   public Archer()
   {
      super("", "Archer", 60, 25, .70, .20, .50, 4, 2, 11, 6);
      this.setWeapon(new Longbow());
   }
   
   public void displayStats()
   {
      System.out.println("Class: Archer");
      System.out.println("Starting HP: 60");
      System.out.println("AP: 25");
      System.out.println("Hit Chance:70%");
      System.out.println("Defense chance: 20%");
      System.out.println("Crit chance: 50%");
      System.out.println("Strength: 4");
      System.out.println("Unarmed min dam: 1HP");
      System.out.println("Unarmed max dam: 11HP");
      System.out.println("Attack speed: 6");    
   }
}