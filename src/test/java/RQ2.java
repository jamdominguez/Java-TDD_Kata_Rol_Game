import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

public class RQ2 {
    @Test
    public void RQ2_twoHeroesToChose() {
        Assert.assertEquals(2, RolGame.getHeroes().size());
    }

    @Test
    public void RQ2_aHeroTypeIsWarrior() {
        Assert.assertEquals(true, RolGame.getHero(HeroFactory.HeroClass.WARRIOR) instanceof Hero);
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, RolGame.getHero(HeroFactory.HeroClass.WARRIOR).getHeroClass());
        Assert.assertEquals("Characters.Heroes.Warrior", RolGame.getHero(HeroFactory.HeroClass.WARRIOR).getDescription());
    }

    @Test
    public void RQ2_aHeroTypeIsWizard() {
        Assert.assertEquals(true, RolGame.getHero(HeroFactory.HeroClass.WIZARD) instanceof Hero);
        Assert.assertEquals(HeroFactory.HeroClass.WIZARD, RolGame.getHero(HeroFactory.HeroClass.WIZARD).getHeroClass());
        Assert.assertEquals("Characters.Heroes.Wizard", RolGame.getHero(HeroFactory.HeroClass.WIZARD).getDescription());
    }

    @Test
    public void RQ2_playerSelectOneHero() {
        RolGame game = new RolGame();
        //Add a player
        game.addPlayer("Player1");
        //When start no heroes assigned to the player
        Assert.assertEquals(0, game.getPlayerHeroes().size());
        //Player select the Characters.Heroes.Warrior Characters.Heroes.Hero
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, game.getPlayerHeroes().get(0).getHeroClass());
        //Player select the Characters.Heroes.Wizard Characters.Heroes.Hero (only 1, the Characters.Heroes.Warrior is removed, the Characters.Heroes.Wizard is added)
        game.getPlayer().select(HeroFactory.HeroClass.WIZARD);
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals(HeroFactory.HeroClass.WIZARD, game.getPlayerHeroes().get(0).getHeroClass());
    }

    @Test
    public void RQ2_resetHeroSelection() {
        RolGame game = new RolGame();
        //Add a player
        game.addPlayer("Player1");
        //When start no heroes assigned to the player
        Assert.assertEquals(0, game.getPlayerHeroes().size());
        //Player select the Characters.Heroes.Warrior Characters.Heroes.Hero
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, game.getPlayerHeroes().get(0).getHeroClass());
        //Remove selection
        game.getPlayer().resetHeroSelection();
        Assert.assertEquals(0, game.getPlayerHeroes().size());
    }
}
