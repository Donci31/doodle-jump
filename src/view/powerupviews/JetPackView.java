package view.powerupviews;

import java.awt.*;

public class JetPackView extends PowerUpView {
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x + 40, y - 75, 20, 75);
        g2d.setColor(Color.red);
        g2d.fillRect(x + 40, y - 75, 20, 75);
    }
}
