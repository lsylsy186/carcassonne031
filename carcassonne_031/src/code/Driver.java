package code;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Driver {
	public static void main(String args[]){
		Game g = new Game();
		g.setUp(args);
//		Tile t = new Tile();
		View v = new View(g);
		
		
}

}