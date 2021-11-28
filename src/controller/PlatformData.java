package controller;

/**
 * Platformokról tartalmaz információt
 */
public class PlatformData {
    public String type;
    public String powerUp;
    public int x;
    public int y;

    public PlatformData(String type, String powerUp, int x, int y) {
        this.type = type;
        this.powerUp = powerUp;
        this.x = x;
        this.y = y;
    }
}
