public class SwordsMan extends Party
{
   public SwordsMan()
   {
      super("John", "Swordsman", 70, 10, .60, .45, .25, 10, 10, 23, 5, 40);
      this.setWeapon(new LongSword());
   }
   
   public void applyEffects()
   {
      this.getPartyLeader().setHP(this.getPartyLeader().getHP() + 10);
   }
   
   public void removeEffects()
   {
      this.getPartyLeader().setHP(this.getPartyLeader().getHP() - 10);
   }
   
   public void displayStats()
   {
      System.out.println("I'm lazy and don't really want to write this method.");
   }
}