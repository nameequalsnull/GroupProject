import java.util.*;
public abstract class Player extends GoodGuy
{
   private ArrayList<Character> party;
   private boolean armored;
   private int armorlvl;
   private Ability abl;
   private SpecialAbility sabl;
   private static final int maxc =4;
   
   public Player()
   {
      super(50, .50, 50, .50, .50, 10, 3, 10, "Player1", "Player", 1);
      this.armored = false;
      this.armorlvl = 0;
      party = new ArrayList<Character>(maxc);
      this.setInventory(new Inventory());
      this.setSuper("PLAYER");
   }
   
   public Player(String n, String t, int h, int a, double hc, double dc, double cc, int s, int umin, int umax, int as)
   {
      super(n, t, h, a, hc,dc,cc,s,umin, umax, as);
      this.armored = false;
      this.armorlvl = 0;
      party = new ArrayList<Character>(maxc);
      this.setInventory(new Inventory());
      this.setSuper("PLAYER");
   }
   
   public void setAbility(Ability a)
   {
      if(a != null)
         this.abl = a;
   }
   public void setSpecial(SpecialAbility s)
   {
      if(s != null)
         this.sabl = s;
   }
   
   public Ability getAbility(){return this.abl;}
   public SpecialAbility getSpecial(){return this.sabl;}
   
   public void addToParty(Character c)
   {
	   if(party.size() == maxc)
	   {
		   System.out.println("Party is already full, can't add anymore");
	   }
	   else
	   {
		   party.add(c);
	   }
   }
   
   public int getArmorlvl()
   {
      return this.armorlvl;
   }
   
   public boolean isArmored(){return this.armored;}
   
   public void setArmorlvl(int h)
   {
      this.armorlvl = (h < 0 || h > 150) ? (h < 0 ? 0 : (h > 150 ? 150 : h)) : h;
      this.armored = (this.armorlvl == 0) ? false : true;
   }
   
   public void removeFromParty(Character c)
   {
	  if(party.size() >= 1)
		  party.remove(c);
	  else
		  System.out.println("Party is empty");
   }
   
   public void removeFromParty(String name)
   {
      for(Character c : party)
         if(c.getName().compareTo(name) == 0)
            removeFromParty(c);
   }
   
   public void dismissParty()
   {
      for(Character c : party)
         removeFromParty(c);
   }
   
   public Character getPartyMember(Character c)
   {
      return party.get(party.indexOf(c));
   }
   
   public Character getPartyMember(String name)
   {
      for(Character c : party)
      {
         if(c.getName().compareTo(name) == 0)
            return c;
      }
      return null;
   }
   
//   private void applyEffects(Character c)
//   {
//      this.getCommunicator().applyNPCEffects(this, c);
//   }
//   
//   private void removeEffects(Character c)
//   {
//      this.getCommunicator().removeNPCEffects(this, c);
//   }
   
   public boolean defend()
   {
      if(this.confirmed(this.getDefChance()))
      {
         if(armored && armorlvl != 0)
            System.out.println(this.getName() + "'s armor stopped the blow!");
         else
            System.out.println(this.getName() + " successfully blocked the attack!");
         return true;
      }
      else
      {
         System.out.println(this.getName() + " was unable to defend against the attack!");
         return false;
      }
   }
   
   public void partyAttack(Character c)
   {
      for(Character temp : party)
      {
            ((Party)temp).attack(c);
      }
   }
   
   public void memberAttack(String name, Character temp)
   {
      for(Character c :  party)
      {
         if(c.getName().compareTo(name) == 0)
         {
            ((Party)c).attack(temp);
            break;     
         }
      }
   }
   
   public void getInfo(Character c)
   {
      c.displayInfo();
   }
   
   public void displayStats()
   {
	   for(Character c : party)
	   {
		   c.displayStats();
	   }
   }
   
   public void currentStats()
   {
      System.out.println("HP: " + this.getHP());
      if(this.armored)
         System.out.println("ARMOR: " + this.armorlvl);
      else
         System.out.println("UNARMORED");
      System.out.println("GOLD: " + this.getGold());
      this.getInventory().displayItems();
   }
   
   public void attack(Character c)
   {
      if(this.confirmed(this.getHitChance()))
      {
         this.getCommunicator().playerAttack(this, this.isArmed(), c);
         System.out.println(this.getName() + " landed a successful blow to " + c.getName());
         if(c.isDead())
         {
            System.out.println(this.getName() + " brutally slaughtered " + c.getName() + " using a " + (this.isArmed() ? this.getWeapon().getName() : " their BEAR hands."));
            if(c.hasItems())
               this.takeItems(c);
            this.takeGold(c);
         }
         else
            System.out.println(c.getName() + " is still standing!");   
      }
      else
         System.out.println(this.getName() + " was unable to land a blow on " + c.getName());   
   }
   
   //public abstract void availableActionsEncounter(Scanner kb, Character encounter);
   //public abstract void availableActionsNormal(Scanner kb);
}