/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

//Horizontal move strategy that utilizes the Strategy Pattern
public class HorizontalMoveStrategy implements Strategy {

	OceanMap oceanMap = OceanMap.getInstance();
	boolean direction = true;

	//Moves the pirate horizontally across the screen
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

	//returns a String of the movement type
	
	@Override
	public String getStrategy() {
		return "Horizontal";
	}

}
