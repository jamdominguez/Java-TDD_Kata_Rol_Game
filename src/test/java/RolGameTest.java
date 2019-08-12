import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Enemies.Orc;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Characters.Heroes.Warrior;
import Characters.Heroes.Wizard;
import Skills.Skill;
import Skills.SkillFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        Assert.assertEquals("Characters.Heroes.Warrior", RolGame.getHero(HeroFactory.HeroClass.WARRIOR).getDescription());
    }

    @Test
    public void RQ2_aHeroTypeIsWizard() {
        Assert.assertEquals(true, RolGame.getHero(HeroFactory.HeroClass.WIZARD) instanceof Hero);
        Assert.assertEquals(HeroFactory.HeroClass.WIZARD, RolGame.getHero(HeroFactory.HeroClass.WIZARD).getHeroClass());
        Assert.assertEquals("Characters.Heroes.Wizard", RolGame.getHero(HeroFactory.HeroClass.WIZARD).getDescription());
    }

    @Test
    public void RQ2_playerSelectOneHero() {
        RolGame game = new RolGame();
        //Add a player
        game.addPlayer("Player1");
        //When start no heroes assigned to the player
        Assert.assertEquals(0, game.getPlayerHeroes().size());
        //Player select the Characters.Heroes.Warrior Characters.Heroes.Hero
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        Assert.assertEquals(1, game.getPlayerHeroes().size());
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, game.getPlayerHeroes().get(0).getHeroClass());
        //Player select the Characters.Heroes.Wizard Characters.Heroes.Hero (only 1, the Characters.Heroes.Warrior is removed, the Characters.Heroes.Wizard is added)
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
        //Player select the Characters.Heroes.Warrior Characters.Heroes.Hero
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
        Assert.assertEquals("Characters.Enemies.Orc", RolGame.getEnemy(EnemyFactory.EnemyClass.ORC).getDescription());
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

    @Test
    public void RQ8_inFightMustExistATurnCounter() {
        RolGame game = new RolGame();
        CombatManager combatMng = game.getCombatManager();
        Assert.assertEquals(0, combatMng.getTurn());
        combatMng.nextTurn();
        // Next turn
        Assert.assertEquals(1, combatMng.getTurn());
        combatMng.nextTurn();
        // Next turn
        Assert.assertEquals(2, combatMng.getTurn());
    }

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

    @Test
    public void RQ9_heroesHasSkillsList() {
        RolGame game = new RolGame();
        game.addPlayer("Player1");
        // Select Characters.Heroes.Warrior
        game.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        Hero heroSelected = game.getPlayer().getHeroes().get(0);
        Assert.assertEquals(HeroFactory.HeroClass.WARRIOR, heroSelected.getHeroClass());
        Assert.assertEquals(true, heroSelected.getSkills().size() > 0);
        // Select Characters.Heroes.Wizard
        game.getPlayer().select(HeroFactory.HeroClass.WIZARD);
        heroSelected = game.getPlayer().getHeroes().get(0);
        Assert.assertEquals(HeroFactory.HeroClass.WIZARD, heroSelected.getHeroClass());
        Assert.assertEquals(true, heroSelected.getSkills().size() > 0);
    }

    @Test
    public void RQ9_enemiesHasSkillsList() {
        // Characters.Enemies.Orc
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Assert.assertEquals(EnemyFactory.EnemyClass.ORC, enemy.getEnemyClass());
        Assert.assertEquals(true, enemy.getSkills().size() > 0);

    }

    @Test
    public void RQ9_skillsHasProperties_ManaNeeded_CooldDown_combatStates() {
        // Get random Skill
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK);
        Assert.assertEquals(true, Integer.valueOf(skill.getManaNeeded()) instanceof Integer);
        Assert.assertEquals(true, Integer.valueOf(skill.getCoolDown()) instanceof Integer);
        Map combatStates = skill.getCombatStates();
        Assert.assertEquals(true, combatStates != null);
    }

    @Test
    public void RQ9_combatState_PowerDown() {
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK);
        skill.addCombatState(Skill.CombatState.POWER_DOWN_50, 2);
        Assert.assertEquals(2, skill.getCombatStates().get(Skill.CombatState.POWER_DOWN_50));
    }

    @Test
    public void RQ9_combatState_DamageInTime() {
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK);
        skill.addCombatState(Skill.CombatState.DAMAGE_IN_TIME_10, 2);
        Assert.assertEquals(2, skill.getCombatStates().get(Skill.CombatState.DAMAGE_IN_TIME_10));
    }

    @Test
    public void RQ9_combatState_Poisoned() {
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK);
        skill.addCombatState(Skill.CombatState.POISONED_5, 2);
        Assert.assertEquals(2, skill.getCombatStates().get(Skill.CombatState.POISONED_5));
    }

    @Test
    public void RQ9_warriorHasDefinedASkillList() {
        Warrior warrior = (Warrior) HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Map skills = warrior.getSkills();
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.MELEE_ATTACK));
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.BRUTAL_STRIKE));
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.MUTILATE));
    }

    @Test
    public void RQ9_wizardHasDefinedASkillList() {
        Wizard wizard = (Wizard) HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Map skills = wizard.getSkills();
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.MELEE_ATTACK));
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.LET_IT_GO));
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.BURN_ALL));
    }

    @Test
    public void RQ9_orcHasDefinedASkillList() {
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Map skills = orc.getSkills();
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.MELEE_ATTACK));
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.BLADE_WITH_POISON));
        Assert.assertEquals(true, skills.containsKey(SkillFactory.SkillName.DIRTY_KICK));
    }

    @Test
    public void RQ9_heroesHasMeleeAttackBasedInPower() {
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        int damage = hero.useSkill(SkillFactory.SkillName.MELEE_ATTACK);
        Assert.assertEquals(0 <= hero.useSkill(SkillFactory.SkillName.MELEE_ATTACK), 0 <= damage && damage < hero.getPower());
    }

    @Test
    public void RQ9_enemiesHasMeleeAttackBasedInPower() {
        Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        int damage = enemy.useSkill(SkillFactory.SkillName.MELEE_ATTACK);
        Assert.assertEquals(true , 0 <= damage && damage <= enemy.getPower());
    }

    @Test
    public void RQ9_brutalStrikeBehavior(){
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.BRUTAL_STRIKE);
        int skillDamage = skill.dealDamage(hero.getPower(), hero.getSpellPower());
        int maxExpected = hero.getPower() * 2;
        Assert.assertEquals(true, 0 <= skillDamage && skillDamage <= maxExpected);
        Assert.assertEquals(3, skill.getCoolDown());
    }

    @Test
    public void RQ9_brutalStrikeOverHeroOrEnemy() {
        Hero warrior = (Warrior) HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        int orcLife = orc.getLife();

        CombatManager combatManager = new CombatManager();
        GameCharacter executor = warrior;
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        //combatManager.executeAction(executor, targets, SkillFactory.SkillName.BRUTAL_STRIKE); TODO
    }

    @Test
    public void RQ9_mutilateBehavior(){
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MUTILATE);
        int skillDamage = skill.dealDamage(hero.getPower(), hero.getSpellPower());
        int maxExpected = hero.getPower();
        Assert.assertEquals(true, 0 <= skillDamage && skillDamage <= maxExpected);
        Assert.assertEquals(4, skill.getCoolDown());
        Assert.assertEquals(true, skill.getCombatStates().containsKey(Skill.CombatState.POWER_DOWN_50));
        Assert.assertEquals(2, skill.getCombatStates().get(Skill.CombatState.POWER_DOWN_50));
    }
}