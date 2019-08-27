import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ16 {
    @Test
    public void RQ16_combatStartInfoMustBeShown() {
        RolGame rolGame = new RolGame();
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(enemy);
        rolGame.setCombatManager(new CombatManager(characters));
        CombatManager cM = rolGame.getCombatManager();
        cM.start();
        Assert.assertEquals("Combat Start", cM.getLastInfo());
    }
}
