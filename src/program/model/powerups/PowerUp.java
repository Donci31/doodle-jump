package program.model.powerups;

import program.model.Doodle;
import program.model.platforms.Platform;

/**
 * Interface, amí segít megvalósítani az erősítéseket
 * strategy minta segítségével
 */
public interface PowerUp {
    void hitBy(Platform platform, Doodle doodle);
}
