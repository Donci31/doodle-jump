package view;

import controller.CollisionDetector;
import model.Game;
import model.Doodle;
import controller.GameLoop;
import model.Platform;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application extends JFrame {

    GameView gameView;

    private class ArrowsListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            gameView.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            gameView.keyReleased(e);
        }
    }

    public Application(GameView gameView) {
        this.gameView = gameView;

        add(gameView);

        addKeyListener(new ArrowsListener());

        setSize(500, 750);

        setTitle("Doodle jump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Doodle player = new Doodle();

        Game game = new Game(player);

        GameView gameView = new GameView(game);

        gameView.addDrawable(new DoodleView(player));

        Platform p1 = new Platform(100, 500);

        Platform p2 = new Platform(250, 300);

        gameView.addDrawable(new PlatformView(p1));

        gameView.addDrawable(new PlatformView(p2));

        CollisionDetector collisionDetector = new CollisionDetector(player);

        GameLoop gameLoop = new GameLoop(player, gameView, game, collisionDetector);

        Application gameplay = new Application(gameView);

        collisionDetector.addPlatform(p1);

        collisionDetector.addPlatform(p2);

        while(gameLoop.isAlive()) {}

        gameplay.dispose();
    }
}
