public class Ghost extends BadGuy
{
   public Ghost()
   {
      super(25, .80, .05, .10, .40, 1, 2, 5, 15, 2, 0, false, "Ethereal \"jelly\"", "Gropy the Ghost", "Ghost");
   }
   
   public void displayStats()
   {
      System.out.println("Class: Ghost");
      System.out.println("Name: Gropy the Ghost");
      System.out.println("Starting HP: 25");
      System.out.println("Hit Chance: 40%");
      System.out.println("Defense chance: 80%");
      System.out.println("Special chance: 5%");
      System.out.println("Rage chance: 10%");
      System.out.println("Unarmed min dam: 2HP");
      System.out.println("Unarmed max dam: 5HP");
      System.out.println("Armed min dam: 5HP");
      System.out.println("Armed max dam: 15HP");
      System.out.println("Pain tolerance lvl: 2");
      System.out.println("Armor lvl: 0");
   }
}