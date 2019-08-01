import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class RolGameTest {

    @Test
    public void RQ1_gameHasAPlayer(){
        RolGame game = new RolGame();
        Assert.assertEquals(null, game.getPlayer());
        game.addPlayer("ZoroHD");
        Assert.assertEquals(true, game.getPlayer() instanceof Player);
        Assert.assertEquals("ZoroHD", game.getPlayer().getId());
    }

    @Test
    public void RQ2_twoHeroesToChose() {
        Assert.assertEquals(2, RolGame.getHeroes().size());
    }

    @Test
    public void RQ2_aHeroTypeIsWarrior() {
        Assert.assertEquals(true, RolGame.getHero("Warrior") instanceof Hero);
        Assert.assertEquals("Warrior", RolGame.getHero("Warrior").getType());
    }

    @Test
    public void RQ2_aHeroTypeIsWizard() {
        Assert.assertEquals(true, RolGame.getHero("Wizard") instanceof Hero);
        Assert.assertEquals("Wizard", RolGame.getHero("Wizard").getType());
    }

    @Test
    public void RQ3_oneEnemyInGame() {
        Assert.assertEquals(1, RolGame.getEnemies().size());
    }

    @Test
    public void RQ3_aEnemyTypeIsOrc() {
        Assert.assertEquals(true, RolGame.getEnemy("Orc") instanceof Enemy);
        Assert.assertEquals("Orc", RolGame.getEnemy("Orc").getType());
    }

/*    @Test
    public void playerSelectOneHero(){
        RolGame game = new RolGame();
        Assert.assertArrayEquals(0, game.getPlayerHeroes());
    }*/
}
