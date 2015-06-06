public class Troll extends BadGuy
{
   public Troll()
   {
      super(80, .30, .05, .15, .55, 20, 40, 25, 50, 20, 45, true, "Extremely Large Blunt Object, like a very large sledgehammer or his gigantic *ahem* \"member\"", "Bob The Barbarous", "Troll");
   }
   
   public void displayStats()
   {
      System.out.println("Class: Troll");
      System.out.println("Name: Bob the Barbarous");
      System.out.println("Starting HP: 80");
      System.out.println("Hit Chance: 55%");
      System.out.println("Defense chance: 30%");
      System.out.println("Special chance: 5%");
      System.out.println("Rage chance: 15%");
      System.out.println("Unarmed min dam: 20HP");
      System.out.println("Unarmed max dam: 40HP");
      System.out.println("Armed min dam: 25HP");
      System.out.println("Armed max dam: 50HP");
      System.out.println("Pain tolerance lvl: 20");
      System.out.println("Armor lvl: 45");
   }
   
   
}