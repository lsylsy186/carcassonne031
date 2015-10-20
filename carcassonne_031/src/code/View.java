package code;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class View {
	private Game _game;
	private JFrame _window;
	private JButton[] _jArray = new JButton[5];
	private JPanel _panel;

	
	public View(Game g){
		String player1 = "";
		String player2 = "";
		String player3 = "";
		String player4 = "";
		String player5 = "";
		_game = g;
		_game.addView(this);
		_window = new JFrame();
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.setVisible(true);
		
		_panel = new JPanel();
		_window.add(_panel);
		_panel.setVisible(true);
		
		
		_jArray[0] = new JButton(player1);
		_jArray[1] = new JButton(player2);
		_jArray[2] = new JButton(player3);
		_jArray[3] = new JButton(player4);
		_jArray[4] = new JButton(player5);
		for(int i = 0; i < g.get_playerList().length; i++){
			String playerName = g.getPlayer(i+1);
			addPlayerList(i, playerName);	
		}
		

		
		
		_window.pack();
	}



	private void addPlayerList(int x, String playerName) {
		if(!playerName.matches("")){
		_jArray[x].setText(playerName);
		_panel.add(_jArray[x]);
		}
	}
	
}