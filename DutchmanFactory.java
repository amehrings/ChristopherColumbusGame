

public class DutchmanFactory extends PirateFactory {
	
	OceanMap oceanMap = OceanMap.getInstance();
	int number = oceanMap.getPirateNumber();
	
	@Override
	public PirateShip createPirateShip(String type) {
		if (type.equals("Fast")){
			oceanMap.addPirateNumber();
			number = oceanMap.getPirateNumber();
			return new Dutchman(oceanMap, number, "Fast");
		}
		else if (type.equals("Slow")){
			oceanMap.addPirateNumber();
			number = oceanMap.getPirateNumber();
			return new Dutchman(oceanMap, number, "Slow");	
		} else return null;
		
	}
}