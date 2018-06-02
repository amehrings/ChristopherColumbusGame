/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

//Concrete Dutchman factory that creates Dutchman Pirates

public class DutchmanFactory extends PirateFactory {
	
	OceanMap oceanMap = OceanMap.getInstance();
	
	//returns a Dutchman of type fast or Slow, as a PirateShip
	
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