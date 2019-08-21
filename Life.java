import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Life extends JPanel {
	
	private static final int PIXEL_SIZE = 5;
	private static final int WIDTH = 150 * PIXEL_SIZE;
	private static final int HEIGHT = 100 * PIXEL_SIZE;
	private static final float GEN_TIME = 0.000001f;
	
	private JFrame frame;
	private byte[][] thisCells;
	private byte[][] nextCells;
	
	private Life() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame = new JFrame("Life");
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		thisCells = new byte[WIDTH / PIXEL_SIZE +  2][HEIGHT / PIXEL_SIZE + 2];
		for(int i = 1; i < thisCells.length - 1; i++) {
			for (int j = 1; j < thisCells[i].length - 1; j++) {
				if (Math.random() < 0.5f) {
					thisCells[i][j] = 1;
				}
			}
		}
		nextCells = new byte[WIDTH / PIXEL_SIZE +  2][HEIGHT / PIXEL_SIZE + 2];
	}
	
	@Override 
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		for(int i = 1; i < thisCells.length - 1; i++) {
			for (int j = 1; j < thisCells[i].length - 1; j++) {
				if (thisCells[i][j] == 1) {
					g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
				}
				update(i, j);
			}
		}
		
		thisCells = nextCells;
		nextCells = new byte[WIDTH / PIXEL_SIZE +  2][HEIGHT / PIXEL_SIZE + 2];
	}
	
	void update(int i, int j) {
		int neighbors =
		thisCells[i - 1][j - 1] + thisCells[i][j - 1] + thisCells[i + 1][j - 1] +
		thisCells[i - 1][j] + 0 + thisCells[i + 1][j] +
		thisCells[i - 1][j + 1] + thisCells[i][j + 1] + thisCells[i + 1][j + 1];
		
		if (thisCells[i][j] == 1) {
			if (neighbors == 2 || neighbors == 3) {
				nextCells[i][j] = 1;
			}
		} else {
			if (neighbors == 3) {
				nextCells[i][j] = 1;
			}
		}
	}
	
	void start() {
		float elapsedTime = 0;
		long startTime = System.nanoTime();
		while(true) {
			long thisTime = System.nanoTime();
			elapsedTime += (thisTime - startTime) *1e-9f;
			startTime = thisTime;
			if (elapsedTime > GEN_TIME) {
				elapsedTime -= GEN_TIME;
				frame.repaint();
			}
		}
	}
	
	public static void main(String[] args) {
		new Life().start();
	}
}
