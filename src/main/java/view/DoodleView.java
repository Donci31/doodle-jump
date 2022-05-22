package view;

import model.Doodle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Doodle kinézete
 */
public class DoodleView implements DrawAble {

    private Doodle source;

    private Image currentImage;

    private static Image normalImage;

    static {
        try {
            normalImage = ImageIO.read(DoodleView.class.getClassLoader().getResource("Doodle.png"));
            shootImage = ImageIO.read(DoodleView.class.getClassLoader().getResource("DoodleShoot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;
    private static Image shootImage;

    public DoodleView(Doodle source) {
        this.source = source;
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
        g2d.drawImage(currentImage, source.getX(), source.getY(), source.getWidth(), source.getHeight(), null);
    }
}
