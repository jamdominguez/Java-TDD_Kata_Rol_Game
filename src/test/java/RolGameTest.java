import org.junit.Assert;
import org.junit.Test;

public class RolGameTest {

    @Test
    public void twoHeroesToChose(){
        RolGame game = new RolGame();
        Assert.assertEquals(2, game.getHeroes().length);
    }

    @Test
    public void aHeroTypeIsWarrior(){
        RolGame game = new RolGame();
        Assert.assertEquals(true, game.getHero("warrior") instanceof Object);
        Assert.assertEquals("Warrior", game.getHero("warrior").getType());
    }
}
