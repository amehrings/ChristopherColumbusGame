
public class RegularPirateFactory extends PirateFactory {
	
	OceanMap oceanMap = OceanMap.getInstance();
	int number = oceanMap.getPirateNumber();
	
	@Override
	public PirateShip createPirateShip(String type) {
		if (type.equals("Vertical")){
			oceanMap.addPirateNumber();
			number = oceanMap.getPirateNumber();
			return new RegularPirate(oceanMap, number, "Vertical");
		}
		else if (type.equals("Horizontal")){
			oceanMap.addPirateNumber();
			number = oceanMap.getPirateNumber();
			return new PirateShip(oceanMap, number, "Horizontal");	
		} else return null;
		
	}
}