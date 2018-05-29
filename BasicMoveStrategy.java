import java.awt.Point;

public class BasicMoveStrategy implements Strategy {
	Point currentLocation;
	OceanMap oceanMap = OceanMap.getInstance();
	Point ChristopherColumbusLocation;
	
	@Override
	public void movePirateShip() {
		
	}

	@Override
	public String getStrategy() {
		return "BasicMoveStrategy";
		
	}


}
