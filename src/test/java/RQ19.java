import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Skills.BladeWithPoison;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ19 {
    @Test
    public void RQ19_theHeroLifeNeverCanBeNegative(){
        RolGame rolGame = new RolGame();
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(enemy);
        rolGame.setCombatManager(new CombatManager(characters));
        CombatManager cM = rolGame.getCombatManager();
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(hero);
        // Iterate to down the life to 0
        while (hero.getLife() > 0) {
            cM.executeAction(enemy, targets, new BladeWithPoison());
            cM.nextTurn();
        }
        // With the hero life to 0, execute damage again
        cM.executeAction(enemy, targets, new BladeWithPoison());
        // The life must not down than 0
        Assert.assertEquals(0, hero.getLife());
    }
}
