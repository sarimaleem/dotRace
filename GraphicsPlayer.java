import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class GraphicsPlayer extends JComponent{
	public GraphicsPlayer() { 
		
	}
	
	public void paintComponent(Graphics g) { 
		Graphics2D g2D = (Graphics2D)g;
		Ellipse2D.Double ellipse2d = new Ellipse2D.Double(500,500,  20, 20);
		g2D.draw(ellipse2d);
		
	}
 	
}
