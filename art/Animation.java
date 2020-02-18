package art;

abstract class Animation extends Canvas {

    abstract void update(double dt);

    void start() {
        long prevTime = System.nanoTime();
        while (super.isVisible()) {
            long time = System.nanoTime();
            double dt = (time - prevTime) * 1e-9f;
            update(dt);
            repaint();
            prevTime = time;
        }
    }
}
