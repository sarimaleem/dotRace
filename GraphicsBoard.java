import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;

public class GraphicsBoard extends JComponent {
	
	GraphicsPlayer redPlayer;
	GraphicsPlayer bluePlayer;
	GraphicsPlayer yellowPlayer;
	GraphicsPlayer greenPlayer;
	Map<String, GraphicsPlayer> players = new HashMap<String, GraphicsPlayer>();
	
	public GraphicsBoard() {
		redPlayer = new GraphicsPlayer(15, 15);
		bluePlayer = new GraphicsPlayer(-15, -15);
		greenPlayer = new GraphicsPlayer(15, -15);
		yellowPlayer = new GraphicsPlayer(-15, 15);
		
		players.put("r", redPlayer);
		players.put("b", bluePlayer);
		players.put("g", greenPlayer);
		players.put("y", yellowPlayer);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(Color.pink);
		for(int i = 0; i < 10; i++) {
			 Rectangle rectangle = new Rectangle(i * 100 + 50, 800, 100, 100);
			 g2D.draw(rectangle);
			 //g2D.fill(rectangle);
		}
		
		for(int i = 0; i < 6; i++) { 
			Rectangle rectangle = new Rectangle(50, i * 100 + 200, 100, 100);
			g2D.fill(rectangle); 
			g2D.draw(rectangle);
			 //
		}
		
		for(int i = 0; i < 10; i++) {
			 Rectangle rectangle = new Rectangle(i * 100 + 50, 100, 100, 100);
			 g2D.draw(rectangle);
			 //g2D.fill(rectangle);
		}
		
		for(int i = 0; i < 6; i++) { 
			Rectangle rectangle = new Rectangle(950, i * 100 + 200, 100, 100);
			 g2D.draw(rectangle);
			 //g2D.fill(rectangle);
		}
		
		g2D.draw(redPlayer.getEllipse());
		g2D.setColor(Color.red);
		g2D.fill(redPlayer.getEllipse());
		
		
		g2D.draw(bluePlayer.getEllipse());
		g2D.setPaint(Color.blue);
		g2D.fill(bluePlayer.getEllipse());
		
		g2D.draw(greenPlayer.getEllipse());
		g2D.setPaint(Color.GREEN);
		g2D.fill(greenPlayer.getEllipse());
		
		g2D.draw(yellowPlayer.getEllipse());
		g2D.setPaint(Color.yellow);
		g2D.fill(yellowPlayer.getEllipse());
		
		
		g2D.setColor(Color.MAGENTA);
		g2D.setFont(new Font("serif", Font.BOLD, 14));
		g2D.drawString("START", 480, 890);
		g2D.drawString("END", 590, 890);
	}
	
	public void setPos(String player, int pos) {
		players.get(player).setPos(pos);
	}
}