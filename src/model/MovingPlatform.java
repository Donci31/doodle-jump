package model;

public class MovingPlatform extends Platform implements Fps{

    private int velX;

    public MovingPlatform(int x, int y) {
        super(x, y);
        velX = 2;
    }

    @Override
    public void tick() {
        super.tick();
        if (velX > 0 && x >= 400 || velX < 0 && x <= 0) {
            velX *= -1;
        }
        x += velX;
    }
}
