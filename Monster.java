/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import javafx.geometry.Point2D;
 
public class Monster implements Component {
	 
	Monster monster;
	Point2D currentLocation;
	boolean direction = true;
		
	public Monster() {
	}
	
	public Monster getMonster() {
		return monster;
	}
	
	public Container getContainer() {
		return null;
	}
	
	public boolean containsPoint(Point2D point) {
		return (monster.containsPoint(point));
	}
	
	public void place(Point2D point){
		currentLocation = point; 
	}
	
	public void move(){
		Point2D tempPoint = new Point2D(currentLocation.getX() + 1, currentLocation.getY());
		if (getContainer().ContainsPoint(tempPoint)) {
			currentLocation = new Point2D(currentLocation.getX() +1, currentLocation.getY());
		}
	}
	 
 
}