/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.awt.Point;


public class RegularPirate extends PirateShip {

	
	public RegularPirate(OceanMap oceanMap, int n) {
		this.oceanMap = oceanMap;
		this.number = n;
		currentLocation = oceanMap.getPirateLocation(n);
	}
	
	public String getPirateType() {
		return "Regular";
	}

}