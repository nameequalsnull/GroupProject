import java.util.ArrayList;

public class CParty
{
   private Character partyldr;
   ArrayList<Character> party;
   public static final int maxsize = 4;
   
   public CParty()
   {
	  party = new ArrayList<Character>(maxsize);
      this.partyldr = null;
   }
   
   public CParty(Character c)
   {
	   this.partyldr = c;
   }
   
   public void addPlayer(Character c)
   {
	   if(party.size() == maxsize)
	   {
		   System.out.println("Party is already full, can't add anymore");
	   }
	   else
	   {
		   party.add(c);
	   }
   }
   
   public void removePlayer(Character c)
   {
	   if(party.size() >= 1)
	   {
		   party.remove(c);
	   }
	   else
	   {
		   System.out.println("Party is empty");
	   }
   }
   
   protected void setPartyLeader(Player p)
   {
      if(p != null)
         this.partyldr = p;
      else
         this.partyldr = new NullPlayer();
   }
   
   public Character getPartyLeader()
   {
      return this.partyldr;
   }
   
   
   public void displayStats()
   {
	   for(Character c : party)
	   {
		   c.displayStats();
	   }
   }
      
   
}