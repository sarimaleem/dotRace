public class Die {
	
	private int face;
	
	public Die() {
		
	}
	
	public void roll() {
		double x =  Math.random() * 6 + 1;
		int ans = (int) x;
		face = ans;
	}

	
	public int getFace() {
		return face;
	}
	
}
