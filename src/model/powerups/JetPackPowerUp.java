package model.powerups;

import model.Doodle;
import model.platforms.Platform;
import model.states.JetPackState;

public class JetPackPowerUp implements PowerUp {
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setDoodleState(new JetPackState(doodle));
        platform.removePowerUp();
    }
}
