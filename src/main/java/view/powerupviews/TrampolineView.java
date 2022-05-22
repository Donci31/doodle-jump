package view.powerupviews;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Trambulin kinézete
 */
public class TrampolineView extends PowerUpView {

    private static Image image;

    static {
        try {
            image = ImageIO.read(TrampolineView.class.getClassLoader().getResource("trampoline.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kirajzolja a trambulint
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y - 40, 100, 40, null);
    }
}
