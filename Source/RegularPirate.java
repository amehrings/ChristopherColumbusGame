/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.awt.Point;

//implements observer pattern and creates regular pirates (vertical and horizontal movers)
public class RegularPirate extends PirateShip implements Observer {

	Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	boolean[][] islandMap;
	Point ChristopherColumbusLocation;
	Strategy strat;
	String type;
	
	//RegularPirate constructor
	public RegularPirate(OceanMap oceanMap, String type) {
		super(oceanMap, type);
	}

	//returns string of pirate type
	public String getPirateType() {
		return "Regular";
	}

}