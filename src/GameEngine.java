import java.util.*;
public class GameEngine
{
   GameState combat;
   GameState init;
   GameState normal;
   GameState interactive;
   GameState encounter;//todo
   GameState movement;//todo
   GameState player_is_dead;
   GameState current;
   GameState last;
   Player p;
   Character encountered;
   Scanner input;
   
   public GameEngine()
   {
      //this.combat = new CombatState(this);
//      this.init = new InitState(this);
//      this.normal = new NormalState(this);
//      this.interactive = new InteractiveState(this);
//      this.encounter = new EncounterState(this);
//      this.movement = new MovementState(this);
//      this.player_is_dead = new PlayerDeadState(this);
      this.init.executeAction();
      this.current = this.init;
      updateState(this.normal);
   }
   
   public void updateState(GameState new_state)
   {
      this.last = this.current;
      this.current = new_state;
      this.current.executeAction();
   }
   
   public Player getPlayer(){return this.p;}
//   public void SetPlayer(Player p){this.player = p;}
   public void setEncountered(Character c){this.encountered = c;}
   public Scanner getInput(){return this.input;}
   public void setInput(Scanner in){this.input = in;}
   public Character getEncountered(){return this.encountered;}
   public GameState lastState(){return this.last;}
   public GameState getCurrent(){return this.current;}
   public GameState normalState(){return this.normal;}
   public GameState deadPlayer(){return this.player_is_dead;}
   public GameState getInteraction(){return this.interactive;}
   public GameState getEncounterState(){return this.encounter;}
   public GameState moving(){return this.movement;}
}