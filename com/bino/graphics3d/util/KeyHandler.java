package com.bino.graphics3d.util;

import java.awt.event.*;
import java.util.HashSet;

public class KeyHandler extends KeyAdapter {

	private HashSet<Integer> set;

	@Override
	public void keyPressed(KeyEvent e) {
		set.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		set.remove(e.getKeyCode());
	}

	public boolean isKeyPressed(int keyCode) {
		return set.contains(keyCode);
	}
}