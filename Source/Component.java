/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import javafx.geometry.Point2D;

//Component interface for Composite Design Pattern. Allows Component objects to move, be places, and set its container
public interface Component {
	public void move ();
	public void place(Point2D point);
	public void setContainer(Container container);
}