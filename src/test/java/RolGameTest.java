import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class RolGameTest {

    @Test
    public void twoHeroesToChose() {
        Assert.assertEquals(2, RolGame.getHeroes().size());
    }

    @Test
    public void aHeroTypeIsWarrior() {
        Assert.assertEquals(true, RolGame.getHero("Warrior") instanceof Hero);
        Assert.assertEquals("Warrior", RolGame.getHero("Warrior").getType());
    }

    @Test
    public void aHeroTypeIsWizard() {
        Assert.assertEquals(true, RolGame.getHero("Wizard") instanceof Hero);
        Assert.assertEquals("Wizard", RolGame.getHero("Wizard").getType());
    }

/*    @Test
    public void playerSelectOneHero(){
        RolGame game = new RolGame();
        Assert.assertArrayEquals(0, game.getPlayerHeroes());

    }*/
}
