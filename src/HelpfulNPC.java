public class HelpfulNPC extends NPC
{
   public HelpfulNPC()
   {
      super(30, .20, 2, 8, "Good Samaritan", "HelpfulNPC");
   }
   
   public void displayStats()
   {
      System.out.println("Name: Good Samaritan");
      System.out.println("Class: HelpfulNPC");
      System.out.println("Starting HP: 30");
      System.out.println("Defense chance: 20%");
      System.out.println("Unarmed min dam: 2HP");
      System.out.println("Unarmed max dam: 8HP");
   }
}