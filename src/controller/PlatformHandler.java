package controller;

import model.*;
import model.platforms.FragilePlatform;
import model.platforms.MovingPlatform;
import model.platforms.Platform;
import model.powerups.SpringPowerUp;
import view.DrawAble;
import view.FragilePlatformView;
import view.MovingPlatformView;
import view.PlatformView;

import java.util.ArrayList;
import java.util.Random;

public class PlatformHandler {

    CollisionDetector detector;
    ArrayList<DrawAble> drawAbles;
    ArrayList<Fps> movables;


    public PlatformHandler(CollisionDetector detector, ArrayList<DrawAble> drawAbles, ArrayList<Fps> movables) {
        this.detector = detector;
        this.drawAbles = drawAbles;
        this.movables = movables;


        newPlatform(100, 600);

        newPlatform(300, 300);

        newPlatform(100, 0);

        newPlatform(300, -300);
    }

    public void newPlatform(int x, int y) {
        Platform p;

        double outcome = new Random().nextDouble();

        if (outcome < 0.8) {
            p = new Platform(x, y);
            PlatformView pView = new PlatformView(p);
            drawAbles.add(pView);
            p.setView(pView);
        } else {
            p = new MovingPlatform(x, y);
            MovingPlatformView pView = new MovingPlatformView(p);
            drawAbles.add(pView);
            p.setView(pView);
        }

        p.setPowerUp(new SpringPowerUp());

        detector.addPlatform(p);
        movables.add(p);
    }

    public void checkPlatforms() {
        ArrayList<Platform> platforms = detector.getPlatforms();

        for (int i = 0; i < platforms.size(); i++) {
            Platform plat = platforms.get(i);
            if (plat.getY() > 700) {
                platforms.remove(plat);
                drawAbles.remove(plat.getView());
                movables.remove(plat);
            }
        }
    }
}
