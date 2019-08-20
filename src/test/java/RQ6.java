import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import org.junit.Assert;
import org.junit.Test;

public class RQ6 {
    @Test
    public void RQ6_orcHasAttributesValuesIntoAInterval() {
        Enemy orc;
        // Testing 1000 cases for random values are inside interval
        for (int i = 0; i <= 1000; i++) {
            orc = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
            Assert.assertEquals(true, 50 <= orc.getLife() && orc.getLife() <= 300);
            Assert.assertEquals(true, 30 <= orc.getMana() && orc.getMana() <= 50);
            Assert.assertEquals(true, 3 <= orc.getPower() && orc.getPower() <= 6);
            Assert.assertEquals(true, 2 <= orc.getSpellPower() && orc.getSpellPower() <= 4);
            Assert.assertEquals(true, 3 <= orc.getArmor() && orc.getArmor() <= 5);
            Assert.assertEquals(true, 3 <= orc.getSpellArmor() && orc.getSpellArmor() <= 5);
        }
    }
}
