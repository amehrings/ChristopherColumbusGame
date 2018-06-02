/* Austin Paul and Aaron Mehrings
 * Final Project
 * SE350
 */

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.geometry.Point2D;

public class MonsterTest {

	@Test
	public void testGetContainer() {
		Container container = new Container(3);
		Monster monster = new Monster();
		container.addChild(monster);
		container.place(new Point2D(0, 0));
		assertEquals(monster.getContainer(), container);
	}

	@Test
	public void testGetMonsterLocation() {
		Container container = new Container(3);
		Monster monster = new Monster();
		container.addChild(monster);
		container.place(new Point2D(0, 0));
		assertTrue(container.ContainsPoint(monster.getMonsterLocation()));
	}
	
	@Test
	public void testMove() {
		Container container = new Container(3);
		Monster monster = new Monster();
		container.addChild(monster);
		container.place(new Point2D(0, 0));
		monster.move();
		assertTrue(container.ContainsPoint(monster.getMonsterLocation()));
	}
}
