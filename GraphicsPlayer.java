import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class GraphicsPlayer {
	
	private int pos;
	private int [] xPos = new int[]{490, 390, 290, 190, 90, 90, 90, 90, 90, 90, 90, 90, 190, 290, 390, 490, 590, 690, 790, 890, 990, 990, 990, 990, 990, 990, 990, 990, 890, 790, 690, 590};
	private int [] yPos = new int[]{840, 840, 840, 840, 840, 740, 640, 540, 440, 340, 240, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 240, 340, 440, 540, 640, 740, 840, 840, 840, 840, 840};
	private Color color;
	private int diceNum;
	private boolean hasRolled;
	
	public GraphicsPlayer(int adjX, int adjY, Color color) { 
		
		for(int i = 0; i < xPos.length; i++) {
			xPos[i] = xPos[i] + adjX;
			yPos[i] = yPos[i] + adjY;
		}
		this.color = color;

	}
	
	public int getHeight() {
		return 20;
	}
	
	public int getWidth() { 
		return 20;
	}
	
	public int getX() {
		return xPos[pos];
	}
	
	public int getY() {
		return yPos[pos];
	}
	
	public void setPos(int pos) { 
		this.pos = pos;
	}
	
	public Color getColor() {
		if(hasRolled)
			return color.darker().darker().darker();
		return color;
	}
	
	public void setDiceNum(int num) { 
		diceNum = num;
	}
	
	public int getDiceNum() { 
		return diceNum;
	}
	
	public boolean hasRolled() {
		return hasRolled;
	}
	
	public void rolled() {
		hasRolled = true;
	}
	
	public void reset() {
		hasRolled = false;
	}
	
	public void drawEllipse(Graphics2D g2D) {
		g2D.setPaint(color);
		g2D.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}