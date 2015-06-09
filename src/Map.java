import java.util.*;

public class Map {

	Character[][] map;
	int curloc = 2;
	int maxwidth;
	int maxheight;
	boolean completed;
	BadGuyCreator badc = new BadGuyCreator();
	Scanner kb = new Scanner(System.in);
	public Map() 
	{
		Random rand = new Random();
		this.maxwidth = rand.nextInt((10-5) + 1) +5;
		this.maxheight = rand.nextInt((10-5) + 1) + 5;
		//System.out.println(maxwidth + "x" + maxheight);
		this.map = new Character[maxheight][maxwidth];
	}

	public void fillmap(Character player)
	{
		Random rand = new Random();
		int spot;
		for(int i = 0; i < map.length; i++)
		{
			spot = rand.nextInt((7-1) + 1) + 1;
			for(int j = 0; j < map[i].length; j++)
			{
				if(j == spot)
				{
					int rm = rand.nextInt((4-1) + 1) +1;
					if(rm == 1)
						this.map[i][j] = badc.createCharacter("troll");
					else if(rm == 2)
						this.map[i][j] = badc.createCharacter("skeleton");
					else if(rm == 3)
						this.map[i][j] = badc.createCharacter("imp");
					else
						this.map[i][j] = badc.createCharacter("ghost");
				}
				else
					this.map[i][j] = null;
			}
		}
		map[0][0] = player;
	}
	
	public int explore(Character player, CParty party)
	{
		//System.out.println("height and width " + map[maxheight-1][maxwidth-1]);
		Scanner kb = new Scanner(System.in);
		System.out.println("Current Map");
		displayMap(player);
		System.out.println("Enter direction to explore");
		System.out.println("1=right, 2=diag, 3 down");
		int direction = kb.nextInt();
		
		
		if(map[maxheight-1][maxwidth-1] == player)
		{
			completed = true;
			System.out.println("Congrats! You have reached the end of the map");
			System.out.println("Generating new map");
			new Map();
		}
		else
		{
			boolean found = false;
			//System.out.println(direction + " direction");
			for(int i = 0; i < map.length; i++)
			{
				for(int j = 0; j < map[i].length; j++)
				{
					if(map[i][j] == player)
					{
						//int monstercheck;
						//System.out.println(i + " i + j " + j);
						map[i][j] = null;
						boolean died = false;
						if(direction == 1)
						{
							if(map[i][j+1] != null)
							{
								Character monster = map[i][j+1];								
								System.out.println("You have encountered a(n) " + monster.getName() + ", it's time for battle!");
								//do{
									System.out.println("Your hp: " + player.getHP() + " Enemy hp: " + monster.getHP());
									died = battle(player, party, monster);
									if(died == false)
											System.out.println("Congrautlations, you are successful in battle and continue through the map");
								//}while(!monster.isDead() || !player.isDead());
							}
							if(died == true)
							{
								System.out.println("You have died, the game is over, better luck next time");
								System.exit(-1);
							}
							else
							{
								System.out.println("You continue through the map");
								System.out.println();
								map[i][j+1] = player;
							}
						}
						else if(direction == 2)
						{
							if(map[i+1][j+1] != null)
							{
								Character monster = map[i+1][j+1];
								System.out.println("You have encountered a(n) " + monster.getName() + ", it's time for battle!");
								//do{
									System.out.println("Your hp: " + player.getHP() + " Enemy hp: " + monster.getHP());
									died = battle(player, party, monster);
									if(died == false)
										System.out.println("Congrautlations, you are successful in battle and continue through the map");
								//}while(!monster.isDead() || !player.isDead());
							}
							if(player.isDead())
							{
								System.out.println("You have died, the game is over, better luck next time");
								System.exit(-1);
							}
							else
							{
								System.out.println("You continue through the map");
								System.out.println();
								map[i+1][j+1] = player;
							}
						}
						else //3
						{
							if(map[i+1][j] != null)
							{
								Character monster = map[i+1][j];
								System.out.println("You have encountered a(n) " + monster.getName() + ", it's time for battle!");
								//do{
									System.out.println("Your hp: " + player.getHP() + " Enemy hp: " + monster.getHP());
									died = battle(player, party, monster);
									if(died == false)
										System.out.println("Congrautlations, you are successful in battle");
								//}while(!monster.isDead() || !player.isDead());
							}
							if(player.isDead())
							{
								System.out.println("You have died, the game is over, better luck next time");
								System.exit(-1);
							}
							else
							{
								System.out.println("You continue through the map");
								System.out.println();
								map[i+1][j] = player;
							}
						}
						found = true;
						break;
					}
				}
				if(found == true)
					break;
			}
		}
		return -1;
	}
	
	public boolean getCompleted()
	{
		return this.completed;
	}
	
	public void displayMap(Character player)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				if(map[i][j] == player)
					System.out.print(2 + " | ");
				else
				{
					if(map[i][j] == null)
						System.out.print(0 + " | ");
					else
						System.out.print(1 + " | ");
				}
			}
			System.out.println("");
		}
	}
	
//	public static void main(String[] args)
//	{
//		Map map = new Map();
//		System.out.println("Fill map");
//		//map.fillmap();
//		System.out.println("display map");
//		//map.displayMap();
//		Scanner kb = new Scanner(System.in);
//		while(map.getCompleted()==false)
//		{
//			System.out.println("Enter direction to explore");
//			System.out.println("1=right, 2=diag, 3 down");
//			int dir = kb.nextInt();
//			//map.explore(dir);
//			System.out.println();
//			//map.displayMap();
//			System.out.println();
//		}
//		
//		System.out.println("Map Completed");
//		
////		map.explore(1); //right
////		map.displayMap();
////		map.explore(2); //diag
////		map.displayMap();
////		map.explore(3); //down
////		map.displayMap();
//
//
//	}
	
	public boolean battle(Character player, CParty party, Character enemy)
	{
//		System.out.println("Starting Battle Stats");
//		System.out.println(this.getName() + " vs " + enemy.getName());
//		System.out.println(this.getHP() + " vs " + enemy.getHP());
		
		//while(!this.isDead() || !enemy.isDead())
		//{
			//Random rng = new Random();
			//double chance = (rng.nextDouble());
			//System.out.println("chance: " + chance);
			System.out.println();
			boolean pdead = false, edead=false;
			int php, ehp;
			php = player.getHP();
			ehp = enemy.getHP();
			
			while(pdead == false && edead == false)
			{
				Random rng = new Random();
				double chance = (rng.nextDouble());			
			if(player.hitchance > chance)//player attacking enemy
			{
				if(enemy.getDefChance() < chance)
				{
					System.out.println("Your hit lands!");
					if(player.weapon != null)
					{   //int rm = rand.nextInt((4-1) + 1) +1;
						int hit = rng.nextInt((player.weapon.getDmax() - player.weapon.getDmin()) + player.weapon.getDmin());
						System.out.println("Your " + player.weapon.getName() + " hits " + hit + " on " + enemy.getName());
						int dmg = (ehp - hit);
						//System.out.println("new hp: " + dmg);
						if(dmg <= 0)
						{
							System.out.println("enemy died");
							player.takeItems(enemy);
							edead = true;
						}
						else
						{
							ehp = dmg;
							System.out.println(enemy.getName() + " has " + ehp + " hp left");
						}
					}
				}
				else
				{
					System.out.println("Your attack has no affect");
				}
			}
			else
			{
				System.out.println("Your attack has missed");
			}
			//System.out.println(" ");
			chance = (rng.nextDouble());
			if(enemy.hitchance > chance)//enemy attacking player
			{
				if(player.getDefChance() < chance)
				{
					int hit = rng.nextInt((enemy.getUmax() - enemy.getUmin()) + enemy.getUmin());
					System.out.println(enemy.getName() + " attacks you " + " doing " + hit + " damage");
					int dmg = (php - hit);
					if(dmg <= 0)
					{
						System.out.println("player died");
						pdead = true;
					}
					else
					{
						//System.out.println("new hp: " + dmg);
						php = dmg;
						System.out.println("You have " + php + " hp left");
					}
				}
			}
			else
			{
				System.out.println(enemy.getName() + "'s attack has missed");
			}	
			
			if(pdead == true)
			{
				party.removePlayer(player);
				System.out.println("You have died, would you like to switch to another party member or quit the game (1 for continue, 0 for quit)");
				int choice = kb.nextInt();
				while(choice >1 || choice < 0)
				{
					System.out.println("Invalid choice, try again");
					choice = kb.nextInt();
				}
				
				if(choice == 0)
					return true;
				else
				{
					if(party.party.size() > 0)
					{
						System.out.println("Which member would you like to put in?");
						party.displayInfo();
						int pchoice = kb.nextInt();
						player = party.party.get(pchoice);
						pdead = false;
					}
				}
					
			}
		} //end of the while
		return pdead;
	}
}
