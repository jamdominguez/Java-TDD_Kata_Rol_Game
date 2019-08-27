import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ8 {
    @Test
    public void RQ8_whenTheFightStarTheTurnCounterIs0() {
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(enemy);
        CombatManager combatMng = new CombatManager(characters);
        Assert.assertEquals(0, combatMng.getTurn());
        // Next turn
        combatMng.nextTurn();
        Assert.assertEquals(1, combatMng.getTurn());
        // Next turn
        combatMng.nextTurn();
        Assert.assertEquals(2, combatMng.getTurn());
        //
        combatMng.start();
        Assert.assertEquals(0, combatMng.getTurn());
        combatMng.nextTurn();
    }
}
