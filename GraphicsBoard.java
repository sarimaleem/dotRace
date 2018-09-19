import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;

public class GraphicsBoard extends JComponent  {
	
	GraphicsPlayer redPlayer;
	GraphicsPlayer bluePlayer;
	GraphicsPlayer yellowPlayer;
	GraphicsPlayer greenPlayer;
	Map<String, GraphicsPlayer> players = new HashMap<String, GraphicsPlayer>();
	Map<String, Integer[]> diePos = new HashMap<String, Integer[]>();
	
	
	
	
	public GraphicsBoard() {
		redPlayer = new GraphicsPlayer(15, 15, Color.red);
		bluePlayer = new GraphicsPlayer(-15, -15, Color.blue);
		greenPlayer = new GraphicsPlayer(15, -15, Color.green);
		yellowPlayer = new GraphicsPlayer(-15, 15, Color.yellow);
		
		players.put("r", redPlayer);
		players.put("b", bluePlayer);
		players.put("g", greenPlayer);
		players.put("y", yellowPlayer);
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		drawBoard(g2D);
		drawPlayers(g2D);
		drawStartEnd(g2D);
		drawDie(g2D);		
	}
	
	
	public void setPos(String player, int pos) {
		players.get(player).setPos(pos);
	}
	
	public void drawDie(Graphics2D g2D) { 
		Rectangle redDie = new Rectangle(350 ,350, 100, 100);
		g2D.setColor(Color.red);
		g2D.fill(redDie);
		
		Rectangle blueDie = new Rectangle(350, 550, 100, 100);
		g2D.setColor(Color.blue);
		g2D.fill(blueDie);
		
		Rectangle yellowDie = new Rectangle(550, 350, 100, 100);
		g2D.setColor(Color.yellow);
		g2D.fill(yellowDie);
		
		
		Rectangle greenDie = new Rectangle(550, 550, 100, 100);
		g2D.setColor(Color.green);
		g2D.fill(greenDie);
	}
	
	public void drawBoard(Graphics2D g2D) { 
		
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
	
	
	public void drawPlayers(Graphics2D g2D) { 
		players.get("r").drawEllipse(g2D);
		players.get("b").drawEllipse(g2D);
		players.get("g").drawEllipse(g2D);
		players.get("y").drawEllipse(g2D);
	}
	
	
	public void drawStartEnd(Graphics2D g2D) {
		g2D.setColor(Color.MAGENTA);
		g2D.setFont(new Font("serif", Font.BOLD, 14));
		g2D.drawString("START", 480, 890);
		g2D.drawString("END", 590, 890);
	}
		
	
}