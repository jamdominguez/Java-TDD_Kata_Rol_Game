import org.junit.Assert;
import org.junit.Test;

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
    public void RQ2_playerSelectOneHero(){
        RolGame game = new RolGame();
        //Add a player
        game.addPlayer("Player1");
        //When start no heroes assigned to the player
        Assert.assertEquals(0, game.getPlayerHeroes().size());
        //Player select the Warrior Hero
        game.getPlayer().select("Warrior");
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals("Warrior", game.getPlayerHeroes().get(0).getType());
        //Player select the Wizard Hero (only 1, the Warrior is removed, the Wizard is added)
        game.getPlayer().select("Wizard");
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals("Wizard", game.getPlayerHeroes().get(0).getType());
    }

    @Test
    public void RQ2_resetHeroSelection(){
        RolGame game = new RolGame();
        //Add a player
        game.addPlayer("Player1");
        //When start no heroes assigned to the player
        Assert.assertEquals(0, game.getPlayerHeroes().size());
        //Player select the Warrior Hero
        game.getPlayer().select("Warrior");
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals("Warrior", game.getPlayerHeroes().get(0).getType());
        //Remove selection
        game.getPlayer().resetHeroSelection();
        Assert.assertEquals(0, game.getPlayerHeroes().size());
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
}
