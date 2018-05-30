

public class DutchmanFactory extends PirateFactory {
	
	OceanMap oceanMap = OceanMap.getInstance();
	int number = oceanMap.getPirateNumber();
	
	@Override
	public PirateShip createPirateShip(String type) {
		if (type.equals("Vertical")){
			oceanMap.addPirateNumber();
			number = oceanMap.getPirateNumber();
			return new RegularPirate(oceanMap, number);
		}
		else if (type.equals("Horizontal")){
			oceanMap.addPirateNumber();
			number = oceanMap.getPirateNumber();
			return new Dutchman(oceanMap, number);	
		} else return null;
		
	}
}