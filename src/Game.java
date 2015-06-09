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
		CParty party = new CParty(player);
		//System.out.println(player.weapon.getName());
		StoreNPC NPCstore = new StoreNPC();
		System.out.println("You are playing as a(n) " + player.getName());
		int pchoice;
		do{
			System.out.println("Would you like to add more members to your party or go it alone? (0 for no, 1 for yes)");
			pchoice = kb.nextInt();
			if(pchoice == 1)
			{
				Character nplayer = playercreator.createCharacter();
				party.addPlayer(nplayer);
				if(party.party.size() == 4)
					break;
			}
		}while(pchoice != 0);

		
		
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
				world.explore(player, party);
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
			else if(choice == 5)
			{
				party.displayInfo();
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
		System.out.println("5) View your party");
		System.out.println("0) Quit");
		
		
		choice = kb.nextInt();
		while(choice < 0 || choice > 5)
		{
			System.out.println("Invalid choice, try again");
			choice = kb.nextInt();
		}
		System.out.println();
		return choice;
	}



}
