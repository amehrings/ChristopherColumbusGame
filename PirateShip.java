/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.awt.Point;

public class PirateShip implements Observer  {

    Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	boolean[][] islandMap;
	Point ChristopherColumbusLocation;
	Strategy strat;
	int number = oceanMap.getPirateNumber();
	String type;
	
	public PirateShip(OceanMap oceanMap, int n, String type) {
		this.oceanMap = oceanMap;
		this.number = n;
		this.type = type;
		currentLocation = oceanMap.getPirateLocation(n);
	}
	
	
	//returns the ship location as a Point
	public Point getPirateShipLocation() {
		return currentLocation;
	}

	//updates Pirate Ship of Christopher Columbus's location
	@Override
	public void update(ChristopherColumbus cc) {
		
		if (cc instanceof ChristopherColumbus) {
			ChristopherColumbusLocation = ((ChristopherColumbus) cc).getChristopherColumbusLocation();
			move();
		}
		
	}

	//moves Pirate Ship closer to Christopher Columbus
	public void move() {
		if (currentLocation.x - ChristopherColumbusLocation.x < 0) {
			if (currentLocation.x + 1 < oceanMap.getDimensions() 
					&& oceanMap.isOcean(currentLocation.x+1, currentLocation.y) ) {
				currentLocation.x++;
			}
		}
		else {
			if (currentLocation.x != 0 
					&& oceanMap.isOcean(currentLocation.x-1, currentLocation.y)) {				
				currentLocation.x--;
			}
		}
		
		if (currentLocation.y - ChristopherColumbusLocation.y < 0) {
			if (currentLocation.y + 1 < oceanMap.getDimensions()
					&& oceanMap.isOcean(currentLocation.x, currentLocation.y+1)) {
				currentLocation.y++;
			}
		}
		else {
			if (currentLocation.y != 0
					&& oceanMap.isOcean(currentLocation.x, currentLocation.y-1)) {
				currentLocation.y--;
			}
		}  
	}

	public String getStrategy() {
		return strat.getStrategy();
		
	}
	
	public void setStrategy(Strategy strat) {
		this.strat = strat;
	}

	
}