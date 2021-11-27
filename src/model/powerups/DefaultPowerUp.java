package model.powerups;

import model.Doodle;
import model.platforms.Platform;

public class DefaultPowerUp implements PowerUp {
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setVy(-25);
    }
}
