/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import java.util.LinkedList;
import java.util.List;

import java.awt.Point;

//This class is Christopher Columbus's Ship!!

public class ChristopherColumbus implements Subject {
	List<Observer> observers = new LinkedList<Observer>();
	Point currentLocation;
	OceanMap oceanMap;
	boolean[][] islandMap;
	
	//ChristopherColumbus constructor
	public ChristopherColumbus(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.getChristopherColumbusLocation();
	}
	
	//returns the ChristopherColumbus location as a Point
	public Point getChristopherColumbusLocation() {
		return currentLocation;
	}
	
	//moves the ChristopherColumbus east if there is no island there
	public void goEast() {
		if (currentLocation.x <= oceanMap.getDimensions() - 1 
				&& oceanMap.isOcean(currentLocation.x+1, currentLocation.y) 
				&& currentLocation.x+1 <= oceanMap.getDimensions()-1) {
			currentLocation.x++;
			//setChanged();
			notifyObservers();
		}
		
	}
	
	//moves the ChristopherColumbus west if there is no island there
	public void goWest() {
		if (currentLocation.x <= oceanMap.getDimensions() - 1 
				&& oceanMap.isOcean(currentLocation.x-1, currentLocation.y)) {
			currentLocation.x--;
			//setChanged();
			notifyObservers();
		}
	}
	
	//moves the ChristopherColumbus north if there is no island there
	public void goNorth() {
		if (currentLocation.y <= oceanMap.getDimensions() - 1 
				&& oceanMap.isOcean(currentLocation.x, currentLocation.y-1)) {
			currentLocation.y--;
			//setChanged();
			notifyObservers();
		}
	}
	
	//moves the ChristopherColumbus south if there is no island there
	public void goSouth() {
		if (currentLocation.y <= oceanMap.getDimensions() - 1 
				&& oceanMap.isOcean(currentLocation.x, currentLocation.y+1) 
				&& currentLocation.y+1 <= oceanMap.getDimensions()-1) {
			currentLocation.y++;
			//setChanged();
			notifyObservers();
		}
	}

	//adds an observer to the observer linked list
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	//removes an observer from the observer linked list
	@Override
	public void removeObserver(Observer o) {
		if(observers.contains(o))
			observers.remove(o);
		
	}

	//notifies the observers of a change in the ChristopherColumbus's state
	@Override
	public void notifyObservers() {
		for (Observer pirateObserver: observers)
			pirateObserver.update(this);
		
	}
	
	

	
}
