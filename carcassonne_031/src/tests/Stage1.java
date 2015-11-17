package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;
import code.Tile;
import code.View;

public class Stage1 {
   
    private Board _b;
    private View _view;
   
    public Stage1() {
        ArrayList<String> players = new ArrayList<String>();
        players.add("Katie");
        players.add("Maggie");
        players.add("Mirko");
        players.add("Vineet");
        players.add("Carl");
        _b = new Board(players);
        _view = new View(_b);
        _b.setView(_view);
    }
    /*########################################
    ########tests for methods in Board class
    ########################################*/
   
    //(1) boolean placeTile():
    @Test
    public void test00() {
        //to test placing a tile on the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"city", "city", "city"};
        String[] d = {"field", "road", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 72;
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+"actual: "+actual, expected == actual);
    }
   
    @Test
    public void test01() {
        //to test placing a matching tile on the space to the right of the center tile and then adding a tile on top of the previously added tile.
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"city", "city", "city"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 73;
        int y = 72;
        _b.placeTile(t, x, y);
        String[] e = {"field", "road", "field"};
        String[] f = {"field", "field", "field"};
        String[] g = {"field", "road", "field"};
        String[] h = {"city", "city", "city"};
        Tile t2 = new Tile(e,f,g,h, null, false, null, 9);
        boolean expected = false;
        boolean actual = _b.placeTile(t2, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
   
    @Test
    public void test05() {
        //to test adding a matching tile to the space on the right of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"city", "city", "city"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
   
    @Test
    public void test02() {
        //to test placing a tile not adjacent to any other placed tiles
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"city", "city", "city"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 80;
        int y = 61;
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
   
    @Test
    public void test03() {
        //to test placing a non-matching tile on the space on the right of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"field", "field", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }

    @Test
    public void test04() {
        //to test rotating a tile once and placing it to the right of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"city", "city", "city"};
        String[] d = {"field", "field", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        int i = 1;
        t.rotate(i);
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test09() {
        //to test rotating a tile once and placing it to the bottom of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"city", "city", "city"};
        String[] d = {"field", "field", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 71;
        int y = 70;
        int i = 1;
        t.rotate(i);
        boolean expected = true;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test06() {
        //to test rotating a tile twice times and placing it to the right of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"city", "city", "city"};
        String[] d = {"field", "field", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        int i = 2;
        t.rotate(i);
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test07() {
        //to test rotating a tile three times and placing it to the right of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"city", "city", "city"};
        String[] d = {"field", "field", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        int i = 3;
        t.rotate(i);
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test08() {
        //to test rotating a tile four times (frice?) and placing it to the right of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"city", "city", "city"};
        String[] d = {"field", "field", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        int i = 4;
        t.rotate(i);
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test10() {
        //to test rotating a tile five times and placing it to the right of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"city", "city", "city"};
        String[] d = {"field", "field", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        int i = 5;
        t.rotate(i);
        boolean expected = false;
        boolean actual = _b.placeTile(t, x, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test11() {
        //to test placing a matching tile on the space to the right of the center tile and then adding a non-matching tile to the right
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"city", "city", "city"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        _b.placeTile(t, x, y);
        boolean expected = false;
        boolean actual = _b.placeTile(t, x+1, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test12() {
        //to test placing a matching tile on the space to the right of the center tile and then adding a matching tile to the right
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"city", "city", "city"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        _b.placeTile(t, x, y);
        t.rotate(2);
        boolean expected = false;
        boolean actual = _b.placeTile(t, x+1, y);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test13() {
        //to test placing a tile on a kitty corner of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"city", "city", "city"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        boolean expected = false;
        boolean actual = _b.placeTile(t, 70, 70);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    @Test
    public void test14() {
        //to test placing a matching tile on the bottom of the center tile
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"city", "city", "city"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        boolean expected = false;
        boolean actual = _b.placeTile(t, 71, 70);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
   
    //(2) Tile pickTile() :
    @Test
    public void test15() {
        //to test the pickTile method by first calling it on the instance of Board
        //and then calling the 'getFollower(int)' on the picked Tile.
        Tile t = _b.pickTile();
        int expected = 8;
        int actual = t.getFollower(8);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
   
    //(3) boolean tilePlaced() :
    @Test
    public void test16() {
        //to test adding a matching tile to the space on the right of the center tile
        //and then test the tilePlaced method
        String[] a = {"field", "road", "field"};
        String[] b = {"field", "field", "field"};
        String[] c = {"field", "road", "field"};
        String[] d = {"field", "road", "field"};
        Tile t = new Tile(a,b,c,d, null, false, null, 9);
        int x = 72;
        int y = 71;
        _b.placeTile(t, x, y);
        boolean expected = true;
        boolean actual = _b.tilePlaced();
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
   
    //(4) int getTileList() :
    @Test
    public void test17() {
        //to test the getTileList method
        int expected = 70;
        int actual = _b.getTileList();
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
   
    //(5) int placeFollower(int i) :
    @Test
    public void test18() {
        //once a player, say player 0 for example,
    	//places a follower for the first time, his follower count will be
    	//reduced from 7 to 6. This is what we do here 
    	//to test the placeFollower method: 
        int expected = 6;
        int actual = _b.placeFollower(0);
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }
    
  //(6) int followerOnTile(int i) :
  //this method has only the getFollower(int i) method, which has
  //already been tested in test15.
    
  //(5) int getHash(String s) :
    @Test
    public void test19() {
        //Once the view is created and before the first player's turn,
    	//the 'value' associated with each 'key' (key = player number)
    	//in the Meeple HashMAp should be 7 (which is the number of
    	//followers at the start of the game. This is what we do here 
    	//to test the getHash method: 
        int expected = 7;
        int actual = _b.getHash("Katie");
        assertTrue("expected: "+expected+", actual: "+actual, expected == actual);
    }  
    
    /*########################################
    ########tests for methods in Tile class
    ########################################*/
    //all methods in the Tile class has already been tested
    //in the above tests for the Board class
    
    /*#############################################
    ########tests for methods in PlayerTurns class
    #############################################*/
    
}