import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class RolGameTest {

    @Test
    public void twoHeroesToChose(){
        RolGame game = new RolGame();
        Assert.assertEquals(2, game.getHeroes().size());
    }

    @Test
    public void aHeroTypeIsWarrior(){
        RolGame game = new RolGame();
        Assert.assertEquals(true, game.getHero("Warrior") instanceof Hero);
        Assert.assertEquals("Warrior", game.getHero("Warrior").getType());
    }

    @Test
    public void aHeroTypeIsWizard(){
        RolGame game = new RolGame();
        Assert.assertEquals(true, game.getHero("Wizard") instanceof Hero);
        Assert.assertEquals("Wizard", game.getHero("Wizard").getType());
    }

/*    @Test
    public void playerSelectOneHero(){

    }*/
}
