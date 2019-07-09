package moving_ball;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputManager extends KeyAdapter {

    private static InputManager instance = new InputManager();

    private boolean[] keyPressed;

    protected InputManager() {
        keyPressed = new boolean[256];
    }

    public static InputManager getInstance() {
        return instance;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode <= 256) {
            keyPressed[keyCode] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode <= 256) {
            keyPressed[keyCode] = false;
        }
    }

    public boolean getKeyPressed(int keyCode) {
        if (keyCode >= 0 && keyCode <= 256) {
            return keyPressed[keyCode];
        } else {
            return false;
        }
    }
}
