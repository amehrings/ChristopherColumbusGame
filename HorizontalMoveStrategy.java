/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

public class HorizontalMoveStrategy implements Strategy {

	OceanMap oceanMap = OceanMap.getInstance();
	boolean direction = true;

	@Override
	public void move(PirateShip pirate) {
		if (pirate.currentLocation.x + 1 < oceanMap.getDimensions() && direction == true) {
			if (!(oceanMap.isOcean(pirate.currentLocation.x+1, pirate.currentLocation.y))) {
				direction = false;
			}
			pirate.currentLocation.x++;
		}else {
			direction = false;
		}
		
		if (pirate.currentLocation.x != 0 && direction == false) {
			if (!(oceanMap.isOcean(pirate.currentLocation.x-1, pirate.currentLocation.y))) {				
				direction = true;
			}
			pirate.currentLocation.x--;
		}else {
			direction = true;
		}
		
	}

	@Override
	public String getStrategy() {
		// TODO Auto-generated method stub
		return "Horizontal";
	}

}
