/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Container implements Component{
	Rectangle rect = new Rectangle();
	int height;
	int width;
	Point2D topLeft;
	Point2D randPoint;
	OceanMap oceanMap = OceanMap.getInstance();

	
	ArrayList<Component> components = new ArrayList<Component>();
	
	//Container constructor
	public Container(int w) {
		height = w;
		width = w;
		rect.setHeight(height);
		rect.setWidth(width);
		rect.setStroke(Color.TRANSPARENT);
		rect.setFill(Color.TRANSPARENT);
	}
	 
	//returns true if Container object contains the point given
	public boolean ContainsPoint(Point2D point) {
		return rect.contains(point);
	}
	 
	 //adds child to component array
	public void addChild(Component comp) {
		components.add(comp);
		Random rand = new Random();
		randPoint = new Point2D((int)topLeft.getX() + rand.nextInt(width), (int)topLeft.getY() + rand.nextInt((width)));
		comp.setContainer(this);
		comp.place(randPoint);
	}
	
	//removes child from component array
	public void removeChild(Component comp) {
		components.remove(comp);
	}
	
	public Rectangle getRectangle() {
		return rect;
	}
	
	@Override
	public void move() {
		//empty for the containing class
	}

	@Override
	public void place(Point2D point2d) {
		topLeft = point2d;
		rect.setX(topLeft.getX());
		rect.setY(topLeft.getY());
	}

	@Override
	public void setContainer(Container container) {
		// Not needed for the container itself
		
	}
	 
 
 }