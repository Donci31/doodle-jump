import controller.CollisionDetector;
import model.Doodle;
import model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import view.GameView;

public class GameTest {
    Doodle doodle;
    Game game;

    @Before
    public void setUp() {
        doodle = new Doodle(100, 100);
        game = new Game(doodle, new GameView(), new CollisionDetector());
    }

    @Test
    public void testGravity() {
        Assert.assertEquals(Game.getGravity(), 1);
    }

    @Test
    public void testScrolldown() {
        doodle.setVy(-1);
        game.tick();
        Assert.assertEquals(Game.getScrollDownSpeed(), 1);
    }
}
