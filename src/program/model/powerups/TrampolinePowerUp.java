package program.model.powerups;

import program.model.Doodle;
import program.model.platforms.Platform;
import program.model.states.TrampolineState;

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
