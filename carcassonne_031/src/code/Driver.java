package code;

import java.util.ArrayList;

/**
 * The Driver initiates the program by running the command line inputs and creating the Board class.
 * 
 * 
 */
public class Driver {
	
	
	/**
	 * The main method allows the game code to be run as a Java Application. Holds a for loop which places the player names into the ArrayList,String> named players. Also
	 * creates the Board for actual gameplay.
	 * 
	 * @param args	The player names listed in the command line input
	 */
	public static ArrayList<String> players;
	public static void main(String[] args){
		StartView startView = new StartView();
		players = new ArrayList<String>();
		int a = 0;
		System.out.println("11111");
		while(a < 7){
			System.out.println("0");
			switch(a){
			case 0 : a = a + 1;break;
			case 1 : a = a - 1;
					if(startView._whenToBeginTheGame == 2){
						a = 10;
					}
					break;
			
		}
		}
		
		System.out.println("Begin the game");
		PlayerTurns pt = new PlayerTurns(players);
		pt.run();
		
		
	}
}
