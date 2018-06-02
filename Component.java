/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import javafx.geometry.Point2D;

public interface Component {
	public void move ();
	public void place(Point2D point);
	public void setContainer(Container container);
}