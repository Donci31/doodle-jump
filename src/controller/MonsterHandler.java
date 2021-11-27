package controller;

import model.Fps;
import model.Monster;
import view.DrawAble;
import view.MonsterView;

import java.util.ArrayList;

public class MonsterHandler {
    CollisionDetector detector;
    ArrayList<DrawAble> drawAbles;
    ArrayList<Fps> movables;

    public MonsterHandler(CollisionDetector detector, ArrayList<DrawAble> drawAbles, ArrayList<Fps> movables) {
        this.detector = detector;
        this.drawAbles = drawAbles;
        this.movables = movables;
    }

    public void newMonster(int x, int y) {
        Monster m;

        m = new Monster(x, y);
        MonsterView mView = new MonsterView(m);
        drawAbles.add(mView);
        m.setView(mView);

        detector.addMonster(m);
        movables.add(m);
    }

    public void checkMonsters() {
        ArrayList<Monster> monsters = detector.getMonsters();

        for (int i = 0; i < monsters.size(); i++) {
            Monster m = monsters.get(i);
            if (m.getY() > 700 || !m.isAlive()) {
                monsters.remove(m);
                drawAbles.remove(m.getView());
                movables.remove(m);
            }
        }
    }
}
