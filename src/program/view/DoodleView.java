package program.view;

import program.model.Doodle;

import javax.swing.*;
import java.awt.*;

/**
 * Doodle kinézete
 */
public class DoodleView implements DrawAble {

    private Doodle source;

    private Image currentImage;

    private Image normalImage;
    private Image shootImage;

    public DoodleView(Doodle source) {
        this.source = source;

        normalImage = new ImageIcon(new ImageIcon("./resources/Doodle2.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_SMOOTH)).getImage();
        shootImage = new ImageIcon(new ImageIcon("./resources/DoodleShoot.png").getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)).getImage();
        currentImage = normalImage;
    }

    /**
     * Vált a doodle lövő kinézetére
     */
    public void shoot() {
        currentImage = shootImage;
    }

    /**
     * Vált a doodle eredeti kinézetére
     */
    public void unShoot() {
        currentImage = normalImage;
    }

    /**
     * Kirajzolja a doodlet
     * @param g Graphics osztály
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(currentImage, source.getX(), source.getY(), null);
    }
}
