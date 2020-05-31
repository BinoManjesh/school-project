package com.bino.graphics3d;

import java.awt.event.*;

public class InputHandler extends KeyAdapter {

	private Main main;

	public InputHandler(Main main) {
		this.main = main;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		char c = e.getKeyChar();
		switch(c) {
			case 'w':
			main.camera.position.add(main.camera.front);
			break;

			case 'a':
			main.camera.front = main.camera.front.rotateY(0.1f);
			main.camera.right = main.camera.right.rotateY(0.1f);
			break;

			case 's':
			main.camera.position.add(main.camera.front.copy().scale(-1));
			break;

			case 'd':
			main.camera.front = main.camera.front.rotateY(-0.1f);
			main.camera.right = main.camera.right.rotateY(-0.1f);
		}
		main.repaint();
	}
}