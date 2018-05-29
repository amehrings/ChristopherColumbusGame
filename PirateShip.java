/* Austin Paul
 * Assignment 2
 * SE350
 */

import java.awt.Point;


public class PirateShip implements Observer {
	Point currentLocation;
	OceanMap oceanMap;
	boolean[][] islandMap;
	Point ChristopherColumbusLocation;
	int number;
	
	//Pirate Ship constructor 
	public PirateShip(OceanMap oceanMap, int n) {
		this.oceanMap = oceanMap;
		this.number = n;
		currentLocation = oceanMap.getPirateLocation(n);
	}
	
	//returns the ship location as a Point
	public Point getPirateShipLocation() {
		return currentLocation;
	}

	//updates Pirate Ship of CHristopher Columbus's location
	@Override
	public void update(ChristopherColumbus cc) {
		
		if (cc instanceof ChristopherColumbus) {
			ChristopherColumbusLocation = ((ChristopherColumbus) cc).getChristopherColumbusLocation();
			movePirateShip();
		}
		
	}

	//moves Pirate Ship closer to Christopher Columbus
	public void movePirateShip() {
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

}