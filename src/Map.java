import java.util.*;

public class Map {

	Character[][] map;
	int curloc = 2;
	int maxwidth;
	int maxheight;
	boolean completed;
	BadGuyCreator badc = new BadGuyCreator();
	
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
	
	public int explore(Player player)
	{
		//System.out.println("height and width " + map[maxheight-1][maxwidth-1]);
		Scanner kb = new Scanner(System.in);
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
						if(direction == 1)
						{
							if(map[i][j+1] != null)
							{
								System.out.println("You have encountered a(n) " + map[i+1][j].getName() + ", it's time for battle!");
								do{
								player.attack(map[i+1][j+1]);
								}while(!map[i][j+1].isDead() || !player.isDead());
							}
							map[i][j+1] = player;
						}
						else if(direction == 2)
						{
							if(map[i+1][j+1] != null)
							{
								System.out.println("You have encountered a(n) " + map[i+1][j].getName() + ", it's time for battle!");
								do{
								player.attack(map[i+1][j+1]);
								}while(!map[i+1][j+1].isDead() || !player.isDead());
							}
							map[i+1][j+1] = player;
						}
						else //3
						{
							if(map[i+1][j] != null)
							{
								System.out.println("You have encountered a(n) " + map[i+1][j].getName() + ", it's time for battle!");
								do{
									player.attack(map[i+1][j]);
									}while(!map[i+1][j+1].isDead() || !player.isDead());
							}
							map[i+1][j] = player;
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
}
