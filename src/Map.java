import java.util.*;

public class Map {

	int[][] map;
	int curloc = 2;
	int maxwidth;
	int maxheight;
	boolean completed;
	
	public Map() 
	{
		Random rand = new Random();
		this.maxwidth = rand.nextInt((10-5) + 1) +5;
		this.maxheight = rand.nextInt((10-5) + 1) + 5;
		System.out.println(maxwidth + " " + maxheight);
		this.map = new int[maxheight][maxwidth];
	}

	public void fillmap()
	{
		Random rand = new Random();
		int spot;
		for(int i = 0; i < map.length; i++)
		{
			spot = rand.nextInt((7-1) + 1) + 1;
			for(int j = 0; j < map[i].length; j++)
			{
				if(j == spot)
					this.map[i][j] = 1;
				else
					this.map[i][j] = 0;
			}
		}
		map[0][0] = curloc;
	}
	
	public int explore(int direction)
	{
		//System.out.println("height and width " + map[maxheight-1][maxwidth-1]);
		
		
		
		if(map[maxheight-1][maxwidth-1] == curloc)
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
					if(map[i][j] == curloc)
					{
						int monstercheck;
						//System.out.println(i + " i + j " + j);
						map[i][j] = 0;
						if(direction == 1)
						{
							if(map[i][j+1] == 1)
							{
								System.out.println("Battle with monster");
							}
							map[i][j+1] = curloc;
						}
						else if(direction == 2)
						{
							if(map[i+1][j+1] == 1)
							{
								System.out.println("Battle with monster");
							}
							map[i+1][j+1] = curloc;
						}
						else //3
						{
							if(map[i+1][j] == 1)
							{
								System.out.println("Battle with monster");
							}
							map[i+1][j] = curloc;
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
	
	public void displayMap()
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				if(map[i][j] == curloc)
					System.out.print(2 + " | ");
				else
					System.out.print(this.map[i][j] + " | ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args)
	{
		Map map = new Map();
		System.out.println("Fill map");
		map.fillmap();
		System.out.println("display map");
		map.displayMap();
		Scanner kb = new Scanner(System.in);
		while(map.getCompleted()==false)
		{
			System.out.println("Enter direction to explore");
			System.out.println("1=right, 2=diag, 3 down");
			int dir = kb.nextInt();
			map.explore(dir);
			System.out.println();
			map.displayMap();
			System.out.println();
		}
		
		System.out.println("Map Completed");
		
//		map.explore(1); //right
//		map.displayMap();
//		map.explore(2); //diag
//		map.displayMap();
//		map.explore(3); //down
//		map.displayMap();


	}
}
