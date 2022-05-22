import model.Monster;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class MonsterTest {
    Monster monster;

    @Before
    public void setUp() {
        monster = new Monster(100, 100);
    }

    @Test
    public void testBounds() {
        Assert.assertEquals(monster.getBounds(), new Rectangle(100, 100, 135, 75));
    }

    @Test
    public void testAlive() {
        Assert.assertTrue(monster.isAlive());
        monster.die();
        Assert.assertNotEquals(monster.isAlive(), true);
    }

    @Test
    public void testTick() {
        monster.tick();
        Assert.assertEquals(monster.getX(), 103);
    }
}
