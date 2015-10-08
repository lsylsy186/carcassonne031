package test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

import carcassonne.Tile;

public class RotateTest {

	@Test
	public void test1() {
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('A');
		String expected = "WCCFWCFFW";
		t.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	
	@Test
	public void test2() {
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('E');
		String expected = "WCCFCCWCC";
		t.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	
	@Test
	public void test3() {
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('J');
		String expected = "FRFRRFFFF";
		t.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}
	
	@Test
	public void test4() {
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('Q');
		String expected = "FFWFFCFFW";
		t.rotate(target);
		String actual =t.toString(target);
		assertTrue("the tile rotated is" + actual,expected.equals(actual));
	}

}
