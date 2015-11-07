package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

import code.Game;
import code.Tile;

public class RotateTest {
//after fixing errors in Tile constructor, the tests need to be rewritten.
	@Test
	public void test1() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('M');
		String expected = "WCCFWCFFW";
		g.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	
	@Test
	public void test2() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('Q');
		String expected = "WCCFCCWCC";
		g.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	
	@Test
	public void test3() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('V');
		String expected = "FRFRRFFFF";
		g.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	
	@Test
	public void test4() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('E');
		String expected = "FFWFFCFFW";
		g.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	
	@Test
	public void getPositionAtPointTest() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('Q');
		char expected = 'W';
		char actual = t.getPositionAtPoint(target, 0, 2);
		assertTrue("expected:" +expected+ ", actual" + actual + actual,expected == actual);
	}
	
	
	@Test
	public void testU() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('U');
		String expected = "FFFRRRFFF";
		g.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	

}
