package model.powerups;

import model.Doodle;
import model.platforms.Platform;

/**
 * Interface, amí segít megvalósítani az erősítéseket
 * strategy minta segítségével
 */
public interface PowerUp {
    /**
     * Lekezeli az ütközést a doodle-el
     * @param platform Ütköző platform
     * @param doodle Ütköző doodle
     */
    void hitBy(Platform platform, Doodle doodle);
}
