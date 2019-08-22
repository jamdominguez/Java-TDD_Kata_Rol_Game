import Characters.Heroes.HeroFactory;
import Characters.Heroes.Warrior;
import Characters.Heroes.Wizard;
import org.junit.Assert;
import org.junit.Test;

public class RQ13 {
    @Test
    public void RQ13_whenGameStartThePlayeChooseAHero(){
        // A Game Start
        RolGame rolGame = new RolGame();
        // Create Player
        rolGame.addPlayer("Player_1");
        Player p1 = rolGame.getPlayer();
        Assert.assertEquals(0, p1.getHeroes().size());
        // Player select a hero
        p1.select(HeroFactory.HeroClass.WIZARD);
        Assert.assertEquals(1, p1.getHeroes().size());
        Assert.assertEquals(true, p1.getHeroes().get(0) instanceof Wizard);
        // Player try select other hero, the list no increase, the hero is changed
        p1.select(HeroFactory.HeroClass.WARRIOR);
        Assert.assertEquals(1, p1.getHeroes().size());
        Assert.assertEquals(true, p1.getHeroes().get(0) instanceof Warrior);
    }
}
