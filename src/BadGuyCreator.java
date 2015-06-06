public class BadGuyCreator extends CharacterCreator
{
   public BadGuyCreator(){}
   public Character createCharacter(String type)
   {
      if(type.equalsIgnoreCase("troll"))
         return new Troll();
      else if(type.equalsIgnoreCase("skeleton"))
         return new Skeleton();
      else if(type.equalsIgnoreCase("imp"))
         return new Imp();
      else if(type.equalsIgnoreCase("ghost"))
         return new Ghost();
      else
         return new GenericCharacter();
   }
}