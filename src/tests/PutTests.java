package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

import code.Game;
import code.Tile;

public class PutTests {

	@Test
	public void test() {
		Game g = new Game();
		g.newGame();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('J');
		boolean actual =g.putTile(30,30, target);
		boolean expected = false;
		assertTrue("expected:" +expected+ ", actual" + actual,expected==actual);
		
	}
	
	@Test
	public void test01() {
		Game g = new Game();
		g.newGame();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('G');
		boolean actual =g.putTile(51,50, target);
		boolean expected = false;
		assertTrue("expected:" +expected+ ", actual" + actual,expected==actual);
		
	}
	
	@Test
	public void test02() {
		Game g = new Game();
		g.newGame();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('V');
		boolean actual =g.putTile(51,50, target);
		boolean expected = true;
		assertTrue("expected:" +expected+ ", actual" + actual,expected==actual);
		
	}
	@Test
	public void test03() {
		Game g = new Game();
		g.newGame();
		Tile t = new Tile();
		HashMap<Point,Object> target = t.getTile('B');
		boolean actual =g.putTile(50,49, target);
		boolean expected = true;
		assertTrue("expected:" +expected+ ", actual" + actual,expected==actual);
		
	}
	@Test
	public void test04() {
		Game g = new Game();
		g.newGame();
		Tile t = new Tile();
		HashMap<Point,Object> target1 = t.getTile('V');
		HashMap<Point,Object> target2 = t.getTile('U');
		t.rotate(target2);
		g.putTile(51,50, target1);
		boolean actual =g.putTile(51,49, target2);
		boolean expected = true;
		assertTrue("expected:" +expected+ ", actual" + actual,expected==actual);
		
	}
}
