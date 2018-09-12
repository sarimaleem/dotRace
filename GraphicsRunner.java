import javax.swing.JFrame;


public class GraphicsRunner {
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Dot Race");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 1000);		
		window.setVisible(true);
		
		GraphicsBoard board = new GraphicsBoard();
		window.add(board);
		//GraphicsPlayer g = new GraphicsPlayer();
		//window.add(g);

	}
}

