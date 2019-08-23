import org.junit.Assert;
import org.junit.Test;

public class RQ20 {

    RolGame rolGame = new RolGame();

    @Test
    public void RQ20_theGameHasSeveralEnemiesByGameAccordingLevel() {
        rolGame.start(RolGame.Level.EASY);
        Assert.assertEquals(true, rolGame.getEnemiesInGame().size() > 0);
        rolGame.start(RolGame.Level.MEDIUM);
        Assert.assertEquals(true, rolGame.getEnemiesInGame().size() > 0);
        rolGame.start(RolGame.Level.HARD);
        Assert.assertEquals(true, rolGame.getEnemiesInGame().size() > 0);
    }

    @Test
    public void RQ20_easyGameHas_1Enemy(){
        rolGame.start(RolGame.Level.EASY);
        Assert.assertEquals(1, rolGame.getEnemiesInGame().size());
    }

    @Test
    public void RQ20_mediumGameHas_3Enemy(){
        rolGame.start(RolGame.Level.MEDIUM);
        Assert.assertEquals(3, rolGame.getEnemiesInGame().size());
    }

    @Test
    public void RQ20_hardGameHas_5Enemy(){
        rolGame.start(RolGame.Level.HARD);
        Assert.assertEquals(5, rolGame.getEnemiesInGame().size());
    }
}
