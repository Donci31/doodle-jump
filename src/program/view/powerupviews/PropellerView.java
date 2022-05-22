package program.view.powerupviews;

import program.view.DoodleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Propeller kinézete
 */
public class PropellerView extends PowerUpView{

    private static Image image;

    static {
        try {
            image = ImageIO.read(PropellerView.class.getClassLoader().getResource("propeller.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kirajzolja a propellert
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x + 15, y - 35, 70, 35, null);
    }
}
