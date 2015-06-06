public class PlayerCreator extends CharacterCreator
{
   public PlayerCreator(){}
   
   public Character createCharacter(String type)
   {
      if(type.equalsIgnoreCase("knight"))
         return new Knight();
      else if(type.equalsIgnoreCase("mage"))
         return new Mage();
      else if(type.equalsIgnoreCase("archer"))
         return new Archer();
      else if(type.equalsIgnoreCase("assassin"))
         return new Assassin();
      else
         return new GenericPlayer();
   }
}