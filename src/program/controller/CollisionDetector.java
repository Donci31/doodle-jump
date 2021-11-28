package program.controller;

import program.model.Bullet;
import program.model.Doodle;
import program.model.Monster;
import program.model.platforms.Platform;

import java.awt.*;
import java.util.ArrayList;

/**
 * Játékban található ütközéseket kezeli
 */
public class CollisionDetector {
    private Doodle doodle;

    private final ArrayList<Monster> monsters;

    private final ArrayList<Platform> platforms;

    private final ArrayList<Bullet> bullets;

    public CollisionDetector() {
        monsters = new ArrayList<>();
        platforms = new ArrayList<>();
        bullets = new ArrayList<>();
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setDoodle(Doodle doodle) {
        this.doodle = doodle;
    }

    public void addPlatform(Platform p) {
        platforms.add(p);
    }

    public void addBullet(Bullet b) {
        bullets.add(b);
    }

    public void addMonster(Monster m) {
        monsters.add(m);
    }

    /**
     * Megnézi hogy két dolog hitboxa ütközik-e
     * @param a Egyik dolog hitboxa téglalapként
     * @param b Másik dolog hitboxa téglalapként
     * @return igaz ha metszik egymást
     */
    private boolean intersects(Rectangle a, Rectangle b) {
        return a.x < b.x + b.width && a.x + a.width > b.x &&
                a.y < b.y + b.height && a.y + a.height > b.y;
    }

    /**
     * Kezeli a Doodle platform ütközéseket
     */
    private void doodlePlatformCollision() {
        for (Platform p : platforms) {
            if (intersects(doodle.getBounds(), p.getBounds()) && doodle.getVy() > 0) {
                p.hitBy(doodle);
            }
        }
    }

    /**
     * Kezeli a Doodle szörny ütközéseket
     */
    private void doodleMonsterCollision() {
        for (Monster m : monsters) {
            if (intersects(doodle.getHitbox(), m.getBounds())) {
                doodle.die();
            }
        }
    }

    /**
     * Kezeli a lövedék szörny ütközéseket
     */
    private void bulletMonsterCollision() {
        for (Monster monster : monsters) {
            for (Bullet bullet : bullets) {
                if (intersects(bullet.getBounds(), monster.getBounds())) {
                    monster.die();
                    bullet.hit();
                }
            }
        }
    }

    /**
     * Előző privát függvények segítségével kezel minden ütközést
     */
    public void checkCollisions() {
        doodlePlatformCollision();
        doodleMonsterCollision();
        bulletMonsterCollision();
    }
}
