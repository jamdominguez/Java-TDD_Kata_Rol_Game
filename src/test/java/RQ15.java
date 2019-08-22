import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

public class RQ15 {
    @Test
    public void RQ15_inGameAlwaysCombat1v1(){
        RolGame rolGame = new RolGame();
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
        Enemy enemy = rolGame.getEnemiesInGame().get(EnemyFactory.EnemyClass.ORC);
        enemy.setLife(0);
        Assert.assertEquals(false, rolGame.isGameOver());
        Assert.assertEquals(true, rolGame.isGameWon());
    }
}
