package view.powerupviews;

import javax.swing.*;
import java.awt.*;

/**
 * Trambulin kinézete
 */
public class TrampolineView extends PowerUpView {

    private Image image;

    public TrampolineView() {
        image = new ImageIcon(new ImageIcon("./resources/trampoline.png").getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH)).getImage();
    }

    /**
     * Kirajzolja a trambulint
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y - 40, null);
    }
}
