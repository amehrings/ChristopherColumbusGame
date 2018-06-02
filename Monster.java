/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

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
		
		//move East
		Point2D tempPointEast = new Point2D(currentLocation.getX() + 1, currentLocation.getY());
		if(!atLeftEdge){
			if (getContainer().ContainsPoint(tempPointEast) && oceanMap.isOcean((int)tempPointEast.getX(), (int)tempPointEast.getY())) {
				currentLocation = new Point2D(currentLocation.getX() +1, currentLocation.getY());
			}
			
			else if(!(getContainer().ContainsPoint(tempPointEast) && oceanMap.isOcean((int)tempPointEast.getX(), (int)tempPointEast.getY()))){
				atLeftEdge = true;
				atBottomEdge = false;
			}
		}
		
		//move West
		Point2D tempPointWest = new Point2D(currentLocation.getX()-1, currentLocation.getY());
		if(!atRightEdge){
			if (getContainer().ContainsPoint(tempPointWest) && oceanMap.isOcean((int)tempPointWest.getX(), (int)tempPointWest.getY())) {
				currentLocation = new Point2D(currentLocation.getX()-1, currentLocation.getY());
			}
			
			else if(!(getContainer().ContainsPoint(tempPointWest) && oceanMap.isOcean((int)tempPointWest.getX(), (int)tempPointWest.getY()))){
				atRightEdge = true;
				atTopEdge = false;
			}
		}
		
		//move North
		Point2D tempPointNorth = new Point2D(currentLocation.getX(), currentLocation.getY()+1);
		if(!atBottomEdge){
			if (getContainer().ContainsPoint(tempPointNorth) && oceanMap.isOcean((int)tempPointNorth.getX(), (int)tempPointNorth.getY())) {
				currentLocation = new Point2D(currentLocation.getX(), currentLocation.getY()+1);
			}
			
			else if(!(getContainer().ContainsPoint(tempPointNorth) && oceanMap.isOcean((int)tempPointNorth.getX(), (int)tempPointNorth.getY()))){
				atBottomEdge = true;
				atRightEdge = false;
			}
		}
		
		//move South
		Point2D tempPointSouth = new Point2D(currentLocation.getX(), currentLocation.getY()-1);
		if(!atTopEdge){
			if (getContainer().ContainsPoint(tempPointSouth) && oceanMap.isOcean((int)tempPointSouth.getX(), (int)tempPointSouth.getY())) {
				currentLocation = new Point2D(currentLocation.getX(), currentLocation.getY()-1);
			}
			
			else if(!(getContainer().ContainsPoint(tempPointSouth) && oceanMap.isOcean((int)tempPointSouth.getX(), (int)tempPointSouth.getY()))){
				atTopEdge = true;
				atLeftEdge = false;
			}
		}
	}
	 
 
}