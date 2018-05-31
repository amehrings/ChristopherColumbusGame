/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.awt.Point;


public class RegularPirate extends PirateShip implements Observer {

	Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	boolean[][] islandMap;
	Point ChristopherColumbusLocation;
	Strategy strat;
	int number = oceanMap.getPirateNumber();
	String type;
	
	
	public RegularPirate(OceanMap oceanMap, int n, String type) {
		super(oceanMap, n, type);
	}

	public String getPirateType() {
		return "Regular";
	}

}