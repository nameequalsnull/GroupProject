public class DefaultCharacterCreator extends CharacterCreator
{
   public DefaultCharacterCreator(){}
   public Character createCharacter(String type)
   {
      if(type.equalsIgnoreCase("merchant"))
         return new Merchant();
      else if(type.equalsIgnoreCase("helpfulnpc"))
         return new HelpfulNPC();
      else if(type.equalsIgnoreCase("annoyingnpc"))
         return new AnnoyingNPC();
      else
         return new GenericCharacter();
   }
}