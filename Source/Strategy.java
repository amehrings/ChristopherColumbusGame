/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

//Strategy Pattern Interface, implementing getStrategy() (returns string) and move(PirateShip pirate) (no return value)
public interface Strategy {
	public String getStrategy();
	public void move(PirateShip pirate);
}
