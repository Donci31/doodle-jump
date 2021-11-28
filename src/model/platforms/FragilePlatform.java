package model.platforms;

import model.Doodle;

/**
 * Törékeny platform logikáját kezelő osztály
 */
public class FragilePlatform extends Platform {

    public FragilePlatform(int x, int y) {
        super(x, y);
    }

    /**
     * Ütközéskor átengedi magán a doodlet
     * @param doodle Platformmal ütköző doodle
     */
    public void hitBy(Doodle doodle) {
    }
}
