import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
public class GraphicsRunner implements MouseListener {
	
	private static String[][] dieColors;
	private static Race race;
	private static GraphicsBoard board;
	
	public static void main(String[] args)  {
		
		dieColors = new String[2400][1000];
		
		for(int i = 0; i < 100; i++) { 
			for(int j = 0; j < 100; j++) {
				dieColors[i+350][j+350] = "r";
				dieColors[i+350][j+550] = "b";
				dieColors[i+550][j+350] = "y";
				dieColors[i+550][j+550] = "g";
			}
		}
		
		race = new Race();
		JFrame window = new JFrame("Dot Race");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 1200);		
		window.setVisible(true);
		board = new GraphicsBoard();
		window.add(board);
		board.addMouseListener(new GraphicsRunner());
	}
	
	
	public void mouseClicked(MouseEvent e) {
        
       String playerColor = dieColors[e.getX()][e.getY()]; 
        
       if(playerColor == null || race.raceOver() || race.playerHasRolled(playerColor))
    	   return;
        
       if(race.movePlayer(playerColor))
    	   board.isOver(playerColor);
       
       int playerPos = race.getTrack().indexOf(playerColor.toUpperCase()) % 34;
       board.setPlayerPos(playerColor, playerPos);
       
       int dieNum = race.getFace(playerColor);
       board.setPlayerDiceNum(playerColor, dieNum);
       
       board.rolled(playerColor);
       
       if(race.roundDone()) {
    	   race.reset();
    	   board.reset();
       }  
     }

     public void mousePressed(MouseEvent e) {}

     public void mouseReleased(MouseEvent e) {}

     public void mouseEntered(MouseEvent e) {}

     public void mouseExited(MouseEvent e) {}
}