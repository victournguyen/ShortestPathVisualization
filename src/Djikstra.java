import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JPanel;

public class Djikstra extends JPanel /*implements Runnable*/ {

	private static final long serialVersionUID = 1840592522450946647L;

	char[][] matrix, copy;
	int[][] shadow;
	int best, rows, cols, start_row, start_col;
	boolean solved, done;

	public Djikstra(String path) throws Exception {
		Scanner file = new Scanner(new File(path));
		rows = file.nextInt();
		cols = file.nextInt();
		file.nextLine();
		matrix = new char[rows][cols];
		copy = new char[rows][cols];
		shadow = new int[rows][cols];
		best = Integer.MAX_VALUE;
		for (int i = 0; i < rows; i++) {
			matrix[i] = file.nextLine().toCharArray();
			for (int j = 0; j < cols; j++) {
				copy[i][j] = matrix[i][j];
				if (matrix[i][j] == 'S') {
					start_row = i;
					start_col = j;
				}
			}
			Arrays.fill(shadow[i], Integer.MAX_VALUE);
		}
		//new Thread(this).start();
	}

	public void solve() {
		solved = false;
		done = false;
		solver(0, 0, 0, true);
		done = true;
		repaint();
	}

	private void solver(int r, int c, int steps, boolean first) {
		if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length && (matrix[r][c] != '#' && matrix[r][c] != '*') && steps < best && steps < shadow[r][c]) {
			if (matrix[r][c] == 'E') {
				best = steps;
				solved = true;
				matrix[start_row][start_col] = 'S';
				for (int i = 0; i < matrix.length; i++)
					for (int j = 0; j < matrix[r].length; j++)
						copy[i][j] = matrix[i][j];
				/*try {
					Thread.sleep(200);
					matrix[r][c] = '*';
					repaint();
					matrix[r][c] = 'E';
				} catch (Exception e) { }*/
				return;
			}

			shadow[r][c] = steps++;
			char save = matrix[r][c];
			matrix[r][c] = '*';
			
			try {
				Thread.sleep(200);
				repaint();
			} catch (Exception e) { }
			
			solver(r + 1, c, steps, first);
			solver(r - 1, c, steps, first);
			solver(r, c + 1, steps, first);
			solver(r, c - 1, steps, first);
			matrix[r][c] = save;
			
			try {
				Thread.sleep(200);
				repaint();
			} catch (Exception e) { }
			
			//matrix[r][c] = save;
		}
	}
	
	/*public void solve_bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start_row); q.add(start_col); q.add(0);
		while (!q.isEmpty()) {
			int r = q.remove(), c = q.remove(), steps = q.remove();
			if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length && matrix[r][c] != '#' && steps < best) {
				if (matrix[r][c] == 'E') {
					best = steps;
					break;
				}
				
				matrix[r][c] = '#';
				steps++;
				
				q.add(r + 1); q.add(c); q.add(steps);
				q.add(r - 1); q.add(c); q.add(steps);
				q.add(r); q.add(c + 1); q.add(steps);
				q.add(r); q.add(c - 1); q.add(steps);
			}
		}
	}*/

	public void paint(Graphics window) {
		/*window.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		window.fillRect(0, 0, 100, 100);*/
		if (!done) {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (matrix[r][c] == '#')
						window.setColor(Color.BLACK);
					else if (r == start_row && c == start_col || matrix[r][c] == 'E')
						window.setColor(Color.YELLOW);
					else if (matrix[r][c] == '*') {
						window.setColor(Color.BLUE);
					}
					else
						window.setColor(Color.WHITE);
					window.fillRect(c * 50, r * 50, 50, 50);
				}
			}
		}
		else {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (copy[r][c] == '#')
						window.setColor(Color.BLACK);
					else if (copy[r][c] == 'S' || copy[r][c] == 'E')
						window.setColor(Color.YELLOW);
					else if (copy[r][c] == '*') {
						window.setColor(Color.GREEN);
					}
					else
						window.setColor(Color.WHITE);
					window.fillRect(c * 50, r * 50, 50, 50);
				}
			}
		}
	}

	/*public void run() {
		try {
			while (true) {
				Thread.sleep(250);
				repaint();
			}
		} catch (Exception e) { }
	}*/

	public String toString() {
		if (solved)
			return "Shortest Path: " + best + " steps\n" + Arrays.deepToString(copy).replaceAll("\\], \\[", "\n").replaceAll("[\\]\\[, ]", "");
		else
			return "Impossible!";
	}

}
