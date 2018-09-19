import java.util.Scanner;

public class TextRunner {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Race race = new Race();
		

		while(true) {
			if(race.roundDone()) {
				race.reset();
			}
			
			System.out.println(race.getTrack());
			
			System.out.println("Which player would like to roll the dice? " + race.getPlayersMoved());
			String input = in.nextLine().trim();
			
			while(!(input.equals("r") || input.equals("g") || input.equals("y") || input.equals("b"))) {
				System.out.println("Sorry that input is not valid, please input a real die");
				input = in.nextLine().trim();
			}
			
			if(race.playerHasRolled(input)) {
				System.out.println("Sorry player " + input + " has already rolled.");
				System.out.println();
				continue;
			}
			
			if(race.movePlayer(input)) {
				System.out.println(race.getTrack());
				System.out.println("Player " + input + " rolled a " + race.getFace(input));
				System.out.println("CONGRATULATIONS PLAYER " + input + " HAS WON!!!");
				break;
			}	
			
			System.out.println("Player " + input +  " rolled a "  + race.getFace(input) + "\n\n\n\n\n\n");
			
		}
		
		
		
		in.close();
	} 
}