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
		printInstructions();
		Track track = new Track();
		System.out.println();
		System.out.println(track.toString());
		players.put("red", redPlayer);
		players.put("green", greenPlayer);
		players.put("yellow", yellowPlayer);
		players.put("blue", bluePlayer);
		
		
		Scanner in = new Scanner(System.in);
		
		int roundNum = 0;
		
		
		while(true) {
			if(roundDone()) {
				reset();
				roundNum++;
				System.out.println("Round " + roundNum + " is done");
			}
			
			System.out.println("Which Player would like to roll the dice?");
			String input = in.nextLine().trim();
			
			while(!(input.equals("red") || input.equals("green") || input.equals("yellow") || input.equals("blue"))) {
				System.out.println("Sorry that input is not valid, please input a real die");
				input = in.nextLine().trim();
			}
			
			
			if(players.get(input).hasRolled()) {
				System.out.println("Sorry, player " + input + " has rolled, choose another player");
				continue;
			}
			
			if(track.movePlayer(input, players.get(input).roll())) {
				
				printSpaces();
				System.out.println();
				System.out.println("player " + input + " rolled a "  + players.get(input).getNumber());
				System.out.println("congratulations, player " + input + " won");
				System.out.println(track.toString());
				break;
			}
			
			printSpaces();
			System.out.println(track);
			System.out.println("player " + input + " rolled a "  + players.get(input).getNumber());
			
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
	
	public static void printSpaces() {
		for(int i = 0; i < 100; i++) { 
			System.out.println();
		}
	}
	
	public static void printInstructions() {
		System.out.println("In this game you will try to get to the end as fast as you can.");
		System.out.println("Roll the dice once per turn"); 
		System.out.println("In order to roll input the color that you are, if you are red, put in Red or r or red");
		System.out.println("Enjoy!");
	}
}
