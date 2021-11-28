package view.powerupviews;

import javax.swing.*;
import java.awt.*;

/**
 * Jetpack kinézete
 */
public class JetPackView extends PowerUpView {

    private Image image;

    public JetPackView() {
        image = new ImageIcon(new ImageIcon("./resources/jetpack.png").getImage().getScaledInstance(40, 75, Image.SCALE_SMOOTH)).getImage();
    }

    /**
     * Kirajzolja a jetpacket
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x + 30, y - 75, null);
    }
}
