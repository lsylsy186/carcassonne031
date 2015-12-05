package code;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * This class is meant to be used in place of command line inputs through the run configurations.
 * It is not utilized in the current code.
 * 
 * 
 */
public class DialogInputs {
	
	/**
	 * ArrayList<String> which will hold the player names as the String values they are entered as.
	 */
	private ArrayList<String> _players;
	
	/**
	 * When called, DialogInputs allows the user to enter the player names in the order of gameplay.
	 * Once entered the player name is stored in an ArrayList<String> which is updated with each name.
	 * The player is then asked if there are any more entries to be made: if 'yes' the while loop
	 * repeats until 'no' or 'cancel' is called.
	 */
	public DialogInputs() {
		int i = 0; //int which keeps track of number of players 
		boolean status = true; //status remains true until 'no' is called
		_players = new ArrayList<>(); //initialization of _players instance variable
		while (status && i<5) {	//runs while status is true and less than 6 players has been entered
			String input = JOptionPane.showInputDialog("Please enter player name ");
			if (JOptionPane.showConfirmDialog(null, "Are there any more players?") == 0){
				status = true;
			} else {
				status = false;
			}
			_players.add(input); //adds player name to ArrayList<>
		}
	}
	
	/**
	 *Method which can be called to get the contents of the ArrayList _players at a given index.
	 *
	 * @param i int value which references an index
	 * @return	player name in _players at index i
	 */
	public String getPlayerName(int i) {
		return _players.get(i);
	}
}
