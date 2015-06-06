public class Skeleton extends BadGuy
{
   public Skeleton()
   {
      super(20, .20, .01, .07, .45, 1, 10, 15, 28, 5, 0, false, "Bone Shards", "Spoopy Skeleton", "Skeleton");
   }
   
   public void displayStats()
   {
      System.out.println("Class: Skeleton");
      System.out.println("Name: Spoopy Skeleton");
      System.out.println("Starting HP: 20");
      System.out.println("Hit Chance: 45%");
      System.out.println("Defense chance: 20%");
      System.out.println("Special chance: 1%");
      System.out.println("Rage chance: 7%");
      System.out.println("Unarmed min dam: 1HP");
      System.out.println("Unarmed max dam: 10HP");
      System.out.println("Armed min dam: 15HP");
      System.out.println("Armed max dam: 28HP");
      System.out.println("Pain tolerance lvl: 5");
      System.out.println("Armor lvl: 0");
   }
}