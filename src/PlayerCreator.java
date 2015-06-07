import java.util.Scanner;

public class PlayerCreator extends CharacterCreator
{
   public PlayerCreator(){}
   
   public Character createCharacter()
   {
	   Scanner kb = new Scanner(System.in);
		int choice;
		do{
			System.out.println("What kind of Character would you like to play as? (Enter the number of your choice)");
			System.out.println("1) Knight");
			System.out.println("2) Mage");
			System.out.println("3) Archer");
			System.out.println("4) Assassin");
			choice = kb.nextInt();
			if(choice <= 0 || choice >= 5)
				System.out.println("Invalid choice, try again.");
		}while(choice <= 0 || choice >= 5); 
	   
      if(choice == 1)
         return new Knight();
      else if(choice == 2)
         return new Mage();
      else if(choice == 3)
         return new Archer();
      else if(choice == 4)
         return new Assassin();
      else
         return new GenericPlayer();
   }
}