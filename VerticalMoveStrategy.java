/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.awt.Point;

public class VerticalMoveStrategy implements Strategy {
	Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	
	@Override
	public void move() {
		currentLocation.y++;
		
		/*if (currentLocation.y + 1 < oceanMap.getDimensions() && oceanMap.isOcean(currentLocation.x, currentLocation.y+1)) {
			currentLocation.y--;

		}
		
		if (currentLocation.y != 0 && oceanMap.isOcean(currentLocation.x, currentLocation.y-1)) {
			currentLocation.y++;
		}*/
	}

	@Override
	public String getStrategy() {
		return "Vertical";
		
	}


}
