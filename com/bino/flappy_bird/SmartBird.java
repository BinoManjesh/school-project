package com.bino.flappy_bird;

class SmartBird extends Bird {

    private Brain brain;

    SmartBird(Pipes pipes) {
        super(pipes);
        brain = new Brain();
    }

    SmartBird(Pipes pipes, SmartBird b1, SmartBird b2) {
        super(pipes);
        brain = new Brain(b1.brain, b2.brain);
    }

    @Override
    public String toString() {
        return brain.toString();
    }

    @Override
    void update(float delta) {
        super.update(delta);
        final float x = getX();
        final float y = getY();
        final float width = getWidth();
        //12.717331 76.591705 55.018143 -6.453064 -31.995163 -75.02121
        //-55.89783 -26.28453 65.57802 -57.243645 84.81842 46.57158
        //93.17485 72.10228 -64.42024 20.82943 -76.08127 31.849655
        //----------------------------------
        final float height = getHeight();
        final float velY = vel.y;
        final float distFromGround = getY();
        final float horDist = x + width - (pipes.nearest.x);
        final float vertDist1 = y - (pipes.nearest.rect1.y + pipes.nearest.rect1.height);
        final float vertDist2 = y + height - pipes.nearest.rect2.y;
        if (brain.shouldJump(velY, distFromGround, horDist, vertDist1, vertDist2)) {
            jump();
        }
    }
}
