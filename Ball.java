class Ball extends Animation {
    
    private float angle;
    private float velocity;
    private static final float RADIUS = 10;
    
    Ball () {
        angle = 0;
        velocity = 360;
    }

    @Override
    void render (float delta) {
        angle += velocity * delta;
        for (int i = 0; i < RADIUS * (1 + Math.sin(angle * Math.PI / 180)); i++) {
            System.out.println();
        }
        for (int i = 0; i < 2.5f * RADIUS * (1 + Math.cos(angle * Math.PI / 180)); i++) {
            System.out.print(" ");
        }
    }
    
    static void main() {
        Ball ball = new Ball();
        ball.animate();
    }
}
