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
		world.fillmap(player);
		
		System.out.println(player.getName());
		
		world.displayMap(player);
		
		
	}


}
