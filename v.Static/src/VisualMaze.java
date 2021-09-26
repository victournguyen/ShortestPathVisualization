import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class VisualMaze extends Canvas implements KeyListener, Runnable {

	private char[][] mat, copy;
	private int[][] shadow;
	private int bmoves;
	private static int SCALE = 40;
	private Color walls, start, end, path, backgr;

	public VisualMaze(Theme theme) throws Exception {
		
		this.walls = theme.getColor(); this.start = theme.getStart(); this.end = theme.getEnd(); this.path = theme.getPath(); this.backgr = theme.getBackgr();
		setBackground(Color.WHITE);
		
		Scanner file = new Scanner(new File("mazes2.dat"));
		int r = file.nextInt(); int c = file.nextInt(); file.nextLine();
		
		SCALE = 800 / r;
		
		bmoves = Integer.MAX_VALUE;
		mat = new char[r][c]; copy = new char[r][c]; shadow = new int[r][c];
		int startR = 0; int startC = 0;
		
		for (int i = 0; i < mat.length; i++) {
			mat[i] = file.nextLine().toCharArray();
			for (int j = 0; j < mat[i].length; j++) {
				shadow[i][j] = Integer.MAX_VALUE;
				if (mat[i][j] == 'S') {
					startR = i; startC = j;
				}
			}
		}
		
		recur(startR, startC, 0);
		mat[startR][startC] = 'S'; copy[startR][startC] = 'S';
		System.out.println(Arrays.deepToString(copy).replaceAll("\\], \\[", "\n").replaceAll("[\\[\\]\\, ]", ""));
		
	}
	
	public VisualMaze() throws Exception {

		this(Theme.CHRISTMAS);
		
	}
	
	public VisualMaze(Color color, Color start, Color end, Color path, Color backgr) throws Exception {

		this(new Theme(color, start, end, path, backgr));

	}

	public void recur(int r, int c, int steps) {
		
		if (r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && mat[r][c] != '0' && mat[r][c] != '*' && steps < bmoves && steps < shadow[r][c]) {
			
			if (mat[r][c] == 'E') {
				
				bmoves = steps;
				
				for (int i = 0; i < mat.length; i++) {
					for (int j = 0; j < mat[i].length; j++) {
						copy[i][j] = mat[i][j];
					}
				}
				
				return;
				
			}
			
			shadow[r][c] = steps;
			char save = mat[r][c];
			mat[r][c] = '*';
						
			recur(r, c + 1, steps + 1);
			recur(r, c - 1, steps + 1);
			recur(r + 1, c, steps + 1);
			recur(r - 1, c, steps + 1);
			
			mat[r][c] = save;
			
		}
		
	}

	public void paint(Graphics window) {

		window.setColor(walls);
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				if (copy[i][j] == '*') {
					window.setColor(backgr);
					window.fillRect(j * SCALE, i * SCALE, SCALE, SCALE);
					window.setColor(path);
					window.fillOval(j * SCALE + SCALE / 2 - SCALE / 8, i * SCALE + SCALE / 2 - SCALE / 8, SCALE / 4, SCALE / 4);
				}
				if (copy[i][j] == 'S') {
					window.setColor(start);
					window.fillRect(j * SCALE, i * SCALE, SCALE, SCALE);
					window.setColor(path);
					window.fillOval(j * SCALE + SCALE / 2 - SCALE / 8, i * SCALE + SCALE / 2 - SCALE / 8, SCALE / 4, SCALE / 4);
				}
				if (copy[i][j] == 'E') {
					window.setColor(end);
					window.fillRect(j * SCALE, i * SCALE, SCALE, SCALE);
					window.setColor(path);
					window.fillOval(j * SCALE + SCALE / 2 - SCALE / 8, i * SCALE + SCALE / 2 - SCALE / 8, SCALE / 4, SCALE / 4);
				}
				if (copy[i][j] == '1') {
					window.setColor(backgr);
					window.fillRect(j * SCALE, i * SCALE, SCALE, SCALE);
				}
				if (copy[i][j] == '0') {
					window.setColor(walls);
					window.fillRect(j * SCALE, i * SCALE, SCALE, SCALE);
				}
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
