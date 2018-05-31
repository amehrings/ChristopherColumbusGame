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
		System.out.println("update pirate Ship");
		if (cc instanceof ChristopherColumbus) {
			System.out.println("update pirate Ship2");
			ChristopherColumbusLocation = ((ChristopherColumbus) cc).getChristopherColumbusLocation();
			move();
		}
		
	}

	//moves Pirate Ship closer to Christopher Columbus
	public void move() {
		strat.move();
	}

	
	public String getStrategy() {
		return strat.getStrategy();
		
	}
	
	public void setStrategy(Strategy strat) {
		this.strat = strat;
	}
	

	
}