package program.model.powerups;

import program.model.Doodle;
import program.model.platforms.Platform;

public class SpringPowerUp implements PowerUp {
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setVy(-35);
    }
}
