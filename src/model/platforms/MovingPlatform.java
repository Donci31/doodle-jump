package model.platforms;

import model.Fps;

public class MovingPlatform extends Platform implements Fps {

    private int vx;

    public MovingPlatform(int x, int y) {
        super(x, y);
        vx = 2;
    }

    @Override
    public void tick() {
        super.tick();
        if (vx > 0 && x >= 400 || vx < 0 && x <= 0) {
            vx *= -1;
        }
        x += vx;
    }
}
