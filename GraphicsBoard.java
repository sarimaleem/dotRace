import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class GraphicsBoard extends JComponent {

	public GraphicsBoard() {
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		for(int i = 0; i < 10; i++) {
			 Rectangle rectangle = new Rectangle(i * 100 + 50, 800, 100, 100);
			 g2D.draw(rectangle);
		}
		
		for(int i = 0; i < 6; i++) { 
			Rectangle rectangle = new Rectangle(50, i * 100 + 200, 100, 100);
			 g2D.draw(rectangle);
		}
		
		for(int i = 0; i < 10; i++) {
			 Rectangle rectangle = new Rectangle(i * 100 + 50, 100, 100, 100);
			 g2D.draw(rectangle);
		}
		
		for(int i = 0; i < 6; i++) { 
			Rectangle rectangle = new Rectangle(950, i * 100 + 200, 100, 100);
			 g2D.draw(rectangle);
		}
		
	}
}