public class Merchant extends NPC
{
   public Merchant()
   {
      super(50, .35, 5, 15, "Mr. Krabbs", "Merchant");
   }
   
   public void displayStats()
   {
      System.out.println("Name: Mr. Krabbs");
      System.out.println("Class: Merchant");
      System.out.println("Starting HP: 50");
      System.out.println("Defense chance: 35%");
      System.out.println("Unarmed min dam: 5");
      System.out.println("Unarmed max dam: 15");
   }
}