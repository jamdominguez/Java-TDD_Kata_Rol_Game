package phase1;

import org.junit.Assert;
import org.junit.Test;

public class RQ1 {
    @Test
    public void RQ1_gameHasAPlayer() {
        RolGame game = new RolGame();
        Assert.assertEquals(null, game.getPlayer());
        game.addPlayer("ZoroHD");
        Assert.assertEquals(true, game.getPlayer() instanceof Player);
        Assert.assertEquals("ZoroHD", game.getPlayer().getId());
    }
}
