import java.awt.geom.Ellipse2D;

public class GraphicsPlayer {
	
	private int pos;
	int [] xPos = new int[]{490, 390, 290, 190, 90, 90, 90, 90, 90, 90, 90, 90, 190, 290, 390, 490, 590, 690, 790, 890, 990, 990, 990, 990, 990, 990, 990, 990, 890, 790, 690, 590};
	int [] yPos = new int[]{840, 840, 840, 840, 840, 740, 640, 540, 440, 340, 240, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 240, 340, 440, 540, 640, 740, 840, 840, 840, 840, 840};
	Ellipse2D.Double circle;
	
	public GraphicsPlayer(int adjX, int adjY) { 
		
		for(int i = 0; i < xPos.length; i++) {
			xPos[i] = xPos[i] + adjX;
			yPos[i] = yPos[i] + adjY;
		}
		circle = new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight());
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
	
	public Ellipse2D.Double getEllipse() {
		circle.setFrame(getX(), getY(), getHeight(), getWidth());
		return circle;
	}
}
