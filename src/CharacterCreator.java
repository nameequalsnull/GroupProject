public abstract class CharacterCreator implements CreatorInterface
{
   public Object create(String supertype, String subtype)
   {
      if(supertype.equalsIgnoreCase("player"))
         return (new PlayerCreator()).createCharacter(subtype);
      else if(supertype.equalsIgnoreCase("party"))
         return (new GoodGuyCreator()).createCharacter(subtype);
      else if(supertype.equalsIgnoreCase("badguy"))
         return (new BadGuyCreator()).createCharacter(subtype);
      else
         return (new DefaultCharacterCreator()).createCharacter(subtype);
   }
   
   public abstract Character createCharacter(String type);
}