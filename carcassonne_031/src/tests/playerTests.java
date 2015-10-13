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
		String actual = g.getPlayerNumber(1);
		assertTrue("expected:" + expected + " actual: " + actual+ ".", expected.equals(actual));
	
	}

}
