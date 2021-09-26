import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VisualMazeRunner extends JFrame {
	
	private static final int WIDTH = 816, HEIGHT = 839;
	
	public VisualMazeRunner() throws Exception {
		
		super("Visual Maze");
		setSize(WIDTH, HEIGHT);
		getContentPane().add(new VisualMaze(Theme.CHRISTMAS));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KeyAdapter listener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
            	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                	dispose();
            	}
            }
        };
		addKeyListener(listener);
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new VisualMazeRunner();
	}

}
