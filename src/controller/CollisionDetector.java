package controller;

import model.Doodle;
import model.Monster;
import model.Platform;

import java.awt.*;
import java.util.ArrayList;

public class CollisionDetector {
    private final Doodle doodle;

    private final ArrayList<Monster> monsters;

    private final ArrayList<Platform> platforms;

    public CollisionDetector(Doodle doodle) {
        this.doodle = doodle;
        monsters = new ArrayList<>();
        platforms = new ArrayList<>();
    }

    public void addPlatform(Platform p) {
        platforms.add(p);
    }

    private boolean intersects(Rectangle a, Rectangle b) {
        return a.x < b.x + b.width && a.x + a.width > b.x &&
                a.y < b.y + b.height && a.y + a.height > b.y;
    }

    public void doodlePlatformCollision() {
        for (Platform p : platforms) {
            if (intersects(doodle.getBounds(), p.getBounds()) && doodle.getVy() > 0) {
                p.hitBy(doodle);
            }
        }
    }
}
