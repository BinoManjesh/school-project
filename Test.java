import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

class Test extends JFrame {

    private Ball[] balls;

    private Test() {
        super("sfdf");
        setSize(500, 500);        
        balls = new Ball[4];
        balls[0] = new Ball(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, 0, 0, Color.RED);
        balls[1] = new Ball(KeyEvent.VK_T, KeyEvent.VK_F, KeyEvent.VK_G, KeyEvent.VK_H, 50, 0, Color.BLUE);
        balls[2] = new Ball(KeyEvent.VK_I, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, 100, 0, Color.GREEN);
        balls[3] = new Ball(KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, 200, 0, Color.YELLOW);
        for (Ball ball : balls) {
            addKeyListener(ball);
        }
        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        new Test().run();
    }

    private void run() throws InterruptedException{
        long startTime = System.nanoTime();
        while(true) {            
            for (Ball ball : balls) {
                float delta = (System.nanoTime() - startTime) * 1e-9f;
                ball.update(delta);
            }
            for(int i = 0; i < balls.length; i++) {
                Ball ball = balls[i];
                for(int j = i + 1; j < balls.length; j++) {
                    ball.collide(balls[j]);
                }
            }
            startTime = System.nanoTime();
            repaint();          
        }
    }

    @Override
    public void paint(Graphics g) {
        for (Ball ball : balls) {
            ball.render(g);
        }
    }
}

