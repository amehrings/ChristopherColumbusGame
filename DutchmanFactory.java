

public class DutchmanFactory extends PirateFactory {
	
	OceanMap oceanMap = OceanMap.getInstance();
	
	@Override
	public PirateShip createPirateShip(String type) {
		if (type.equals("Fast")){
			return new Dutchman(oceanMap, "Fast");
		}
		else if (type.equals("Slow")){
			return new Dutchman(oceanMap, "Slow");	
		} else return null;
		
	}
}