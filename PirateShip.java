/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.awt.Point;
import java.util.Random;

public class PirateShip implements Observer  {

    Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	boolean[][] islandMap;
	Point ChristopherColumbusLocation;
	Strategy strat;
	String type;
	Random rand = new Random();
	
	public PirateShip(OceanMap oceanMap, String type) {
		this.oceanMap = oceanMap;
		this.type = type;
		while(true){

			int x = rand.nextInt(oceanMap.dimensions);

			int y = rand.nextInt(oceanMap.dimensions);

			if(oceanMap.isOcean(x,y) && oceanMap.getChristopherColumbusLocation().x != x && oceanMap.getChristopherColumbusLocation().y != y){

				currentLocation = new Point(x,y);

				break;

			}

		}
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
		strat.move();
	}

	
	public String getStrategy() {
		return strat.getStrategy();
		
	}
	
	public void setStrategy(Strategy strat) {
		this.strat = strat;
	}
	

	
}