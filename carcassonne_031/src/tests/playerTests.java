package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Game;

public class playerTests {

	@Test
	public void test() {
		Game g = new Game();
		String[] list = new String[5];
		list[0] = "jimmy";
		list[1] = "Johnny";
		list[2] = "Jack";		
		g.setUp(list);
		String expected = "jimmy";
		String actual = g.getPlayer(1);
		assertTrue("expected:" + expected + " actual: " + actual+ ".", expected.equals(actual));
	
	}
	
	@Test
	public void test01() {
		Game g = new Game();
		String[] list = new String[5];
		list[0] = "jimmy";
		list[1] = "Johnny";
		list[2] = "Jack";		
		g.setUp(list);
		int expected = 3;
		int  actual = g.get_playerNumber();
		assertTrue("expected:" + expected + " actual: " + actual+ ".", expected == actual);
	}

}
