package program.model;

import program.controller.CollisionDetector;
import program.view.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Játék logikáját kezelő osztály
 */
public class Game implements Fps {

    private static int scrollDownSpeed; // görgetési sebesség

    private static final int gravity = 1; // gravitáció

    private final Doodle doodle; // Játékos által irányított doodle

    private final ArrayList<Fps> movables; // Minden mozgó objektum

    public Game(Doodle doodle, GameView view, CollisionDetector detector) {
        this.doodle = doodle;
        movables = new ArrayList<>();

        view.setGame(this);

        DoodleView doodleView = new DoodleView(doodle);

        view.addDrawable(doodleView);

        doodle.setDoodleView(doodleView);

        detector.setDoodle(doodle);

        movables.add(doodle);
    }

    public ArrayList<Fps> getMovables() {
        return movables;
    }

    public static int getGravity() {
        return gravity;
    }

    public static int getScrollDownSpeed() {
        return scrollDownSpeed;
    }

    public static void setScrollDownSpeed(int scrollDownSpeed) {
        Game.scrollDownSpeed = scrollDownSpeed;
    }

    public void keyPressed(KeyEvent e) {
        doodle.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        doodle.keyReleased(e);
    }

    /**
     * Ha a doodle egy bizonyos pont felé megy, lejjebb görgeti a képernyőt.
     * Frissíti a játékon belüli összes mozgó dolog helyzetét.
     */
    @Override
    public void tick() {
        if (doodle.getY() < 200 && doodle.getVy() < 0) {
            Game.setScrollDownSpeed(-doodle.getVy());
        } else {
            Game.setScrollDownSpeed(0);
        }

        for (Fps f : movables) {
            f.tick();
        }
    }
}
