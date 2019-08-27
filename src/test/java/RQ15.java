import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ15 {
    @Test
    public void RQ15_inGameAlwaysCombat1v1(){
        RolGame rolGame = new RolGame();
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(enemy);
        rolGame.setCombatManager(new CombatManager(characters));
        Assert.assertEquals(1, rolGame.getCombatManager().getMaxHeroesByCombat());
        Assert.assertEquals(1, rolGame.getCombatManager().getMaxEnemiesByCombat());
        Assert.assertArrayEquals(new int[]{1,1}, rolGame.getCombatManager().getMaxCharactersIncCombatBySide());
    }

    @Test
    public void RQ15_ifHeroDie_GameIsOver(){
        RolGame rolGame = new RolGame();
        rolGame.addPlayer("Player_1");
        rolGame.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        Assert.assertEquals(false, rolGame.isGameOver());
        rolGame.getPlayer().getHeroes().get(0).setLife(0);
        Assert.assertEquals(true, rolGame.isGameOver());
    }

    @Test
    public void RQ15_ifAllEnemiesDie_GameIsWon() {
        RolGame rolGame = new RolGame();
        rolGame.addPlayer("Player_1");
        rolGame.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        rolGame.setRandomEnemies(1);
        Enemy enemy = (Enemy) rolGame.getEnemiesInGame().get(0);
        enemy.setLife(0);
        Assert.assertEquals(false, rolGame.isGameOver());
        Assert.assertEquals(true, rolGame.isGameWon());
    }
}
