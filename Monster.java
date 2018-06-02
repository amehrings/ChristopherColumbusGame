/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import javafx.geometry.Point2D;
 
public class Monster implements Component {
	OceanMap oceanMap = OceanMap.getInstance();
	Monster monster;
	Point2D currentLocation;
	boolean direction = true;
	Container currentContainer;
		
	public Monster() {
	}
	
	public Monster getMonster() {
		return monster;
	}
	
	public Container getContainer() {
		return currentContainer;
	}
	
	@Override
	public void setContainer(Container container) {
		currentContainer = container;
	}
	
	public Point2D getMonsterLocation() {
		return currentLocation;
	}
	
	public boolean containsPoint(Point2D point) {
		return (monster.containsPoint(point));
	}
	
	public void place(Point2D point){
		currentLocation = point; 
	}
	
	public void move(){
		Point2D tempPoint = new Point2D(currentLocation.getX() + 1, currentLocation.getY());
		if (getContainer().ContainsPoint(tempPoint) && oceanMap.isOcean((int)tempPoint.getX(), (int)tempPoint.getY())) {
			currentLocation = new Point2D(currentLocation.getX() +1, currentLocation.getY());
		}
	}
	 
 
}