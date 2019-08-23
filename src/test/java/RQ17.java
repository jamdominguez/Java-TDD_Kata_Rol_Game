import org.junit.Assert;
import org.junit.Test;

public class RQ17 {
    @Test
    public void RQ17_combatEndtInfoMustBeShown() {
        RolGame rolGame = new RolGame();
        CombatManager cM = rolGame.getCombatManager();
        cM.start();
        cM.end();
        Assert.assertEquals("Combat End", cM.getLastInfo());
    }
}
