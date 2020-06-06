import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Application;

public class MandelbrotSet {

	public BufferedImage image;

	public float camX, camY;
	public float scale;
	public int maxIterations;

	private BufferedImage buffer;
	private int width, height;

	public MandelbrotSet(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		scale = 4f / Math.max(width, height);
		maxIterations = 1000;
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.width = width;
		this.height = height;
	}

	public void updateImage() {
		for (int j = 0; j < height; ++j) {
			for (int i = 0; i < width; ++i) {
				float x = camX + (i + 0.5f - width / 2f) * scale;
				float y = camY + (height / 2f - j - 0.5f) * scale;
				if (getIterations(x, y) == maxIterations) {
					buffer.setRGB(i, j, 0xFF000000);
				} else {
					buffer.setRGB(i, j, 0xFFFFFFFF);
				}
			}
		}
		BufferedImage temp = image;
		image = buffer;
		buffer = temp;
	}

	private int getIterations(float cX, float cY) {
		float zX = 0, zY = 0;
		for (int i = 0; i <= maxIterations; ++i) {
			if (zX*zX + zY*zY > 4) {
				return i;
			}
			float newX = zX*zX - zY*zY + cX;
			float newY = 2*zX*zY + cY;
			zX = newX;
			zY = newY;
		}
		return maxIterations;
	}

	public static void main(String[] args) {
		final int WIDTH = 1000, HEIGHT = WIDTH * 9 / 16;

		SwingUtilities.invokeLater(() -> {
			MandelbrotSet obj = new MandelbrotSet(WIDTH, HEIGHT);
			obj.updateImage();

			JComponent component = new JComponent() {
				@Override
				public void paintComponent(Graphics g) {
					g.drawImage(obj.image, 0, 0, getWidth(), getHeight(), null);
				}
			};

			JFrame frame = new JFrame("Mandelbrot Set");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(component);
			frame.pack();
			frame.setVisible(true);
		}); 
	}
}