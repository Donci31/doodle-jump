package view.powerupviews;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Rugó kinézete
 */
public class SpringView extends PowerUpView {

    private static Image image;

    static {
        try {
            image = ImageIO.read(SpringView.class.getClassLoader().getResource("spring.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kirajzolja a rugót
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x + 30, y - 20, 40, 20, null);
    }
}
