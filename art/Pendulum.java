package art;

import java.awt.*;

class Pendulum extends Game {
    
    private Bob bob;
    
    Pendulum() {
        bob = new Bob(new Vector<Float>(200f, 0f), new Vector<Float>(300f, 0f));
    }

    public static void main(String[] args) {
        Pendulum game = new Pendulum();
        game.start();
    }
    
    void update(float dt) {
        bob.update(dt);
    }
    
    void draw(Graphics g) {
        bob.draw(g);
    }
}
