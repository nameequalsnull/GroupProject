public class GenericCharacter extends Character
{
   public GenericCharacter()
   {
      super();
      this.setSuper("GENERIC");
   }
   
   public void displayInfo()
   {
      System.out.println("There's nothing here...");
   }
   
   public boolean defend()
   {
      return 1 > 2;
   }
   
   public void displayStats()
   {
      System.out.println("GenericCharacter");
   }
}