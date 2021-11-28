package view.powerupviews;

import java.awt.*;

public class TrampolineView extends PowerUpView {
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x + 25, y - 10, 50, 10);
        g2d.setColor(Color.red);
        g2d.fillRect(x + 25, y - 10, 50, 10);
    }
}
