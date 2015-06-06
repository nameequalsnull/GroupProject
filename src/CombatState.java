import java.util.*;
public class CombatState implements GameState
{
   GameEngine engine;
   public CombatState(GameEngine g)
   {
      this.engine = g;
   }
   
   public void executeAction()
   {
      Player p = engine.getPlayer();
      Character opponent = engine.getEncountered();
      Scanner input = engine.getInput();
      if(opponent.getSuper().equals("BADGUY"))
      {
         BadGuy opp = (BadGuy)opponent;
         int choice = 0; 
         do
         {
            do
            {        
               System.out.println("1. Attack");
               System.out.println("2. Attempt crit");
               System.out.println("3. Exit");
               System.out.print("Your choice: ");
               try
               {
                  choice = Integer.parseInt(input.nextLine());
               }
               catch(Exception e)
               {
                  choice = 0;
               }
            }while(choice < 1 || choice > 3);
            if(choice == 1)
            {
               p.attack(opp);
               opp.attack(p);
            }
            else if(choice == 2)
            {
               int omin = p.getWeapon().getDmin();
               int omax = p.getWeapon().getDmax();
               double ochc = p.getHitChance();
               p.getWeapon().setDmin(2 * omin);
               p.getWeapon().setDmax(2 * omax);
               p.setHitChance(p.getCritChance());
               p.attack(opp);
               p.getWeapon().setDmin(omin);
               p.getWeapon().setDmax(omax);
               p.setHitChance(ochc);
            }
            else if(choice == 3)
            {
               System.out.println("You decide to forego this battle...");
               engine.updateState(engine.lastState());
               break;
            }
            
         }while(!p.isDead() || !opp.isDead());
         
         if(p.isDead())
         {
            System.out.println("You have been defeated!");
            engine.updateState(engine.deadPlayer());
         }
         else if(opp.isDead())
         {
            System.out.println("You are victorius!");
            engine.updateState(engine.normalState());
         }
         else
            System.out.println("Exiting combat state.");
      }
   }
}