public class Tile {
	private boolean red;
	private boolean yellow;
	private boolean green;
	private boolean blue;
	
	public Tile() {
		red = false;
		yellow = false;
		green = false;
		blue  = false;
	}
	
	public void change(String color, boolean b) {
		if(color.equals("r"))
			red = b;
		
		if(color.equals("y"))
			yellow = b;
		
		if(color.equals("g"))
			green = b;
		
		if(color.equals("b"))
			blue = b;
	}
	
	
	
	public boolean getRed() {
		return red;
	}
	
	public boolean getYellow() { 
		return yellow;
	}
	public boolean getGreen() {
		return green;
	}
	
	public boolean getBlue() {
		return blue;
	}
	
	
	
	
	public String toString() {
		String s = "";
		
		if(getBlue())
			s+="B";
		else
			s += " ";
		
		if(getRed())
			s+="R";
		else
			s += " ";
		
		if(getYellow())
			s+="Y";
		else
			s += " ";
		
		if(getGreen())
			s+="G";
		else
			s += " ";
		
		return s;
	}
}