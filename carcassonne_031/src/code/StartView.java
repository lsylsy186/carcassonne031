package code;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StartView extends JPanel {
	private Game _game;
	private Image _startIcon;
	public StartView(){
		
		_startIcon = new ImageIcon("E:\\cass.jpg").getImage();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(_startIcon, 0, 0,800,800, this);
	}
	public void addGame(Game g) {
		_game = g;
		
	}
}
