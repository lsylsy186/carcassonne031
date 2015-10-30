package code;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class View {
	
	private Image currentTileImage;
	public View(Game g){
	
//	PlayerButtonView v = new PlayerButtonView(g);
	JButton _nextPlayer; 
	JButton _rotate;
	_rotate = new JButton("rotate");
	_nextPlayer = new JButton("OK!");
	
	 
	
	
	
	
	JFrame f=new JFrame("Carcassonne Team_31");
	
    
	f.setLayout(new BorderLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    TileGeneratorView tileGenerator = new TileGeneratorView();
	 BoarderView ui=new BoarderView(tileGenerator);
    //TileGeneratorView tileGenerator = new TileGeneratorView();
    tileGenerator.addGame(g);
    tileGenerator.setPreferredSize(new Dimension(80,80));
    f.add(tileGenerator, BorderLayout.WEST);
    f.add(_nextPlayer,BorderLayout.EAST);
    f.add(_rotate,BorderLayout.NORTH);
  
   ui.addGame(g);
	_nextPlayer.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
			HashMap<Point, Object> target = g.topTile();
			boolean placement = g.putTile(BoarderView.x /(BoarderView.squareSize + 1),BoarderView.y / (BoarderView.squareSize + 1),target);
			if(placement){
			tileGenerator.repaint();
			g.nextTile();
			f.repaint();
			}
		}
	});
    
   // f.add(_rotate,BorderLayout.NORTH);
	_rotate.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
			currentTileImage = ui.cutImage(ui.currentX,ui.currentY);
			
			ui.rotateImage();
			
			tileGenerator.repaint();
			f.repaint();
			}
		
	});
    ui.setPreferredSize(new Dimension(8101,8101));
    JScrollPane scrPane = new JScrollPane(ui, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Rectangle rct = new Rectangle(48*81+40, 48*81-40, 200, 200);
    ui.scrollRectToVisible(rct);
   
    f.add(scrPane,BorderLayout.CENTER);
//    f.add(v.getPanel(),BorderLayout.SOUTH);
    f.setSize(500, 600);
    f.setVisible(true);

}

}
