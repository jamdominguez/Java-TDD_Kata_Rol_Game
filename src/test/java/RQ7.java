package phase1;

import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

public class RQ7 {
    @Test
    public void RQ7_gameHasStatesCombatAndNoCombat() {
        Assert.assertEquals(true, RolGame.State.COMBAT != null);
        Assert.assertEquals(true, RolGame.State.NO_COMBAT != null);
    }

    @Test
    public void RQ7_ifPlayerNoFoundEnemyStateIsNoCombat() {
        RolGame game = new RolGame();
        game.addPlayer("Player1");
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        game.getPlayer().setEnemyFound(false);
        game.updateState();
        if (!game.getPlayer().isEnemyFound()) Assert.assertEquals(RolGame.State.NO_COMBAT, game.getState());
    }

    @Test
    public void RQ7_whenPlayerFindEnemyStateIsCombat() {
        RolGame game = new RolGame();
        game.addPlayer("Player1");
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        game.getPlayer().setEnemyFound(true);
        game.updateState();
        if (game.getPlayer().isEnemyFound()) Assert.assertEquals(RolGame.State.COMBAT, game.getState());
    }

    @Test
    public void RQ7_whenCombatStartAndFinishTheStateMustBeUpdated() {
        RolGame game = new RolGame();
        game.addPlayer("Player1");
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        // Start the game
        Assert.assertEquals(RolGame.State.NO_COMBAT, game.getState());
        // Start a combat
        game.startCombat();
        Assert.assertEquals(RolGame.State.COMBAT, game.getState());
        // End combat
        game.endCombat();
        Assert.assertEquals(RolGame.State.NO_COMBAT, game.getState());
    }
}
