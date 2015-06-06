public class Wizzard extends Party
{
   public Wizzard()
   {
      super("Dangalf", "Wizzard", 50, 30, .70, .30, .30, 7, 5, 13, 7, 10);
      this.setWeapon(new FireBall());
   }
   
   public void applyEffects()
   {
      this.getPartyLeader().setDefChance(this.getPartyLeader().getDefChance() + .10);
   }
   
   public void removeEffects()
   {
      this.getPartyLeader().setDefChance(this.getPartyLeader().getDefChance() - .10);
   }
   
   public void displayStats()
   {
      System.out.println("I'm lazy and don't really want to write this method.");
   }
}