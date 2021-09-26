import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class DjikstraRunner extends JFrame {

	private static final long serialVersionUID = 3056773350616900984L;

	/*private static final int WIDTH = 800;
	private static final int HEIGHT = 600;*/

	public DjikstraRunner() throws Exception {
		super();
		//setSize(new Dimension(WIDTH + 15, HEIGHT + 10 + 30)); //15 and 10 for some unknown reason, 30 for window bar thing
		Djikstra solver = new Djikstra("maze0.txt");
		setSize(solver.cols * 50 + 15, solver.rows * 50 + 39);
		getContentPane().add(solver);
		validate();
		setLocationRelativeTo(null);
		setVisible(true);
		solver.solve();
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		if (solver.solved) {
			JOptionPane.showMessageDialog(this, "Shortest Path: " + solver.best/*, "", JOptionPane.PLAIN_MESSAGE*/);
			//add(new JLabel("Shortest Path: " + solver.best, SwingConstants.CENTER));
		}
		else
			JOptionPane.showMessageDialog(this, "Impossible!");
		KeyAdapter listener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					dispose();
			}
		};
		addKeyListener(listener);
		//solver.solve();
		//System.out.println(solver);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {
		new DjikstraRunner();
	}

}
