/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.awt.Point;

public class VerticalMoveStrategy implements Strategy {
	Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	
	@Override
	public void movePirateShip() {
		
	}

	@Override
	public String getStrategy() {
		return "BasicMoveStrategy";
		
	}


}
