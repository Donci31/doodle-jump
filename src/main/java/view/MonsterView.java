package view;

import model.Monster;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Szörny kinézete
 */
public class MonsterView implements DrawAble {
    private Monster source;

    private static Image image;

    static {
        try {
            image = ImageIO.read(MonsterView.class.getClassLoader().getResource("Monster.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    public MonsterView(Monster source) {
        this.source = source;
    }

    /**
     * Kirajzolja a szörnyet
     * @param g Graphics osztály
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, source.getX(), source.getY(), source.getWidth(), source.getHeight(), null);
    }
}
