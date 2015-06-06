public class ItemFactory
{
	public Item getItem(String name)
	{
		  if(name == null){
	         return null;
	      }		
	      if(name.equalsIgnoreCase("FOOD")){
	         return new Food();
	      } else if(name.equalsIgnoreCase("POTION")){
	         return new Potion();
	      } else if(name.equalsIgnoreCase("ARMOR")){
	         return new BodyArmor();
	      }  else if(name.equalsIgnoreCase("HELMET")){
		         return new Helmet();
		  } else if(name.equalsIgnoreCase("SHIELD")){
		         return new Shield();
		  } else if(name.equalsIgnoreCase("DAGGER")){
	             return new Dagger();
	  	  } else {
	  		  System.out.println("Item not found");
	  	  }
	  		  
	      
	      return null;
	}
}