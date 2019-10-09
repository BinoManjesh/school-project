package com.bino.flappy_bird.entities;

class SmartBird extends Bird {

    Brain brain;

    SmartBird() {
        super();
        brain = new Brain();
    }

    SmartBird(SmartBird b1, SmartBird b2) {
        super();
        brain = new Brain(b1.brain, b2.brain);
    }

    @Override
    public String toString() {
        return brain.toString();
    }

    @Override
    public void update(float delta, PipePair nearest) {
        super.update(delta, nearest);
        final float x = getX();
        final float y = getY();
        final float width = getWidth();
        final float height = getHeight();
        final float velY = velocity.y;
        final float horDist = x + width - (nearest.x);
        final float vertDist1 = y - (nearest.rect1.y + nearest.rect1.height);
        final float vertDist2 = y + height - nearest.rect2.y;
        if (brain.shouldJump(velY, horDist, vertDist1, vertDist2)) {
            jump();
        }
    }
}
