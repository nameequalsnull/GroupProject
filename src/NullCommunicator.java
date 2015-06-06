public class NullCommunicator extends Communicator
{
   public NullCommunicator()
   {
      super();
      System.out.println("This does absolutely nothing...");
   }
   
   public void playerAttack(Player p, boolean armed, Character opp)
   {
      System.out.println("This does absolutely nothing...");   
   }
   
   public void applyDamage(Character c, int dam)
   {
      System.out.println("This does absolutely nothing...");
   }
   
   public void applyUnarmedDamage(Character c, int dam)
   {
      System.out.println("This does absolutely nothing...");
   }
   
   public void applyNPCEffects(Player p, Character c)
   {
      System.out.println("This does absolutely nothing...");
   }
   
   public void removeNPCEffects(Player p, Character c)
   {
      System.out.println("This does absolutely nothing...");
   }
   
   public void playerAddParty(Player p, Character c)
   {
      System.out.println("This does absolutely nothing...");
   }
}