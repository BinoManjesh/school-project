package moving_ball;

import java.awt.event.*;

class InputManager extends KeyAdapter {
    
    private static InputManager instance = new InputManager();
    
    private boolean[] keyPressed;
    private boolean[] keyReleased;
    
    private InputManager () {
        keyPressed = new boolean[256];
        keyReleased = new boolean[256];
    }
    
    static InputManager getInstance() {
        return instance;
    }
    
    @Override
    public void keyPressed (KeyEvent e) {
        keyPressed[e.getKeyCode()] = true;
        keyReleased[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyReleased (KeyEvent e) {
        keyReleased[e.getKeyCode()] = true;
        keyPressed[e.getKeyCode()] = false;
    }
}
