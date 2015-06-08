import java.util.*;

public class GoodGuyCreator extends CharacterCreator
{
   public GoodGuyCreator(){}
   public Character createCharacter()
   {
	   Scanner kb = new Scanner(System.in);
		int choice;
		do{
			System.out.println("What kind of Character would you like? (Enter the number of your choice)");
			System.out.println("1) Swordsman");
			System.out.println("2) Wizard");
			System.out.println("3) Generic");
			choice = kb.nextInt();
			if(choice <= 0 || choice >= 4)
				System.out.println("Invalid choice, try again.");
		}while(choice <= 0 || choice >= 4); 
	   
      if(choice == 1)
         return new SwordsMan();
      else if(choice == 2)
         return new Wizzard();
      else
         return new GenericCharacter();
   }
}