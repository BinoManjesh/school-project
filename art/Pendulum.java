package art;

import java.awt.*;

class Pendulum extends Game {
    
    public static void main() {
        Pendulum game = new Pendulum();
        game.start();
    }
    
    void update(float dt) {
        System.out.println(dt);
    }
}
