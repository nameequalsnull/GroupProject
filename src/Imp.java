public class Imp extends BadGuy
{
   public Imp()
   {
      super(10, .30, .03, .70, .58, 3, 7, 10, 35, 10, 0, false, "Rock Dagger", "Implicative Imp", "Imp");
   }
   
   public void displayStats()
   {
      System.out.println("Class: Imp");
      System.out.println("Name: Implicative Imp");
      System.out.println("Starting HP: 10");
      System.out.println("Hit Chance: 58%");
      System.out.println("Defense chance: 30%");
      System.out.println("Special chance: 3%");
      System.out.println("Rage chance: 70%");
      System.out.println("Unarmed min dam: 3HP");
      System.out.println("Unarmed max dam: 7HP");
      System.out.println("Armed min dam: 10HP");
      System.out.println("Armed max dam: 35HP");
      System.out.println("Pain tolerance lvl: 10");
      System.out.println("Armor lvl: 0");
   }
}