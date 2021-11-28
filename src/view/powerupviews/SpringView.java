package view.powerupviews;

import javax.swing.*;
import java.awt.*;

/**
 * Rugó kinézete
 */
public class SpringView extends PowerUpView {

    private Image image;

    public SpringView() {
        image = new ImageIcon(new ImageIcon("./resources/spring.png").getImage().getScaledInstance(40, 20, Image.SCALE_SMOOTH)).getImage();
    }
    /**
     * Kirajzolja a rugót
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x + 30, y - 20, null);
    }
}
