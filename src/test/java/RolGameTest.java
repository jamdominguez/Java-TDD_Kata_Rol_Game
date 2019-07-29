import org.junit.Assert;
import org.junit.Test;

public class RolGameTest {

    @Test
    public void twoHeroesToChose(){
        RolGame game = new RolGame();
        Assert.assertEquals(2, game.getHeroes().length);
    }
}
