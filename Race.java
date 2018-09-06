import java.util.HashMap;
import java.util.Map;



//MAKE ALL YOUR VARIABLES PRIVATE DOUBLE CHECK IN THE END.
//MAKE SURE YOU DO THIS
//MAKE SURE YOU DO THIS.
//MAKE SURE YOU DO THIS.


public class Race {
	private Player redPlayer, greenPlayer, bluePlayer, yellowPlayer;
	Map<String, Player> players;
	Track track;
	
	public Race() {
		redPlayer = new Player();
		greenPlayer = new Player();
		bluePlayer = new Player();
		yellowPlayer = new Player();
		players = new HashMap<String, Player>();
		track = new Track();
		players.put("r", redPlayer);
		players.put("g", greenPlayer);
		players.put("y", yellowPlayer);
		players.put("b", bluePlayer);
	}
	
	public boolean roundDone() {
		return redPlayer.hasRolled() && greenPlayer.hasRolled() && bluePlayer.hasRolled() && yellowPlayer.hasRolled();
	}
	
	public void reset() {
		redPlayer.reset();
		greenPlayer.reset();
		yellowPlayer.reset();
		bluePlayer.reset();
	}
	
	
	
	public String getInstructions() {
		String instructions  = "";
		instructions += "In this game you will try to get to the end as fast as you can.\n";
		instructions += "Roll the dice once per turn.\n"; 
		instructions += "In order to roll, input the color that you are, if you are red, input red.\n";
		instructions += "Enjoy!.\n";
		return instructions;
	}
	
	public boolean playerHasRolled(String s) {
		return players.get(s).hasRolled();
	}
	
	public boolean movePlayer(String input) {
		if(track.movePlayer(input, players.get(input).roll())) {
			return true;
		}
		return false;
	}
	
	public String getTrack() {
		return track.toString();
	}
	
	public int getFace(String player) {
		return players.get(player).getNumber();
	}
	
	public String getPlayersMoved() {
		String string = "";
		if(redPlayer.hasRolled())
			string += "red ";
		if(yellowPlayer.hasRolled())
			string += "yellow ";
		if(bluePlayer.hasRolled())
			string += "blue ";
		if(greenPlayer.hasRolled())
			string += "green ";
		string += "rolled!";
		 if(string.length() == 7)
			 return "";
		
		return string;
	}
	
}