/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

//Vertical move strategy that utilizes the Strategy Pattern
public class VerticalMoveStrategy implements Strategy {
	OceanMap oceanMap = OceanMap.getInstance();
	boolean direction = true;
	
	//Moves the pirate vertically across the screen
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

	//returns string value of movement type
	@Override
	public String getStrategy() {
		return "Vertical";
		
	}


}
