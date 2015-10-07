package data_structure;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void constructorTest() { //checks to see if game constructor is working 
		Game game = new Game();
		game.create();
		boolean expected = false; 
		boolean actual= game.allTiles.isEmpty();
		assertTrue("actual returns "+ actual+ ".", expected == actual);
	}
	
	@org.junit.Test
	public void partTest() { //checks to see if parts constructor is working 
		Game game = new Game();
		game.create();
		Part R = new Part('R');
		Part W = new Part('W');
		Part C = new Part('C');
		Part F = new Part('F');
		Part M = new Part('M');
		Tile tA = new Tile(F, F, F, F, M, F, F, R, F, false);
		
		boolean expected = true ; 
		boolean actual= tA.TL.equals(F);
		assertTrue("actual returns "+ actual+ ".", expected == actual);
	}
	

	@org.junit.Test
	public void checkerTest() { //checker proof of concept test. 
		Game game = new Game();
		game.create();
		Part R = new Part('R');
		Part W = new Part('W');
		Part C = new Part('C');
		Part F = new Part('F');
		Part M = new Part('M');
		Tile tA = new Tile(F, F, F, F, M, F, F, R, F, false);
		
		char expected = 'F' ; 
		char actual= game.getPart();
		assertTrue("actual returns "+ actual+ ".", expected == actual);
	}
}
