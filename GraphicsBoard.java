import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;

public class GraphicsBoard extends JComponent  {
	
	private GraphicsPlayer redPlayer, bluePlayer, yellowPlayer, greenPlayer;
	private Map<String, GraphicsPlayer> players = new HashMap<String, GraphicsPlayer>();
	private Map<String, Integer[]> diePos = new HashMap<String, Integer[]>();
	private boolean isOver;
	private String winner;
	private Map<String, String> playerToName = new HashMap<>();
	
	public GraphicsBoard() {
		redPlayer = new GraphicsPlayer(15, 15, Color.red);
		bluePlayer = new GraphicsPlayer(-15, -15, new Color(51, 204, 255));
		greenPlayer = new GraphicsPlayer(15, -15, Color.green);
		yellowPlayer = new GraphicsPlayer(-15, 15, Color.yellow);
		
		players.put("r", redPlayer);
		players.put("b", bluePlayer);
		players.put("g", greenPlayer);
		players.put("y", yellowPlayer);
		
		playerToName.put("b", "Blue");
		playerToName.put("g", "Green");
		playerToName.put("r", "Red");
		playerToName.put("y", "Yellow");
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(new Color(255, 230, 232));
		g2D.fillRect(0, 0, 2400, 1200);
		drawBoard(g2D);
		drawPlayers(g2D);
		drawStartEnd(g2D);
		drawDie(g2D);
		if(isOver)
			drawWinner(g2D);
		repaint();
	}
	
	public void isOver(String playerColor) { 
		isOver = true;
		winner = playerColor;
	}
	
	
	public void drawWinner(Graphics2D g2D) {
		reset();
		g2D.setPaint(players.get(winner).getColor());
		g2D.setFont(new Font("serif", Font.BOLD, 60));
		g2D.drawString(playerToName.get(winner) + " Player Has Won!!!", 210, 520);
	}
	
	
	public void setPlayerPos(String player, int pos) {
		players.get(player).setPos(pos);
	}
	
	public void setPlayerDiceNum(String playerColor, int face) {
		players.get(playerColor).setDiceNum(face);
	}
	
	public void rolled(String playerColor) {
		players.get(playerColor).rolled();
	}
	
	public void reset() {
		for(String color: players.keySet()) 
			players.get(color).reset();
	}
	
	public void drawDie(Graphics2D g2D) { 
		
		Rectangle redDie = new Rectangle(350, 350, 100, 100);
		g2D.setColor(players.get("r").getColor());
		g2D.fill(redDie);
		drawDiceFace(g2D, players.get("r").getDiceNum(), 350, 350);
		
		Rectangle blueDie = new Rectangle(350, 550, 100, 100);
		g2D.setColor(players.get("b").getColor());
		g2D.fill(blueDie);
		drawDiceFace(g2D, players.get("b").getDiceNum(), 350, 550);
		
		Rectangle yellowDie = new Rectangle(550, 350, 100, 100);
		g2D.setColor(players.get("y").getColor());
		g2D.fill(yellowDie);
		drawDiceFace(g2D, players.get("y").getDiceNum(), 550, 350);
		
		Rectangle greenDie = new Rectangle(550, 550, 100, 100);
		g2D.setColor(players.get("g").getColor());
		g2D.fill(greenDie);
		drawDiceFace(g2D, players.get("g").getDiceNum(), 550, 550);
	}
	
	public void drawDiceFace(Graphics2D g2D, int face, int x, int y) {
		g2D.setPaint(Color.BLACK);
		
		switch (face) {
		
		case 1: 
			
			g2D.fillOval(x + 43, y + 43, 15, 15);
			break;
		
		case 2:
			
			g2D.fillOval(x+18, y+68, 15, 15);
			g2D.fillOval(x+68, y+18, 15, 15);
			break;
			
		case 3:
			
			g2D.fillOval(x+18, y+68, 15, 15);
			g2D.fillOval(x+43, y+43, 15, 15);
			g2D.fillOval(x+68, y+18, 15, 15);
			break;
			
		case 4:
			
			g2D.fillOval(x+23, y+23, 15, 15);
			g2D.fillOval(x+63, y+63, 15, 15);
			g2D.fillOval(x+23, y+63, 15, 15);
			g2D.fillOval(x+63, y+23, 15, 15);
			break;
			
		case 5:
			
			g2D.fillOval(x+23, y+23, 15, 15);
			g2D.fillOval(x+63, y+63, 15, 15);
			g2D.fillOval(x+23, y+63, 15, 15);
			g2D.fillOval(x+63, y+23, 15, 15);
			g2D.fillOval(x+43, y+43, 15, 15);
			break;
			
		case 6:
			
			g2D.fillOval(x+13, y+13, 15, 15);
			g2D.fillOval(x+43, y+13, 15, 15);
			g2D.fillOval(x+73, y+13, 15, 15);
			g2D.fillOval(x+13, y+73, 15, 15);
			g2D.fillOval(x+43, y+73, 15, 15);
			g2D.fillOval(x+73, y+73, 15, 15);
			break;

		default:
			break;
		}
	}
	
	public void drawBoard(Graphics2D g2D) { 
		
		int thickness = 3;
		Stroke oldStroke = g2D.getStroke();
		g2D.setStroke(new BasicStroke(thickness));
		
		
		g2D.setPaint(Color.black);
		for(int i = 0; i < 10; i++) {
			 g2D.drawRect(i * 100 + 50, 800, 100, 100);
			 g2D.drawRect(i * 100 + 50, 100, 100, 100);
		}
		
		for(int i = 0; i < 6; i++) { 
			g2D.drawRect(50, i * 100 + 200, 100, 100);
			g2D.drawRect(950, i * 100 + 200, 100, 100);
			}
		
		g2D.setStroke(oldStroke);
		
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