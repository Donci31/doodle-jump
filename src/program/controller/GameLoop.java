package program.controller;

import program.model.Doodle;
import program.model.Game;
import program.view.Application;
import program.view.GameView;

/**
 * 60 Fps-el működteti a játkban szereplő kontrollereket,
 * meg a mozogni képes dolgokat
 */
public class GameLoop extends Thread {
    private final Doodle doodle;
    private final GameView view;
    private final Game game;
    private Application app;

    private final CollisionDetector collision;
    private final PlatformHandler platformHandler;
    private final BulletHandler bulletHandler;
    private final MonsterHandler monsterHandler;

    public GameLoop(Doodle doodle, GameView view, Game game, CollisionDetector collision) {
        this.doodle = doodle;
        this.view = view;
        this.game = game;
        this.collision = collision;

        platformHandler = new PlatformHandler(collision, view.getDrawList(), game.getMovables());

        bulletHandler = new BulletHandler(collision, view.getDrawList(), game.getMovables());

        monsterHandler = new MonsterHandler(collision, view.getDrawList(), game.getMovables());

        doodle.setBulletHandler(bulletHandler);
    }

    public void setApp(Application app) {
        this.app = app;
    }

    /**
     * Ha a Doodle életben van, akkor egy eseményhurokban frissíti a képernyőt
     */
    @Override
    public void run() {
        while (doodle.isAlive()) {
            try {
                Thread.sleep(17);
                view.repaint(0, 0, 500, 750);
                game.tick();
                collision.checkCollisions();
                platformHandler.checkPlatforms();
                bulletHandler.checkBullets();
                monsterHandler.checkMonsters();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        app.dispose();
    }
}
