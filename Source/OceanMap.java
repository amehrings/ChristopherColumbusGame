/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */


import java.awt.Point;
import java.util.Random;

public class OceanMap {
	private static OceanMap uniqueInstance;
	boolean[][]islands;
	int dimensions;
	int islandCount;
	int pirateNumber = 0;
	Random rand = new Random();
	Point ChristopherColumbusLocation;
	Point treasureLocation;
	
	//Ocean Map constructor which creates the grid, places the islands and ChristopherColumbus
	private OceanMap(int dimensions, int islandCount) {
		this.dimensions = dimensions;
		this.islandCount = islandCount;
		createGrid();
		placeIslands();
		ChristopherColumbusLocation = placeChristopherColumbus();
		treasureLocation = placeTreasure();
	}
	
	public static OceanMap getInstance() {
		if (uniqueInstance == null) {
			Random randIsland = new Random();
			int randIslands = (randIsland.nextInt((20-10) + 1) + 10);
			uniqueInstance = new OceanMap(20, randIslands);
		}
		return uniqueInstance;
	}
	
	// Return generated map
	public boolean [][] getMap() {
		return islands; 
	}    
	
	//creates the island array, with every tile being an ocean tile initially
	private void createGrid() {
		islands = new boolean[dimensions][dimensions];
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				islands[x][y] = false;
			}
		}
	}
	
	//places islands and updates the islands array. Islands are marked as true in the array
	private void placeIslands() {
		int islandsToPlace = islandCount;
		while (islandsToPlace > 0) {
			int x = rand.nextInt(dimensions);
			int y = rand.nextInt(dimensions);
			if (islands[x][y] == false) {
				islands[x][y] = true;
				islandsToPlace--;
			}
		}
	}
	
	//places the ChristopherColumbus in a non-island location
	private Point placeChristopherColumbus() {
		boolean placedChristopherColumbus = false;
		int x = 0, y = 0;
		while (!placedChristopherColumbus) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (islands[x][y] == false) {
				placedChristopherColumbus = true;
			}
		}
		return new Point(x, y);
	}
	
	//places treasure randomly
	private Point placeTreasure() {
		boolean placedTreasure = false;
		int x = 0, y = 0;
		while (!placedTreasure) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (islands[x][y] == false) {
				placedTreasure = true;
			}
		}
		return new Point(x, y);
	}
	
	public Point getTreasureLocation() {
		return treasureLocation;
	}
	
	//returns the ChristopherColumbus location as a Point
	public Point getChristopherColumbusLocation() {
		return ChristopherColumbusLocation;
	}
	
	//return the dimensions of the ocean board
	public int getDimensions() {
		return dimensions;
	}
	
	//returns true if the tile at x, y is an ocean tile, false otherwise
	public boolean isOcean(int x, int y) {
		return !islands[x][y];
	}
}
