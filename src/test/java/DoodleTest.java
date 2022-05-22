import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import program.model.Doodle;

import java.awt.*;

public class DoodleTest {
    Doodle doodle;

    @Before
    public void setUp() {
        doodle = new Doodle(100, 100);
    }

    @Test
    public void testHitbox() {
        Assert.assertEquals(doodle.getHitbox(), new Rectangle(100, 100, 125, 150));
    }

    @Test
    public void testBounds() {
        Assert.assertEquals(doodle.getBounds(), new Rectangle(100, 200, 125, 50));
    }

    @Test
    public void testAlive() {
        Assert.assertTrue(doodle.isAlive());
        doodle.die();
        Assert.assertNotEquals(doodle.isAlive(), true);
    }

    @Test
    public void testTick() {
        doodle.tick();
        Assert.assertEquals(doodle.getVy(), 1);
        Assert.assertEquals(doodle.getX(), 100);
        Assert.assertEquals(doodle.getY(), 101);
    }
}