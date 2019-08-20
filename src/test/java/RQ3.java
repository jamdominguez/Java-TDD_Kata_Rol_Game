package phase1;

import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import org.junit.Assert;
import org.junit.Test;

public class RQ3 {
    @Test
    public void RQ3_oneEnemyInGame() {
        Assert.assertEquals(1, RolGame.getEnemies().size());
    }

    @Test
    public void RQ3_aEnemyTypeIsOrc() {
        Assert.assertEquals(true, RolGame.getEnemy(EnemyFactory.EnemyClass.ORC) instanceof Enemy);
        Assert.assertEquals(EnemyFactory.EnemyClass.ORC, RolGame.getEnemy(EnemyFactory.EnemyClass.ORC).getEnemyClass());
        Assert.assertEquals("Characters.Enemies.Orc", RolGame.getEnemy(EnemyFactory.EnemyClass.ORC).getDescription());
    }
}
