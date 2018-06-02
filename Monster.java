/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import javafx.geometry.Point2D;
 
public class Monster implements Component {
	 
	Monster monster;
		
	public Monster(Point2D point) {
		monster = new Monster(point);
		monster.setX(point.getX());
		monster.setY(point.getY());
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
	
	public void setX(double d){
		
	}
	
	public void setY(double d){
		
	}
	
	public void move(){
		 
	}
	 
 
}