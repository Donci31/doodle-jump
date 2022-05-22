package program.view.powerupviews;

import program.view.DoodleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Jetpack kinézete
 */
public class JetPackView extends PowerUpView {

    private static Image image;

    static {
        try {
            image = ImageIO.read(JetPackView.class.getClassLoader().getResource("jetpack.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kirajzolja a jetpacket
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x + 30, y - 75, 40, 75, null);
    }
}
