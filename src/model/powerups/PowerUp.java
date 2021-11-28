package model.powerups;

import model.Doodle;
import model.platforms.Platform;

/**
 * Interface, amí segít megvalósítani az erősítéseket
 * strategy minta segítségével
 */
public interface PowerUp {
    void hitBy(Platform platform, Doodle doodle);
}
