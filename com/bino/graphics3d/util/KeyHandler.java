package com.bino.graphics3d.util;

import java.awt.event.*;
import java.util.HashMap;

public class KeyHandler extends KeyAdapter {

	private HashMap<Integer, Boolean> map;

	@Override
	public void keyPressed(KeyEvent e) {
		map.put(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		map.put(e.getKeyCode(), false);
	}
}