/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

public class Dutchman extends PirateShip {

	public Dutchman(OceanMap oceanMap, int n) {
		this.oceanMap = oceanMap;
		this.number = n;
		currentLocation = oceanMap.getPirateLocation(n);
	}
	
	public String getPirateType() {
		return "Dutchman";
	}
	
}