package model.powerups;

import model.Doodle;
import model.platforms.Platform;
import model.states.TrampolineState;

/**
 * Trambulin van a platformon
 */
public class TrampolinePowerUp implements PowerUp {
    /**
     * Ütközéskor beállítja a doodle állapotát trambulin állapotra
     * @param platform Platform, ami tartalmazza ezt
     * @param doodle Doodle, akivel ütközik
     */
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setDoodleState(new TrampolineState(doodle));
    }
}
