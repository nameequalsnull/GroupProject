public class AnnoyingNPC extends NPC
{
   public AnnoyingNPC()
   {
       super(40, .45, 10, 20, "Thug Dog the Terrible", "AnnoyingNPC");
   }
   
   public void displayStats()
   {
      System.out.println("Name: Thug Dog the Terrible");
      System.out.println("Class: AnnoyingNPC");
      System.out.println("Starting HP: 40");
      System.out.println("Defense chance: 45%");
      System.out.println("Unarmed min dam: 10HP");
      System.out.println("Unarmed max dam: 20HP");
   }
}