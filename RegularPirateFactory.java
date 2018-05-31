
public class RegularPirateFactory extends PirateFactory {
	
	OceanMap oceanMap = OceanMap.getInstance();

	
	@Override
	public PirateShip createPirateShip(String type) {
		if (type.equals("Vertical")){
			
			return new RegularPirate(oceanMap, "Vertical");
		}
		else if (type.equals("Horizontal")){
			return new PirateShip(oceanMap, "Horizontal");	
		} else return null;
		
	}
}