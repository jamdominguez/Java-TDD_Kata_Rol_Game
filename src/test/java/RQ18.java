import Characters.Enemies.Enemy;
import Characters.Heroes.Warrior;
import Skills.BrutalStrike;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ18 {
    @Test
    public void RQ18_statesInfoMustBeShown() {
        RolGame rolGame = new RolGame();
        CombatManager cM = rolGame.getCombatManager();
        List targets = new LinkedList<Enemy>();
        // Combat Start
        cM.start();
        Assert.assertEquals("Combat Start", cM.getLastInfo());
        // First Action
        cM.executeAction(new Warrior(), targets, new BrutalStrike());
        Assert.assertEquals(true, cM.getLastInfo().contains("Execution"));
        Assert.assertEquals(1, cM.getTurn());
        // Second Action
        cM.executeAction(new Warrior(), targets, new BrutalStrike());
        Assert.assertEquals(true, cM.getLastInfo().contains("Execution"));
        Assert.assertEquals(2, cM.getTurn());
        // End Combat
        cM.end();
        Assert.assertEquals("Combat End", cM.getLastInfo());
    }
}
