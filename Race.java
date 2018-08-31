import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Race {
	
	static Player redPlayer = new Player("Red");
	static Player greenPlayer = new Player("Green");
	static Player bluePlayer = new Player("Blue");
	static Player yellowPlayer = new Player("Yellow");
	static Map<String, Player> players = new HashMap<String, Player>();
	
	public static void main(String[] args) {
		utilMethods.printInstructions();
		Track track = new Track();
		System.out.println();
		track.dispTrack();
		players.put("red", redPlayer);
		players.put("green", greenPlayer);
		players.put("yellow", yellowPlayer);
		players.put("blue", bluePlayer);
		
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			if(roundDone()) {
				reset();
			}
			
			System.out.println("Which Player would like to roll the dice?");
			String input = in.nextLine();
			if(players.get(input).hasRolled()) {
				System.out.println("Sorry, player " + input + " has rolled, choose another player");
				continue;
			}
			
			if(track.movePlayer("input", players.get(input).roll())) {
				
				utilMethods.printSpaces();
				track.dispTrack();
				System.out.println("player " + input + " rolled a "  + players.get("input").getNumber());
				System.out.println("congratulations, player " + input + "won");
				break;
			}
			
			track.dispTrack();
			System.out.println("player " + input + " rolled a "  + players.get("input").getNumber());
			
		}
		
		in.close();
		
	}
	
	public static boolean roundDone() {
		return redPlayer.hasRolled() && greenPlayer.hasRolled() && bluePlayer.hasRolled() && yellowPlayer.hasRolled();
	}
	
	public static void reset() {
		redPlayer.reset();
		greenPlayer.reset();
		yellowPlayer.reset();
		bluePlayer.reset();
	}
}
