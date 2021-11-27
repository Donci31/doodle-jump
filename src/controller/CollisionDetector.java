package controller;

import model.Bullet;
import model.Doodle;
import model.Monster;
import model.platforms.Platform;

import java.awt.*;
import java.util.ArrayList;

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

    private boolean intersects(Rectangle a, Rectangle b) {
        return a.x < b.x + b.width && a.x + a.width > b.x &&
                a.y < b.y + b.height && a.y + a.height > b.y;
    }

    private void doodlePlatformCollision() {
        for (Platform p : platforms) {
            if (intersects(doodle.getBounds(), p.getBounds()) && doodle.getVy() > 0) {
                p.hitBy(doodle);
            }
        }
    }

    private void doodleMonsterCollision() {
        for (Monster m : monsters) {
            if (intersects(doodle.getHitbox(), m.getBounds())) {
                doodle.die();
            }
        }
    }

    private void bulletMonsterCollision() {
        for (Monster monster : monsters) {
            for (Bullet bullet : bullets) {
                if (intersects(bullet.getBounds(), monster.getBounds())) {
                    monster.die();
                }
            }
        }
    }

    public void checkCollisions() {
        doodlePlatformCollision();
        doodleMonsterCollision();
        bulletMonsterCollision();
    }
}
