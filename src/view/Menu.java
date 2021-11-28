package view;

import controller.CollisionDetector;
import controller.GameLoop;
import model.Doodle;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    JLabel l1;

    JPanel p1;

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Doodle player = new Doodle(300, 100);

            GameView gameView = new GameView();

            CollisionDetector collisionDetector = new CollisionDetector();

            Game game = new Game(player, gameView, collisionDetector);

            GameLoop gameLoop = new GameLoop(player, gameView, game, collisionDetector);

            Application gameplay = new Application(gameView);

            gameLoop.setApp(gameplay);

            gameLoop.start();
        }
    }

    public Menu() {
        setSize(500, 750);

        l1 = new JLabel(new ImageIcon(new ImageIcon("./resources/Logo.jpg").getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH)));

        p1 = new JPanel();

        p1.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(20, 0, 0, 0);

        JButton b1 = new JButton("Play");
        constraints.gridy = 0;
        b1.setPreferredSize(new Dimension(200, 100));
        b1.addActionListener(new ButtonListener());
        p1.add(b1, constraints);

        JButton b2 = new JButton("Exit");

        constraints.gridy = 1;
        b2.setPreferredSize(new Dimension(200, 100));
        b2.addActionListener(e -> dispose());
        p1.add(b2, constraints);

        add(l1, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);

        setTitle("Doodle jump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}
