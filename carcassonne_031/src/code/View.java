package code;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class View {
	
	private  int _rotateNum;
	public View(Game g){
	
	JButton _nextPlayer; 
	JButton _rotate;
	JButton _putMeeple;
	JButton _nputMeeple;
	JButton _start;
	
	
	_rotate = new JButton("rotate");
	_nextPlayer = new JButton("OK!");
	_putMeeple = new JButton("Put Here!");
	_nputMeeple = new JButton("Don't put!");
	_start = new JButton(" START ");
	_putMeeple.setPreferredSize(new Dimension(240,50));
	_nputMeeple.setPreferredSize(new Dimension(240,50));
	_start.setPreferredSize(new Dimension(250,100));
	
	
	Font f1=new Font("Verdana",Font.BOLD,18);
	Font f2=new Font("Verdana",Font.BOLD,22);
	_nputMeeple.setForeground(Color.black);
	_nputMeeple.setBackground(Color.LIGHT_GRAY);
	_putMeeple.setForeground(Color.BLACK);
	_putMeeple.setBackground(Color.LIGHT_GRAY);
	_start.setBackground(Color.LIGHT_GRAY);
	_start.setForeground(Color.black);
	_putMeeple.setFont(f1);
	_nputMeeple.setFont(f1);
	_start.setFont(f2);
	
	_putMeeple.setBorder(BorderFactory.createRaisedBevelBorder());
	_nputMeeple.setBorder(BorderFactory.createRaisedBevelBorder());
	_start.setBorder(BorderFactory.createRaisedBevelBorder());
	_start.setBounds(200, 530, 400, 100);
	_start.setBackground(Color.GRAY);
	
	JPanel _choose = new JPanel();
	
	_choose.setLayout(new BorderLayout());
    _choose.add(_putMeeple,BorderLayout.NORTH);
    _choose.add(_nputMeeple,BorderLayout.SOUTH);
	
	JFrame beginWindow = new JFrame("Carcassonne Team");
	beginWindow.setLayout(new BorderLayout());
	beginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	beginWindow.setLocation(500, 80);
	
	
	JFrame f=new JFrame("Carcassonne Team_31");
	JFrame _putMeepleView = new JFrame("Put Meeple!");
	
	
	f.setLayout(new BorderLayout());
	_putMeepleView.setLayout(new BorderLayout());
	
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    _putMeepleView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    TileGeneratorView tileGenerator = new TileGeneratorView();
    PutMeepleView pmv = new PutMeepleView();
    StartView sv = new StartView();
    sv.setLayout(null);
    
    BoarderView ui=new BoarderView(tileGenerator);
    ui.addGame(g);
    
	pmv.addGame(g);
	pmv.setPreferredSize(new Dimension(240,240));
	
    tileGenerator.addGame(g);
    tileGenerator.setPreferredSize(new Dimension(80,80));
    
    sv.addGame(g);
    sv.setPreferredSize(new Dimension(800,800));
    sv.add(_start);
    
    beginWindow.add(sv,BorderLayout.CENTER); 
	beginWindow.setVisible(true);
	beginWindow.pack();
    
    f.add(tileGenerator, BorderLayout.WEST);
    f.add(_nextPlayer,BorderLayout.EAST);
    f.add(_rotate,BorderLayout.NORTH);
     
   
    
    _putMeepleView.add(pmv,BorderLayout.CENTER);
    _putMeepleView.setSize(240,387);
    _putMeepleView.setVisible(false);
    _putMeepleView.setLocation(500, 500);
    _putMeepleView.setTitle("put meeple!");
    _putMeepleView.add(_choose,BorderLayout.SOUTH);
   
    _start.addActionListener(new ActionListener(){
    		@Override public void actionPerformed(ActionEvent e){
    			f.setVisible(true);
    			beginWindow.setVisible(false);
		}
	});
    
	_nextPlayer.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
			
			HashMap<Point, Object> target = g.topTile();
			boolean placement = g.putTile(BoarderView.x /(BoarderView.squareSize + 1),BoarderView.y / (BoarderView.squareSize + 1),target);
			if(placement){
			_putMeepleView.setVisible(true);
			
			
			}
		}
	});
	_putMeeple.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
			_putMeepleView.setVisible(false);
			g.nextTile();
			ui.repaint();
			tileGenerator.repaint();
			_putMeepleView.repaint();
			f.repaint();
			
			_rotateNum = 0;
			
		}	
	});
	
	_nputMeeple.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
			g.nextTile();
			ui.repaint();
			tileGenerator.repaint();
			_putMeepleView.repaint();
			f.repaint();
			
			_rotateNum = 0;
			_putMeepleView.setVisible(false);
		}	
	});
	
	_rotate.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
			//currentTileImage = ui.cutImage(ui.currentX,ui.currentY);
			//ui._tilePiece = ui.cutImage(TileGeneratorView.k,TileGeneratorView.j);
//			ui._imageState = 1;
			 
			_rotateNum++;
			if(_rotateNum == 4) _rotateNum = 0;
			
			g.topTile().put(new Point(3,4),(char)( _rotateNum + '0'));
			g.refreshSlot();
			tileGenerator.repaint();
			
			f.repaint();
			}
	});
    ui.setPreferredSize(new Dimension(8101,8101));
    JScrollPane scrPane = new JScrollPane(ui, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Rectangle rct = new Rectangle(48*81+40, 48*81-40, 200, 200);
    ui.scrollRectToVisible(rct);
   
    f.add(scrPane,BorderLayout.CENTER);
    f.setSize(800, 800);
    f.setVisible(false);
    f.setLocation(500, 80);
  
    
   
}

}
