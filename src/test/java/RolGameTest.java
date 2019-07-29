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
        Assert.assertEquals(true, game.getHero("Warrior") instanceof Object);
        Assert.assertEquals("Warrior", game.getHero("Warrior").getType());
    }

    @Test
    public void aHeroTypeIsWizard(){
        RolGame game = new RolGame();
        Assert.assertEquals(true, game.getHero("Wizard") instanceof Object);
        Assert.assertEquals("Wizard", game.getHero("Wizard").getType());
    }
}
