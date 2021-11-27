package model.powerups;

import model.Doodle;
import model.platforms.Platform;

public interface PowerUp {
    void hitBy(Platform platform, Doodle doodle);
}
