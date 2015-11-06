package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

import code.Game;
import code.Tile;

public class CheckPutMeepleTests {

	
	//getting put tile working again before 
	@Test
	public void testPut() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('J');
		//putting J tile above
		HashMap<Point,Object> tile2 = t.getTile('U');
		g.putTile(50, 49, tile1);
		boolean placement = g.putTile(50, 51, tile2);
		boolean expected = true;
		boolean actual = placement;
		assertTrue("", expected==actual);
		
	}
	
	//testing to see if the _gameBoard is working
		@Test
		public void testPutGameBoard() {
			Game g = new Game();
			Tile t = new Tile();
			HashMap<Point,Object> tile1 = t.getTile('J');
			//putting J tile above
			HashMap<Point,Object> tile2 = t.getTile('U');
			g.putTile(50, 49, tile1);
			g.putTile(50, 51, tile2);
			HashMap<Point, HashMap<Point, Object>> gameBoard = g.get_gameBoard();
			
			boolean expected = true;
			boolean actual = gameBoard.containsKey(new Point(50,49));
			assertTrue("", expected==actual);
			
		}
		
		@Test
		public void putMeepleTest() {
			Game g = new Game();
			Tile t = new Tile();
			HashMap<Point,Object> target1 = t.getTile('E');
			g.putTile(49,50, target1);
			g.forcePutMeep(0,0 , target1);
			char expected = 'w';
			char actual = (char) target1.get(new Point(0,0));
			assertTrue("expected:" +expected+ ", actual" + actual,expected==actual);
		}	

	
	@Test
	public void testMeeple1() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('J');
		HashMap<Point,Object> tile2 = t.getTile('U');
		//putting J tile above
		g.forcePutMeep(1, 2, tile1);
		g.putTile(50, 49, tile1);
		g.putTile(50,51, tile2);
		
		//System.out.println( tile1.get(new Point(1,2)));
		HashMap<Point, HashMap<Point, Object>> board = g.get_gameBoard();
	
		HashMap<Point, Object> tile3 = board.get(new Point(50,49));
		char meeple =  (char) tile3.get(new Point(1,2));
		System.out.println("game board says point is " +meeple);	
		boolean expected = false;
		boolean actual = g.putMeeple(50, 51, 1, 1);
		assertTrue("expected is " + expected+". and actual is "+actual, expected==actual);
		
	}
	

	@Test
	public void testMeeple2() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('J');
		HashMap<Point,Object> tile2 = t.getTile('U');
		//putting J tile above
		g.putTile(50, 49, tile1);
		g.putTile(50,51, tile2);
//		g.putMeep(1, 2, tile1);
		boolean expected = true;
		boolean actual = g.putMeeple(50, 51, 1, 1);
		assertTrue("expected is " + expected+". and actual is "+actual , expected==actual);
		
	}
	
	//starting tests for the wall
	

	@Test
	public void testMeeple3() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('O');
		g.putTile(50, 49, tile1);
		
		g.forcePutMeep(0, 0, tile1);
		boolean expected = true;
		boolean actual = g.putMeeple(50, 50, 2,1);
		assertTrue("expected is " + expected+". and actual is "+actual , expected==actual);
		
	}
	

	@Test
	public void testMeeple4() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('O');
		HashMap<Point,Object> tile2 = t.getTile('T');
		tile1 = g.forcePutMeep(0, 0, tile1);
		g.putTile(50, 49, tile1);
		g.putTile(49, 49, tile2);
		
		boolean expected = false;
		boolean actual = g.putMeeple(49, 49, 1,1);
		assertTrue("expected is " + expected+". and actual is "+actual , expected==actual);
	}
	

	@Test
	public void testMeeple5() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('U');
		HashMap<Point,Object> tile2 = t.getTile('I');
		HashMap<Point,Object> tile3 = t.getTile('O');
		g.putTile(50, 49, tile1);
		g.putTile(51, 49, tile2);
		g.putTile(51, 50, tile3);
		g.forcePutMeep(2, 1, tile2);
		boolean expected = true;
		boolean actual = g.putMeeple(51, 50, 0,0);
		assertTrue("expected is " + expected+". and actual is "+actual , expected==actual);
	}
	
	
	//begin tests for field
	@Test
	public void testMeeple6() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('S');
		HashMap<Point, Object> tileM = g.forcePutMeep(0, 2, tile1);
		g.putTile(50, 49, tileM);		
		boolean expected = false;
		boolean actual = g.putMeeple(50, 50, 0,0);
		assertTrue("expected is " + expected+". and actual is "+actual , expected==actual);
	}
	
	@Test
	public void testMeeple7() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('S');
		HashMap<Point, Object> tileM = g.forcePutMeep(0, 2, tile1);
		g.putTile(50, 49, tileM);		
		boolean expected = true;
		boolean actual = g.putMeeple(50, 50, 2,0);
		assertTrue("expected is " + expected+". and actual is "+actual , expected==actual);
	}
	
	//testing to make sure Strings are corrct and that the tile is on the gameboard
	
	@Test
	public void testMeeple8() {
		Game g = new Game();
		Tile t = new Tile();
		HashMap<Point,Object> tile1 = t.getTile('S');
		HashMap<Point, Object> tileM = g.forcePutMeep(0, 2, tile1);
		g.putTile(50, 49, tileM);
		g.putMeeple(50, 50, 2,0);
		HashMap<Point, HashMap<Point, Object>> gb = g.get_gameBoard();
		HashMap<Point, Object> target = gb.get(new Point(50,50));
		String expected = "FRwFRCFRW";
		String actual = t.toString(target);
		assertTrue("expected is " + expected+". and actual is "+actual , expected.equals(actual));
	}
}
