import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

public class RQ4 {
    @Test
    public void RQ4_heroesAndEnemiesHasLife() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getLife()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getLife()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasMana() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getMana()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getMana()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasPower() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getPower()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getPower()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasSpellpower() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getSpellPower()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getSpellPower()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasArmor() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getArmor()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getArmor()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasSpellArmor() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getSpellArmor()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getSpellArmor()) instanceof Integer);
    }
}
