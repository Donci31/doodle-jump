package program.model.powerups;

import program.model.Doodle;
import program.model.platforms.Platform;

/**
 * Platformok normál működése
 */
public class DefaultPowerUp implements PowerUp {

    /**
     * Ad egy löketet a doodle-nek
     * @param platform Platform, ami tartalmazza ezt
     * @param doodle Doodle, akivel ütközik
     */
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setVy(-25);
    }
}
