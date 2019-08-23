import org.junit.Assert;
import org.junit.Test;

public class RQ16 {
    @Test
    public void RQ16_combatStartInfoMustBeShown() {
        RolGame rolGame = new RolGame();
        CombatManager cM = rolGame.getCombatManager();
        cM.start();
        Assert.assertEquals("Combat Start", cM.getLastInfo());
    }
}
