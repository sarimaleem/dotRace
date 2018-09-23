import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class graphicsMouseListener implements MouseListener {
	
	int x, y;
	
	
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
     
     public int getX() { 
    	 return x;
     }
     
     public int getY() {
    	 return getY();
     } 
}
