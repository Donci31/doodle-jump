package controller;

import model.Fps;
import model.Monster;
import view.DrawAble;
import view.MonsterView;

import java.util.List;

/**
 * Szörnyeket kezeli
 */
public class MonsterHandler {
    CollisionDetector detector;
    List<DrawAble> drawAbles;
    List<Fps> movables;

    public MonsterHandler(CollisionDetector detector, List<DrawAble> drawAbles, List<Fps> movables) {
        this.detector = detector;
        this.drawAbles = drawAbles;
        this.movables = movables;
    }

    /**
     * Új szörnyet helyet a játékba
     * @param x Szörny x koordinátája
     * @param y Szörny y koordinátája
     */
    public void newMonster(int x, int y) {
        Monster m;

        m = new Monster(x, y);
        MonsterView mView = new MonsterView(m);
        drawAbles.add(mView);
        m.setView(mView);

        detector.addMonster(m);
        movables.add(m);
    }

    /**
     * Ha egy szörny kikerül a képernyőről,
     * vagy ha egy lövedék eltalálja törli a játékból
     */
    public void checkMonsters() {
        List<Monster> monsters = detector.getMonsters();

        for (int i = 0; i < monsters.size(); i++) {
            Monster m = monsters.get(i);
            if (m.getY() > 700 || !m.isAlive()) {
                monsters.remove(m);
                drawAbles.remove(m.getView());
                movables.remove(m);
            }
        }
        if (monsters.size() < 1) {
            newMonster(100, - 800);
        }
    }
}
