package view.powerupviews;

import java.awt.*;

public class PropellerView extends PowerUpView{
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawArc(x + 30, y - 20, 40, 40, 0, 180);
        g2d.setColor(Color.blue);
        g2d.fillArc(x + 30, y - 20, 40, 40, 0, 180);
    }
}
