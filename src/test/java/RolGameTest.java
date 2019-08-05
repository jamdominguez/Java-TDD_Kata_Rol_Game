import org.junit.Assert;
import org.junit.Test;

public class RolGameTest {

    @Test
    public void RQ1_gameHasAPlayer() {
        RolGame game = new RolGame();
        Assert.assertEquals(null, game.getPlayer());
        game.addPlayer("ZoroHD");
        Assert.assertEquals(true, game.getPlayer() instanceof Player);
        Assert.assertEquals("ZoroHD", game.getPlayer().getId());
    }

    @Test
    public void RQ2_twoHeroesToChose() {
        Assert.assertEquals(2, RolGame.getHeroes().size());
    }

    @Test
    public void RQ2_aHeroTypeIsWarrior() {
        Assert.assertEquals(true, RolGame.getHero(HeroFactory.HeroClass.WARRIOR) instanceof Hero);
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, RolGame.getHero(HeroFactory.HeroClass.WARRIOR).getHeroClass());
        Assert.assertEquals("Warrior", RolGame.getHero(HeroFactory.HeroClass.WARRIOR).getDescription());
    }

    @Test
    public void RQ2_aHeroTypeIsWizard() {
        Assert.assertEquals(true, RolGame.getHero(HeroFactory.HeroClass.WIZARD) instanceof Hero);
        Assert.assertEquals(HeroFactory.HeroClass.WIZARD, RolGame.getHero(HeroFactory.HeroClass.WIZARD).getHeroClass());
        Assert.assertEquals("Wizard", RolGame.getHero(HeroFactory.HeroClass.WIZARD).getDescription());
    }

    @Test
    public void RQ2_playerSelectOneHero() {
        RolGame game = new RolGame();
        //Add a player
        game.addPlayer("Player1");
        //When start no heroes assigned to the player
        Assert.assertEquals(0, game.getPlayerHeroes().size());
        //Player select the Warrior Hero
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, game.getPlayerHeroes().get(0).getHeroClass());
        //Player select the Wizard Hero (only 1, the Warrior is removed, the Wizard is added)
        game.getPlayer().select(HeroFactory.HeroClass.WIZARD);
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals(HeroFactory.HeroClass.WIZARD, game.getPlayerHeroes().get(0).getHeroClass());
    }

    @Test
    public void RQ2_resetHeroSelection() {
        RolGame game = new RolGame();
        //Add a player
        game.addPlayer("Player1");
        //When start no heroes assigned to the player
        Assert.assertEquals(0, game.getPlayerHeroes().size());
        //Player select the Warrior Hero
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, game.getPlayerHeroes().get(0).getHeroClass());
        //Remove selection
        game.getPlayer().resetHeroSelection();
        Assert.assertEquals(0, game.getPlayerHeroes().size());
    }

    @Test
    public void RQ3_oneEnemyInGame() {
        Assert.assertEquals(1, RolGame.getEnemies().size());
    }

    @Test
    public void RQ3_aEnemyTypeIsOrc() {
        Assert.assertEquals(true, RolGame.getEnemy(EnemyFactory.EnemyClass.ORC) instanceof Enemy);
        Assert.assertEquals(EnemyFactory.EnemyClass.ORC, RolGame.getEnemy(EnemyFactory.EnemyClass.ORC).getEnemyClass());
        Assert.assertEquals("Orc", RolGame.getEnemy(EnemyFactory.EnemyClass.ORC).getDescription());
    }

    @Test
    public void RQ4_heroesAndEnemiesHasLife() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getLife()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getLife()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasMana() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getMana()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getMana()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasPower() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getPower()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getPower()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasSpellpower() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getSpellPower()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getSpellPower()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasArmor() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getArmor()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getArmor()) instanceof Integer);
    }

    @Test
    public void RQ4_heroesAndEnemiesHasSpellArmor() {
        //Random hero
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        //Random enemy
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(true, Integer.valueOf(hero.getSpellArmor()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(enemy.getSpellArmor()) instanceof Integer);
    }

    @Test
    public void RQ5_warriorHasAttributesValues() {
        Hero warrior = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        int life = 100;
        int mana = 0;
        int power = 20;
        int spellPower = 0;
        int armor = 10;
        int spellArmor = 0;
        Assert.assertEquals(life, warrior.getLife());
        Assert.assertEquals(mana, warrior.getMana());
        Assert.assertEquals(power, warrior.getPower());
        Assert.assertEquals(spellPower, warrior.getSpellPower());
        Assert.assertEquals(armor, warrior.getArmor());
        Assert.assertEquals(spellArmor, warrior.getSpellArmor());
    }

    @Test
    public void RQ5_wizardHasAttributesValues() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        int life = 70;
        int mana = 200;
        int power = 5;
        int spellPower = 30;
        int armor = 0;
        int spellArmor = 10;
        Assert.assertEquals(life, wizard.getLife());
        Assert.assertEquals(mana, wizard.getMana());
        Assert.assertEquals(power, wizard.getPower());
        Assert.assertEquals(spellPower, wizard.getSpellPower());
        Assert.assertEquals(armor, wizard.getArmor());
        Assert.assertEquals(spellArmor, wizard.getSpellArmor());
    }

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