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
	String type;
	
	
	public RegularPirate(OceanMap oceanMap, String type) {
		super(oceanMap, type);
	}

	public String getPirateType() {
		return "Regular";
	}

}