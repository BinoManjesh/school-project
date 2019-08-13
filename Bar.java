import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Bar extends KeyAdapter {
    
    private static final int VELOCITY = 50;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 10;
    
    private final int right;
    private final int left;
    
    private Vector position;
    private int dir;
    
    Bar(int right, int left, int yPos) {
        this.right = right;
        this.left = left;
        
        position = new Vector();
        position.y = yPos;
        dir = 0;
    }
    
    void update (float delta) {
        position.x += VELOCITY * dir * delta;
    }
    
    @Override
    public void keyPressed (KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode == right) {
            dir = 1;
        } else if (keyCode == left) {
            dir = -1;
        }
    }
    
    @Override
    public void keyReleased (KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode == right || keyCode == left) {
            dir = 0;
        }
    }
}
