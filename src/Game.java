import java.io.*;
import java.util.*;

public class Game {
	
		static Scanner kb = new Scanner(System.in);
		
	public static void main (String[] args)
	{
		Map world = new Map();
		ItemFactory itemfac = new ItemFactory();
		CharacterCreator playercreator = new PlayerCreator();
		Character player = playercreator.createCharacter();
		StoreNPC NPCstore = new StoreNPC();
		System.out.println("You are playing as a(n) " + player.getName());
		world.fillmap(player);

		int choice = 2;
		while(choice != 0)
		{			
			choice = menu();
			if(choice == 0)
			{
				System.out.println("Good Game");
				break;
			}
			else if(choice == 1)
			{
				world.explore(player);
			}
			else if(choice == 2)
			{
				player.displayStats();
			}
			else if(choice == 3)
			{
				player.getInventory().displayItems();
			}
			else if(choice == 4)
			{
				NPCstore.interact(player);
			}
		}
		
		
	}
	
	public static int menu()
	{
		int choice;
		System.out.println("What would you like to do?");
		System.out.println("1) Display/Explore the map");
		System.out.println("2) Check your stats");
		System.out.println("3) Check your inventory");
		System.out.println("4) Talk to the store NPC");
		System.out.println("0) Quit");
		
		
		choice = kb.nextInt();
		while(choice < 0 || choice > 4)
		{
			System.out.println("Invalid choice, try again");
			choice = kb.nextInt();
		}
		System.out.println();
		return choice;
	}



}
