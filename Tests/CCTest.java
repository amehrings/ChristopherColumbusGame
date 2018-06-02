/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import org.junit.Test;

public class CCTest{
	
	List<Observer> observers = new LinkedList<Observer>();
	OceanMap oceanMap = OceanMap.getInstance();
	
	@Test
	public void testGetColumbusLocation(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		assertTrue(cc.getChristopherColumbusLocation().equals(oceanMap.ChristopherColumbusLocation));
	}
	
	@Test
	public void testGoEast(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goEast();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX()+1 && cc.getChristopherColumbusLocation().getY() == testPoint.getY());
	}
	
	@Test
	public void testGoWest(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goWest();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX()-1 && cc.getChristopherColumbusLocation().getY() == testPoint.getY());
	}

	@Test
	public void testGoNorth(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goNorth();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX() && cc.getChristopherColumbusLocation().getY() == testPoint.getY()-1);
	}
	
	@Test
	public void testGoSouth(){
		ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point testPoint = new Point((int) oceanMap.getChristopherColumbusLocation().getX(), (int) oceanMap.getChristopherColumbusLocation().getY());
		cc.goSouth();
		assertTrue(cc.getChristopherColumbusLocation().getX() == testPoint.getX() && cc.getChristopherColumbusLocation().getY() == testPoint.getY()+1);
	}
	
	@Test
	public void testAddObserver() {
		Dutchman d = new Dutchman(oceanMap, "Slow");
		observers.add(d);
		assertTrue(observers.contains(d));
	}

	@Test
	public void testRemoveObserver() {
		Dutchman d = new Dutchman(oceanMap, "Slow");
		observers.add(d);		
		observers.remove(d);
		assertTrue(!observers.contains(d));	
	}
}