import java.util.*;

public class Communicator
{
   private Scanner input;
   
   public Communicator()
   {
      this.input = new Scanner(System.in);
   }
   
   public Communicator(Scanner in)
   {
      if(in != null)
         this.input = in;
      else
         this.input = new Scanner(System.in);
   }
   
   public void setInput(Scanner in)
   {
      if(in != null)
         this.input = in;
   }
   
   
   
   public void playerAttack(Player p, boolean armed, Character opp)
   {
      if(opp.getSuper().equals("BADGUY"))
      {
         BadGuy oppy = (BadGuy)opp;
         Random rng = new Random();
         int dam;
         if(armed)
         {
            dam = rng.nextInt((p.getWeapon().getDmax() - p.getWeapon().getDmin()) + 1) + p.getWeapon().getDmin();
            if(oppy.defend())
            {
               if(oppy.isArmored())
               {
                  int alvl = oppy.getArmorlvl();
                  p.getWeapon().changeCondition(p.getWeapon().getConditionNumeric() - dam);
                  oppy.setArmorlvl(alvl - dam);
                  if(!oppy.isArmored())
                  {
                     oppy.setHP(oppy.getHP() - (alvl - dam));   
                  }
               }
               System.out.println("Looks like " + oppy.getName() + "defended. Darn...");
            }
            oppy.setHP(oppy.getHP() - dam);
            System.out.println("You landed a successful blow. Hurray...");
            oppy.rage();
         }
         else
         {
            dam = rng.nextInt((p.getUmax() - p.getUmin()) + 1) + p.getUmin();
            if(oppy.defend())
            {
               if(oppy.isArmored())
               {
                  int alvl = oppy.getArmorlvl();
                  oppy.setArmorlvl(alvl - dam);
                  if(!oppy.isArmored())
                  {
                     oppy.setHP(oppy.getHP() - (alvl - dam));   
                  }
               }
               System.out.println("Looks like you were unable to successfully hit your oppent. Darn...");
            }
            oppy.setHP(oppy.getHP() - dam);
            System.out.println("You landed a successful blow. Hurray...");
            oppy.rage();
         }
         opp.setHP(oppy.getHP());
      }
      else if(opp.getSuper().equals("NPC"))
      {
         NPC oppi = (NPC)opp;
         Random rng = new Random();
         int dam;
         if(armed)
         {
            dam = rng.nextInt((p.getWeapon().getDmax() - p.getWeapon().getDmin()) + 1) + p.getWeapon().getDmin();
            if(oppi.defend())
               System.out.println("Looks like they defended. Bummer...");
            else
               oppi.setHP(oppi.getHP() - dam);   
         }
         else
         {
            dam = rng.nextInt((p.getUmax() - p.getUmin()) + 1) + p.getUmin();
            if(oppi.defend())
               System.out.println("Looks like they defended. Dang...");
            else
               oppi.setHP(oppi.getHP() - dam);
         }
         opp.setHP(oppi.getHP());
      }
      else if(opp.getSuper().equals("PARTY"))
      {
         System.out.println("First off, why are you attacking your own party?");
         System.out.println("Second, are you effing stupid? Your party helps you.");
         System.out.println("Use them to your advantage, i.e. use them to lay some hurt on some dungeon baddies.");
         System.out.println("(or some poor NPC in a cruel attempt to get their loot)");
      }
      else if(opp.getSuper().equals("CHARACTER"))
      {
         Random rng = new Random();
         int dam;
         if(p.isArmed())
         {
            dam = rng.nextInt((p.getWeapon().getDmax() - p.getWeapon().getDmin()) + 1) + p.getWeapon().getDmin();
            if(opp.defend())
               System.out.println("Looks like you couldn't land a  successful attack. Bummer...");
            else
               opp.setHP(opp.getHP() - dam);   
         }
         else
         {
            dam = rng.nextInt((p.getUmax() - p.getUmin()) + 1) + p.getUmin();
            if(opp.defend())
               System.out.println("Looks like you couldn't land a successful blow. Dang...");
            else
               opp.setHP(opp.getHP() - dam);
         }
      }
      else if(opp.getSuper().equals("PLAYER"))
         System.out.println("What the fuck are you doing trying to attack yourself? More importantly, how?");
      else
         System.err.println("You, or the game, passed in something weird. Hmm...");   
   }
   
   public void applyDamage(Character c, int dam)
   {
      if(c.getSuper().equals("PLAYER"))
      {
         Player p = (Player)c;
         if(p.defend())
         {
            if(p.isArmored())
            {
               int alvl = p.getArmorlvl();
               p.setArmorlvl(alvl - dam);
               if(!p.isArmored())
               {
                  p.setHP(p.getHP() - (alvl - dam));
               }
            }
            System.out.println(p.getName() + " the " + p.getType() + " defended.");
         }
         else
            p.setHP(p.getHP() - dam);
         c.setHP(p.getHP());
      }
      else if(c.getSuper().equals("PARTY"))
      {
         Party pt = (Party)c;
         if(pt.defend())
         {
            if(pt.getArmorlvl() > 0)
            {
               int alvl = pt.getArmorlvl();
               pt.setArmorlvl(alvl - dam);
               if(pt.getArmorlvl() == 0)
                  pt.setHP(pt.getHP() - (alvl - dam));
            }
            else
               pt.setHP(pt.getHP() - dam);
            c.setHP(pt.getHP());
         }
      }
      else if(c.getSuper().equals("NPC"))
      {
         NPC n = (NPC)c;
         if(n.defend())
            System.out.println(n.getName() + " defended against the attack!");
         else
            n.setHP(n.getHP() - dam);
         c.setHP(n.getHP());
      }
      else
         c.setHP(c.getHP() - dam);
   }
   
   public void applyNPCEffects(Player p, Character c)
   {
      if(c.getSuper().equals("PARTY"))
      {
         Party pt = (Party)c;
         if(pt.getPartyLeader().equals(p))
            pt.applyEffects();
         else
            System.err.println("Effects cannot be applied across parties/players.");
      }
      else
         System.err.println("Non-party characters don't give bonuses you dumbass.");
   }
   
   public void removeNPCEffects(Player p, Character c)
   {
      if(c.getSuper().equals("PARTY"))
      {
         Party pt = (Party)c;
         if(pt.getPartyLeader().equals(p))  
            pt.removeEffects();
         else
            System.err.println("Effects cannot be removed across parties/players.");    
      }
      else
         System.err.println("You can't remove that which does not exist!");
   }
   
   public void playerAddParty(Player p, Character c)
   {
      if(c.getSuper().equals("PARTY"))
         p.addToParty(c);
      else
         System.err.println("Can't add normal characters to party.");   
   }
   
   public void interactMerchant(Player p, Character c)
   {
      System.out.println("The merchant stares at you in eager anticipation. He really wants your gold.");
      int choice;
      do
      {
         System.out.println("1. Buy an item");
         System.out.println("2. Sell an item");
         System.out.println("3. Leave");
         try
         {
            choice = Integer.parseInt(this.input.nextLine());
         }
         catch(Exception e)
         {
            System.err.println("Invalid input detected.");
            choice = 0;
         }
      }while(choice < 1 || choice > 3);
      if(choice == 1)
         buyItem(p, c);
      else if(choice == 2)
         sellItem(p, c);
      else
         System.out.println("You decide to leave the merchant alone. He looks at you with disdain.");
   }
   
   private static void buyItem(Player p, Character c)
   {
      System.out.println("You have decided to buy from the merchant. Type \"exit\" to leave.");
      System.out.println("Here is their inventory: ");
      int want = -1;
      do
      {
         c.getInventory().displayItems();
         System.out.print("Enter num of item (or -1 for exit/none): ");
         Scanner kb = new Scanner(System.in);
         want = kb.nextInt();
         if(want != -1)
         {
            Item temp = c.getInventory().getItem(want);
            if(temp.getPrice() > p.getGold())
               System.out.println("You don't have enough gold to purchase that.");
            else
            {
               c.getInventory().removeItem(temp.getName(), 1);
               c.setGold(c.getGold() + temp.getPrice());
               p.setGold(p.getGold() - temp.getPrice());
               p.getInventory().addItem(temp, 1);
            }
         }
         else
            System.out.println("You have decided you didn't want anything.");
      }while(want != -1);
      System.out.println("The merchant thanks you for your business while holding back a guilty laugh.");
   }
   
   private static void sellItem(Player p, Character c)
   {
      System.out.println("You have elected to sell some of your items. Type \"exit\" to stop.");
      System.out.println("Here is your inventory: ");
      int doNotWant = -1;
      do
      {
         p.getInventory().displayItems();
         System.out.print("Enter item name (or exit): ");
         Scanner kb = new Scanner(System.in);
         doNotWant = kb.nextInt();
         if(doNotWant != -1)
         {
            Item temp = p.getInventory().getItem(doNotWant);
            if(temp.getPrice() > c.getGold())
               System.out.println("The merchant doesn't have enough gold to buy that (like they even wanted it in the first place)");
            else
            {
               p.getInventory().removeItem(temp.getName(), 1);
               p.setGold(p.getGold() + temp.getPrice());
               c.setGold(c.getGold() - temp.getPrice());
               c.getInventory().addItem(temp, 1);
            }
         }
         else
            System.out.println("You decided to actually not sell anything.");
      }while(doNotWant != -1);
      System.out.println("The merchant looks at you with extreme disdain, as if you just robbed him.");
   }
}