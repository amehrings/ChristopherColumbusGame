/* Austin Paul
 * Assignment 2
 * SE350
 */

public interface Subject {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
