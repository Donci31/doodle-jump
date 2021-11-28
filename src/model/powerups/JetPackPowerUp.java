package model.powerups;

import model.Doodle;
import model.platforms.Platform;
import model.states.JetPackState;

/**
 * Egy rakéta van a platformon
 */
public class JetPackPowerUp implements PowerUp {
    /**
     * Ütközésnél rárak egy rakétát a doodle-re
     * Törli a platformról a rakétát
     * @param platform Platform, ami tartalmazza ezt
     * @param doodle Doodle, akivel ütközik
     */
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setDoodleState(new JetPackState(doodle));
        platform.removePowerUp();
    }
}
