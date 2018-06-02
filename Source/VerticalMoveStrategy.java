/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

public class VerticalMoveStrategy implements Strategy {
	OceanMap oceanMap = OceanMap.getInstance();
	boolean direction = true;
	
	@Override
	public void move(PirateShip pirate) {
		if (pirate.currentLocation.y + 1 < oceanMap.getDimensions() && direction == true) {
			if (!(oceanMap.isOcean(pirate.currentLocation.x, pirate.currentLocation.y+1))) {
				direction = false;
			}
			pirate.currentLocation.y++;
		}else {
			direction = false;
		}
		
		if (pirate.currentLocation.y != 0 && direction == false) {
			if (!(oceanMap.isOcean(pirate.currentLocation.x, pirate.currentLocation.y-1))) {				
				direction = true;
			}
			pirate.currentLocation.y--;
		}else {
			direction = true;
		}
	}

	@Override
	public String getStrategy() {
		return "Vertical";
		
	}


}
