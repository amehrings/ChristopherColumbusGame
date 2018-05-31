public class HorizontalMoveStrategy implements Strategy {

	OceanMap oceanMap = OceanMap.getInstance();
	
	@Override
	public void move(PirateShip pirate) {
		pirate.currentLocation.x++;
		
		/*if (currentLocation.x + 1 < oceanMap.getDimensions() && oceanMap.isOcean(currentLocation.x+1, currentLocation.y) ) {
			currentLocation.x++;
		}
		if (currentLocation.x != 0 && oceanMap.isOcean(currentLocation.x-1, currentLocation.y)) {				
			currentLocation.x--;
		}*/
	}

	@Override
	public String getStrategy() {
		// TODO Auto-generated method stub
		return "Horizontal";
	}

}
