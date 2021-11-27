package view;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {
        setSize(500, 750);



        setTitle("Doodle jump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}
