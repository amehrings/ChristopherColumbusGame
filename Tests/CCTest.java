/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import static org.junit.Assert.*;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

//Christopher Columbus Ship tests for location, moving 1 coordinate in every direction, and adding/removing observers to list
public class CCTest{
	
	List<Observer> observers = new LinkedList<Observer>();
	OceanMap oceanMap = OceanMap.getInstance();
	
	@Test
	//tests if Columbus location is the same as the oceanMap Columbus Location, asserts True
	public void testGetColumbusLocation(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		assertTrue(cc.getChristopherColumbusLocation().equals(oceanMap.ChristopherColumbusLocation));
	}
	
	@Test
	//creates testPoint given old coordinates and tests where it is expected to go + 1 X coordinate, asserts True
	public void testGoEast(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goEast();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX()+1 && cc.getChristopherColumbusLocation().getY() == testPoint.getY());
	}
	
	@Test
	//creates testPoint given old coordinates and tests where it is expected to go -1 X coordinate, asserts True
	public void testGoWest(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goWest();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX()-1 && cc.getChristopherColumbusLocation().getY() == testPoint.getY());
	}

	@Test
	//creates testPoint given old coordinates and tests where it is expected to go -1 Y coordinate, asserts True
	public void testGoNorth(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goNorth();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX() && cc.getChristopherColumbusLocation().getY() == testPoint.getY()-1);
	}
	
	@Test
	//creates testPoint given old coordinates and tests where it is expected to go + 1 Y coordinate, asserts True
	public void testGoSouth(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goSouth();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX() && cc.getChristopherColumbusLocation().getY() == testPoint.getY()+1);
	}
	
	@Test
	//tests if observer is added to observer list, asserts True
	public void testAddObserver() {
		Dutchman d = new Dutchman(oceanMap, "Slow");
		observers.add(d);
		assertTrue(observers.contains(d));
	}

	@Test
	//tests if observer is removed from observer list, asserts True
	public void testRemoveObserver() {
		Dutchman d = new Dutchman(oceanMap, "Slow");
		observers.add(d);		
		observers.remove(d);
		assertTrue(!observers.contains(d));	
	}
}