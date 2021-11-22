package model;

import controller.CollisionDetector;
import view.DoodleView;
import view.GameView;
import view.PlatformView;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game implements Fps {
    private final int height = 750;
    private final int width = 500;

    private final Doodle doodle;

    private final GameView view;

    private final CollisionDetector detector;

    private final ArrayList<Monster> monsters;

    private final ArrayList<Platform> platforms;

    private final ArrayList<Fps> movables;

    public Game(Doodle doodle, GameView view, CollisionDetector detector) {
        this.doodle = doodle;
        this.view = view;
        this.detector = detector;

        view.setGame(this);
        detector.setDoodle(doodle);

        view.addDrawable(new DoodleView(doodle));

        newPlatform(100, 600);
        newPlatform(400, 300);
        newPlatform(100, 0);
        newPlatform(400, -300);

        MovingPlatform p1 = new MovingPlatform(this, 200, 400);

        view.addDrawable(new PlatformView(p1));
        detector.addPlatform(p1);

        monsters = new ArrayList<>();
        platforms = new ArrayList<>();
        movables = new ArrayList<>();

        movables.add(doodle);
        movables.add(p1);
    }

    private void newPlatform(int x, int y) {
        Platform p = new Platform(this, x, y);

        view.addDrawable(new PlatformView(p));
        detector.addPlatform(p);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            doodle.setVx(-5);
        }
        if (key == KeyEvent.VK_RIGHT) {
            doodle.setVx(5);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            doodle.setVx(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
            doodle.setVx(0);
        }
    }

    @Override
    public void tick() {
        for (Fps f : movables) {
            f.tick();
        }
    }
}
