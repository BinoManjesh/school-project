abstract class Animation {

    private float startTime;

    private static final int MAX_FPS = 60;
    private static final float MIN_DELTA = 1f / MAX_FPS;

    Animation () {
        startTime = 0;
    }

    abstract void render (float delta);

    private void clearScreen () {
        System.out.println("\u000C");
    }

    public void animate () {
        // if (startTime == -1) {
            // startTime = System.nanoTime();
        // }
        while (true) {
            float delta;
            // do {
                delta = (System.nanoTime() - startTime) * 1e-9f;
            // } while (delta < MIN_DELTA);
            if (delta < 0.016666668)
                delta = delta;
            startTime = System.nanoTime();
            clearScreen();
            render(delta);
        }
    }
}
