import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Skills.BrutalStrike;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ18 {
    @Test
    public void RQ18_statesInfoMustBeShown() {
        RolGame rolGame = new RolGame();
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(enemy);
        rolGame.setCombatManager(new CombatManager(characters));
        CombatManager cM = rolGame.getCombatManager();
        List targets = new LinkedList<Enemy>();
        // Combat Start
        cM.start();
        Assert.assertEquals("Combat Start", cM.getLastInfo());
        // First Action
        cM.executeAction(hero, targets, new BrutalStrike());
        Assert.assertEquals(true, cM.getLastInfo().contains("Execution"));
        Assert.assertEquals(1, cM.getTurn());
        // Second Action
        cM.nextTurn();
        cM.executeAction(hero, targets, new BrutalStrike());
        Assert.assertEquals(true, cM.getLastInfo().contains("Execution"));
        Assert.assertEquals(2, cM.getTurn());
        // End Combat
        cM.end();
        Assert.assertEquals("Combat End", cM.getLastInfo());
    }
}
