package view;

import model.Game;
import model.Doodle;
import controller.GameLoop;

import javax.swing.*;

public class Application extends JFrame {

    public Application(GameView gameView) {

        add(gameView);

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

        Application gameplay = new Application(gameView);

        GameLoop gameLoop = new GameLoop(player, gameView, game);

        while(gameLoop.isAlive()) {}

        gameplay.dispose();
    }
}
