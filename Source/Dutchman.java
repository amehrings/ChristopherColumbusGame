/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.util.Random;

/*This is the flying Dutchman class. It is a version of the PirateShip that follows Christopher Columbus
 * and can fly over islands. Uses the observer pattern, but not the strategy pattern to move.
 */

public class Dutchman extends PirateShip {
	int speed;
	Random rand = new Random();
	
	//Dutchman constructor
	public Dutchman(OceanMap oceanMap, String type) {
		super(oceanMap, type);
	}
	
	//Chases Christopher Columbus at different speeds
	public void move() {
		if (type.equals("Fast")) {
			speed = 2;
		}else if (type.equals("Slow")){
			speed = 4;
		}
		
		if (rand.nextInt(speed) == 1){
			if (currentLocation.x - ChristopherColumbusLocation.x < 0) {
				if (currentLocation.x + 1 < oceanMap.getDimensions()) {
					currentLocation.x++;
				}
			}
			else {
				if (currentLocation.x != 0) {				
					currentLocation.x--;
				}
			}
			
			if (currentLocation.y - ChristopherColumbusLocation.y < 0) {
				if (currentLocation.y + 1 < oceanMap.getDimensions()) {
					currentLocation.y++;
				}
			}
			else {
				if (currentLocation.y != 0) {
					currentLocation.y--;
				}
			} 
		}
	}
	
	//returns a String of the the pirate type
	public String getPirateType() {
		return "Dutchman";
	}
	
}