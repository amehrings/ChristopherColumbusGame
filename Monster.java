/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.util.Random;

import javafx.geometry.Point2D;
 
public class Monster implements Component {
	OceanMap oceanMap = OceanMap.getInstance();
	Monster monster;
	Point2D currentLocation;
	boolean atRightEdge = false;
	boolean atLeftEdge = true;
	boolean atTopEdge = true;
	boolean atBottomEdge = true;
	Container currentContainer;
	Random rand = new Random();
	int res;
	
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
	
	//randomly move within bounds of container
	public void move(){
		Point2D tempPointEast = new Point2D(currentLocation.getX() + 1, currentLocation.getY());
		Point2D tempPointWest = new Point2D(currentLocation.getX()-1, currentLocation.getY());
		Point2D tempPointNorth = new Point2D(currentLocation.getX(), currentLocation.getY()+1);
		Point2D tempPointSouth = new Point2D(currentLocation.getX(), currentLocation.getY()-1);
		
		res = rand.nextInt(4);
		switch(res){
		case 0:
			if (getContainer().ContainsPoint(tempPointEast) && oceanMap.isOcean((int)tempPointEast.getX(), (int)tempPointEast.getY())) {
				currentLocation = new Point2D(currentLocation.getX() +1, currentLocation.getY());
			}break;
		case 1:
			if (getContainer().ContainsPoint(tempPointWest) && oceanMap.isOcean((int)tempPointWest.getX(), (int)tempPointWest.getY())) {
				currentLocation = new Point2D(currentLocation.getX()-1, currentLocation.getY());
			}break;
		case 2:
			if (getContainer().ContainsPoint(tempPointNorth) && oceanMap.isOcean((int)tempPointNorth.getX(), (int)tempPointNorth.getY())) {
				currentLocation = new Point2D(currentLocation.getX(), currentLocation.getY()+1);
			}break;
		case 3:
			if (getContainer().ContainsPoint(tempPointSouth) && oceanMap.isOcean((int)tempPointSouth.getX(), (int)tempPointSouth.getY())) {
				currentLocation = new Point2D(currentLocation.getX(), currentLocation.getY()-1);
			}break;
		}
	}
	 
 
}