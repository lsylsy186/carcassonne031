package data_structure;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
	
	Part R = new Part('R');
	Part W = new Part('W');
	Part C = new Part('C');
	Part F = new Part('F');
	Part M = new Part('M');
	Tile tA = new Tile(F, F, F, F, M, F, F, R, F, false);
	Tile tB = new Tile(F, F, F, F, M, F, F, F, F, false);
	Tile tC = new Tile(C, C, C, C, C, C, C, C, C, true);
	Tile tD = new Tile(W, C, W, R, R, R, F, F, F, false);
	Tile tE = new Tile(W, C, W, F, F, F, F, F, F, false);
	Tile tF = new Tile(W, F, W, C, C, C, W, F, W, true);
	Tile tG = new Tile(W, F, W, C, C, C, W, F, W, false);
	Tile tH = new Tile(W, F, W, C, F, C, W, F, W, false);
	Tile tI = new Tile(W, C, W, C, F, F, W, F, F, false);
	Tile tJ = new Tile(W, C, W, F, R, R, F, R, F, false);
	Tile tK = new Tile(W, C, W, R, R, F, F, R, F, false);
	Tile tL = new Tile(W, C, W, R, R, R, F, R, F, false);
	Tile tM = new Tile (C, C, W, C, W, F, W, F, F, true);
	Tile tN = new Tile (C, C, W, C, W, F, W, F, F, false);
	Tile tO = new Tile (C, C, W, C, W, R, W, R, F, true);
	Tile tP = new Tile (C, C, W, C, W, R, W, R, F, false);
	Tile tQ = new Tile (C, C, C, C, C, C, W, F, W, true);
	Tile tR = new Tile (C, C, C, C, C, C, W, F, W, false);
	Tile tS = new Tile (C, C, C, C, C, C, W, R, W, true);
	Tile tT = new Tile (C, C, C, C, C, C, W, R, W, false);
	Tile tU = new Tile (F, F, F, R, R, R, F, F, F, false);
	Tile tV = new Tile (F, F, F, R, R, F, F, R, F, false);
	Tile tW = new Tile (F, F, F, R, R, R, F, R, F, false);
	Tile tX = new Tile (F, R, F, R, R, R, F, R, F, false);
	Tile[] tileArray = new Tile[]{tA, tB, tC, tD, tE, tF, tG, tH, tI, tJ, tK, tL, tM,
			tN, tO, tP, tQ, tR, tS, tT, tU, tV, tW, tX};
	ArrayList<Tile> allTiles =new ArrayList<Tile>();
	
	
	
	
	public void create(){
		allTiles.addAll(Arrays.asList(tileArray));
			
		}
	
	public char getPart(){
		
		char ch;
		if(tA.TL.equals(F)){
		ch = 'F';
		
		}
		else{
			ch = 'n';
		}
		
		return ch;
	
		
	}
	
}
