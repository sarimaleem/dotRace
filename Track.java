public class Track {
	private Tile[] tiles;
	public Track() {
		
		tiles = new Tile[32];
		
		for(int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile();
		}
		
		tiles[0].change("r", true);
		tiles[0].change("g", true);
		tiles[0].change("y", true);
		tiles[0].change("b", true);
	}
	
	public String toString() {
		String t = "";
		for(int i = 0; i < tiles.length; i++) {
			t += tiles[i].toString() + "\n";
		}
		return t;
	}
	
	public boolean movePlayer(String color, int locs) {
		 int currentPos = getPlayerPos(color);
		 if(currentPos + locs > 31) { 
			 tiles[currentPos].change(color, false);
			 tiles[31].change(color, true);
			 return true;
		 }
		 
		 tiles[currentPos].change(color, false);
		 tiles[currentPos + locs].change(color, true);
		 
		 return false;
	}
	
	
	public int getPlayerPos(String color) {
		
		
		if(color.contains("red")) {
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i].getRed()) 
				return i;
			}
		}
		
		if(color.contains("green")) {
			for(int i = 0; i < tiles.length; i++) {
				if(tiles[i].getGreen()) 
					return i;
				}
		}
		
		if(color.contains("blue")) {
			for(int i = 0; i < tiles.length; i++) {
				if(tiles[i].getBlue()) 
					return i;
				}
		}
		
		if(color.contains("yellow")) {
			for(int i = 0; i < tiles.length; i++) {
				if(tiles[i].getYellow()) 
					return i;
				}
		}
		
		
		return -1;
	}
}