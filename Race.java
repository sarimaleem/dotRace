import java.util.HashMap;
import java.util.Map;

public class Race {
	private Player redPlayer, greenPlayer, bluePlayer, yellowPlayer;
	private Map<String, Player> players;
	private Track track;
	private boolean raceOver = false;
	
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

	public boolean playerHasRolled(String s) {
		return players.get(s).hasRolled();
	}
	
	public boolean movePlayer(String input) {
		if(track.movePlayer(input, players.get(input).roll())) {
			raceOver = true;
			return raceOver;
		}
		return raceOver;
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
	
	public boolean raceOver() {
		return raceOver;
	}
	
}