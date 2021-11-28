package view;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu(String[] args) {
        setSize(500, 750);

        JLabel l1 = new JLabel(new ImageIcon(new ImageIcon("./resources/Logo.jpg").getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH)));

        add(l1, BorderLayout.NORTH);

        JPanel p1 = new JPanel();

        p1.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JButton b1 = new JButton("Play");
        constraints.gridy = 0;
        b1.setPreferredSize(new Dimension(200, 100));
        b1.addActionListener(e -> Application.main(args));
        p1.add(b1, constraints);

        JButton b2 = new JButton("Exit");

        constraints.gridy = 1;
        b2.setPreferredSize(new Dimension(200, 100));
        b2.addActionListener(e -> System.exit(0));
        p1.add(b2, constraints);

        add(p1, BorderLayout.CENTER);

        setTitle("Doodle jump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu(args);
    }
}
