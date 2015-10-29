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
		Tile t = new Tile();
		
		
		
		g.setUp(args);
		PlayerButtonView v = new PlayerButtonView(g);
		JButton _nextPlayer; 
		_nextPlayer = new JButton("OK!");
		
		
		
		
		JFrame f=new JFrame("Carcassonne Team_31");
		
	    
		f.setLayout(new BorderLayout());
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    TileGeneratorView tileGenerator = new TileGeneratorView();
	    tileGenerator.setPreferredSize(new Dimension(80,80));
	    f.add(tileGenerator, BorderLayout.WEST);
	    f.add(_nextPlayer,BorderLayout.EAST);
	    
	   BoarderView ui=new BoarderView(tileGenerator);
		_nextPlayer.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				HashMap<Point, Object> target = Game.currentTile;
				g.putTile(BoarderView.x /(BoarderView.squareSize + 1),BoarderView.y / (BoarderView.squareSize + 1),target);
				tileGenerator.repaint();
				g.nextTile();
				f.repaint();
			}
		});
	    
	    
	    ui.setPreferredSize(new Dimension(8101,8101));
	    JScrollPane scrPane = new JScrollPane(ui, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    Rectangle rct = new Rectangle(48*81+40, 48*81-40, 200, 200);
	    ui.scrollRectToVisible(rct);
	    
	    f.add(scrPane,BorderLayout.CENTER);
	    f.add(v.getPanel(),BorderLayout.SOUTH);
	    f.setSize(500, 600);
	    f.setVisible(true);

	}
}
