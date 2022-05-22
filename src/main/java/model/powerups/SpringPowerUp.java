package model.powerups;

import model.Doodle;
import model.platforms.Platform;

/**
 * Rugó van a platformon
 */
public class SpringPowerUp implements PowerUp {
    /**
     * Ad egy nagyobb löketet a doodle-nek
     * @param platform Ütköző platform
     * @param doodle   Ütköző doodle
     */
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setVy(-35);
    }
}
