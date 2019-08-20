package phase1;

import org.junit.Assert;
import org.junit.Test;

public class RQ8 {
    @Test
    public void RQ8_whenTheFightStarTheTurnCounterIs0() {
        RolGame game = new RolGame();
        CombatManager combatMng = game.getCombatManager();
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
