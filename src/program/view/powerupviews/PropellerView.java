package program.view.powerupviews;

import javax.swing.*;
import java.awt.*;

/**
 * Propeller kinézete
 */
public class PropellerView extends PowerUpView{

    private Image image;

    public PropellerView() {
        image = new ImageIcon(new ImageIcon("./resources/propeller.png").getImage().getScaledInstance(70, 35, Image.SCALE_SMOOTH)).getImage();
    }

    /**
     * Kirajzolja a propellert
     * @param g Graphics osztály
     * @param x x koordináta
     * @param y y koordináta
     */
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x + 15, y - 35, null);
    }
}
