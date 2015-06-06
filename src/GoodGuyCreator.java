public class GoodGuyCreator extends CharacterCreator
{
   public GoodGuyCreator(){}
   public Character createCharacter(String type)
   {
      if(type.equalsIgnoreCase("swordsman"))
         return new SwordsMan();
      else if(type.equalsIgnoreCase("wizzard"))
         return new Wizzard();
      else
         return new GenericCharacter();
   }
}