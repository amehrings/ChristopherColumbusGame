import java.awt.Point;
import java.util.Random;

/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

public class Dutchman extends PirateShip {
	int speed;
	Random rand = new Random();
	
	public Dutchman(OceanMap oceanMap, int n, String type) {
		super(oceanMap, n, type);
	}
	
	public void move() {
		if (type.equals("Fast")) {
			speed = 2;
		}else if (type.equals("Slow")){
			speed = 4;
		}
		
		if (rand.nextInt(speed) == 1){
			if (currentLocation.x - ChristopherColumbusLocation.x < 0) {
				if (currentLocation.x + 1 < oceanMap.getDimensions() 
						&& oceanMap.isOcean(currentLocation.x+1, currentLocation.y) ) {
					currentLocation.x++;
				}
			}
			else {
				if (currentLocation.x != 0 
						&& oceanMap.isOcean(currentLocation.x-1, currentLocation.y)) {				
					currentLocation.x--;
				}
			}
			
			if (currentLocation.y - ChristopherColumbusLocation.y < 0) {
				if (currentLocation.y + 1 < oceanMap.getDimensions()
						&& oceanMap.isOcean(currentLocation.x, currentLocation.y+1)) {
					currentLocation.y++;
				}
			}
			else {
				if (currentLocation.y != 0
						&& oceanMap.isOcean(currentLocation.x, currentLocation.y-1)) {
					currentLocation.y--;
				}
			} 
		}
	}
	
	public String getPirateType() {
		return "Dutchman";
	}
	
}