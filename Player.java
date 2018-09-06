public class Player {
	private Die die;
	private boolean hasRolled;
	
	public Player() {
		die = new Die();
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
