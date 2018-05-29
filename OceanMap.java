/* Austin Paul
 * Assignment 2
 * SE350
 */


import java.awt.Point;
import java.util.Random;

public class OceanMap {
	boolean[][]islands;
	int dimensions;
	int islandCount;
	Random rand = new Random();
	Point ChristopherColumbusLocation;
	Point pirateOneLocation;
	Point pirateTwoLocation;
	
	//Ocean Map constructor which creates the grid, places the islands and ChristopherColumbus
	public OceanMap(int dimensions, int islandCount) {
		this.dimensions = dimensions;
		this.islandCount = islandCount;
		createGrid();
		placeIslands();
		ChristopherColumbusLocation = placeChristopherColumbus();
		pirateOneLocation = placePirateChristopherColumbus();
		pirateTwoLocation = placePirateChristopherColumbus();
	}
	
	// Return generated map
	public boolean [][] getMap() {
		return islands; 
	}    
	
	//creates the island array, with every tile being an ocean tile initially
	private void createGrid() {
		islands = new boolean[20][20];
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
	
	//places the pirate ChristopherColumbuss onto the ocean
	private Point placePirateChristopherColumbus() {
		boolean placedPirateChristopherColumbus = false;
		int x = 0, y = 0;
		while (!placedPirateChristopherColumbus) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (islands[x][y] == false) {
				placedPirateChristopherColumbus = true;
			}
		}
		return new Point(x, y);
	}
	
	//returns the ChristopherColumbus location as a Point
	public Point getChristopherColumbusLocation() {
		return ChristopherColumbusLocation;
	}
	
	//returns the pirate locations based on its number a Point
	public Point getPirateLocation(int n) {
		if (n == 2) {
			return pirateTwoLocation;
		}
		return pirateOneLocation;
	}
	
	
	//returns Pirate 2's location as a Point
	
	
	//return the dimensions of the ocean board
	public int getDimensions() {
		return dimensions;
	}
	
	//returns true if the tile at x, y is an ocean tile, false otherwise
	public boolean isOcean(int x, int y) {
		return !islands[x][y];
	}
}
