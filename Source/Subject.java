/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

//Add, Remove, Notify Observers Interface for Observer pattern
public interface Subject {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
