package test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

import carcassonne.Game;
import carcassonne.Tile;

public class CompatileTest {

	@Test
	public void test() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('J');
		boolean actual =g.checkPlacement(51,51, target);
		boolean expected = true;
		assertTrue("expected:" +expected+ ", actual" + actual,expected==actual);
		
	}

}
