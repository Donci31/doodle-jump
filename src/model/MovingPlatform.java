package model;

public class MovingPlatform extends Platform implements Fps{

    private int velX;

    public MovingPlatform(Game game, int x, int y) {
        super(game, x, y);
        velX = 2;
    }

    @Override
    public void tick() {
        if (velX > 0 && x >= 400 || velX < 0 && x <= 0) {
            velX *= -1;
        }
        x += velX;
    }
}
