import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class GraphicsRunner implements MouseListener {
	
	static String[][] dieColors;
	public static void main(String[] args)  {
		
		dieColors = new String[1200][1000];
		
		for(int i = 0; i < 1200; i++) 
			for(int j = 0; j < 1000; j++)
				dieColors[i][j] = "";
		
		for(int i = 0; i < 100; i++) { 
			for(int j = 0; j < 100; j++) {
				dieColors[i+350][j+350] = "r";
				dieColors[i+350][j+550] = "b";
				dieColors[i+550][j+350] = "y";
				dieColors[i+550][j+550] = "g";
			}
		}
		
		
		
		Race race = new Race();
		JFrame window = new JFrame("Dot Race");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 1000);		
		window.setVisible(true);
		GraphicsBoard board = new GraphicsBoard();
		window.add(board);
		board.addMouseListener(new GraphicsRunner());
	}
	
	
	public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
     }

     public void mousePressed(MouseEvent e) {
     
     }

     public void mouseReleased(MouseEvent e) {
    	 
     }

     public void mouseEntered(MouseEvent e) {
     }

     public void mouseExited(MouseEvent e) {
     }

}