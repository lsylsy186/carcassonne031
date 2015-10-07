package data_structure;


public class Tile {
	Part T, L, R, B, M, TL, TR, BL, BR;
	boolean Shield;
	public Tile(Part TL, Part T, Part TR, Part L, Part M, 
			Part R, Part BL, Part B, Part BR, boolean Shield){
		this.T = T;
		this.L = L;
		this.R = R;
		this.B = B;
		this.M = M;
		this.TL = TL;
		this.TR = TR;
		this.BL = BL;
		this.BR = BR;
		this.Shield = Shield;
	}
	
	
} 
	
