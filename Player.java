
public class Player {
	private String name;
	private Die die;
	private boolean hasRolled;
	
	public Player(String n) {
		name = n;
		die = new Die();
	}
	
	public String getName() { 
		return name;
	}
	
	public int roll() {
		die.roll();
		hasRolled = true;
		return die.getFace();
	}
	
	public void reset() {
		hasRolled = false;
	}
	
	public boolean hasRolled() {
		return hasRolled;
	}
	
	public int getNumber() {
		return die.getFace();
	}
}
