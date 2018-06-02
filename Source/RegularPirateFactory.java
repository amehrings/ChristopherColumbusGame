/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

//concrete class for pirate factory pattern
public class RegularPirateFactory extends PirateFactory {
	
	OceanMap oceanMap = OceanMap.getInstance();

	//create either vertical or horizontal pirate ship, returns pirate ship
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