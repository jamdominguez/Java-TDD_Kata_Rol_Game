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

public class RQ9 {
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
        Assert.assertEquals(Integer.valueOf(2), skill.getCombatStates().get(Skill.CombatState.POWER_DOWN_50));
    }

    @Test
    public void RQ9_combatState_DamageInTime() {
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK);
        skill.addCombatState(Skill.CombatState.DAMAGE_IN_TIME_10, 2);
        Map<Skill.CombatState, Integer> states = skill.getCombatStates();
        Assert.assertEquals(Integer.valueOf(2), states.get(Skill.CombatState.DAMAGE_IN_TIME_10));
    }

    @Test
    public void RQ9_combatState_Poisoned() {
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK);
        skill.addCombatState(Skill.CombatState.POISONED_5, 2);
        Assert.assertEquals(Integer.valueOf(2), skill.getCombatStates().get(Skill.CombatState.POISONED_5));
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
        Assert.assertEquals(true, 0 <= damage && damage <= enemy.getPower());
    }

    @Test
    public void RQ9_brutalStrikeBehavior() {
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
        int orcArmor = orc.getArmor();
        CombatManager combatManager = new CombatManager();
        GameCharacter executor = warrior;
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(orc);
        combatManager.executeAction(executor, targets, warrior.getSkills().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        int orcArmorAfterSkill = orc.getArmor();
        Assert.assertEquals(true, orcArmor >= orcArmorAfterSkill); // the damage can be 0
    }

    @Test
    public void RQ9_mutilateBehavior() {
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.MUTILATE);
        int skillDamage = skill.dealDamage(hero.getPower(), hero.getSpellPower());
        int maxExpected = hero.getPower();
        Assert.assertEquals(true, 0 <= skillDamage && skillDamage <= maxExpected);
        Assert.assertEquals(4, skill.getCoolDown());
        Assert.assertEquals(true, skill.getCombatStates().containsKey(Skill.CombatState.POWER_DOWN_50));
        Assert.assertEquals(Integer.valueOf(2), skill.getCombatStates().get(Skill.CombatState.POWER_DOWN_50));
    }

    @Test
    public void RQ9_mutilateOverHeroOrEnemy() {
        Hero warrior = (Warrior) HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        int orcArmor = orc.getArmor();
        CombatManager combatManager = new CombatManager();
        GameCharacter executor = warrior;
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(orc);
        combatManager.executeAction(executor, targets, warrior.getSkills().get(SkillFactory.SkillName.MUTILATE));
        int orcArmorAfterSkill = orc.getArmor();
        Assert.assertEquals(true, orcArmor >= orcArmorAfterSkill); // the damage can be 0
        Assert.assertEquals(true, orc.getCombatStates().containsKey(Skill.CombatState.POWER_DOWN_50));
    }

    @Test
    public void RQ9_letItGoBehavior() {
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.LET_IT_GO);
        int skillDamage = skill.dealDamage(hero.getPower(), hero.getSpellPower());
        int maxExpected = hero.getSpellPower();
        Assert.assertEquals(true, 0 <= skillDamage && skillDamage <= maxExpected);
        Assert.assertEquals(0, skill.getCoolDown());
        Assert.assertEquals(10, skill.getManaNeeded());
    }

    @Test
    public void RQ9_letItGoOverHeroOrEnemy() {
        Hero wizard = (Wizard) HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        int orcSpellArmor = orc.getSpellArmor();
        CombatManager combatManager = new CombatManager();
        GameCharacter executor = wizard;
        int initMana = executor.getMana();
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(orc);
        combatManager.executeAction(executor, targets, wizard.getSkills().get(SkillFactory.SkillName.LET_IT_GO));
        int orcSpellArmorAfterSkill = orc.getSpellArmor();
        Assert.assertEquals(true, orcSpellArmor >= orcSpellArmorAfterSkill); // the damage can be 0
        Assert.assertEquals(initMana - wizard.getSkills().get(SkillFactory.SkillName.LET_IT_GO).getManaNeeded(), executor.getMana());
    }

    @Test
    public void RQ9_burnAllBehavior() {
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.BURN_ALL);
        int skillDamage = skill.dealDamage(hero.getPower(), hero.getSpellPower());
        int maxExpected = hero.getSpellPower() * 3;
        Assert.assertEquals(true, 0 <= skillDamage && skillDamage <= maxExpected);
        Assert.assertEquals(4, skill.getCoolDown());
        Assert.assertEquals(50, skill.getManaNeeded());
    }

    @Test
    public void RQ9_burnAllOverHeroOrEnemy() {
        Hero wizard = (Wizard) HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        int orcSpellArmor = orc.getSpellArmor();
        CombatManager combatManager = new CombatManager();
        GameCharacter executor = wizard;
        int initMana = executor.getMana();
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(orc);
        combatManager.executeAction(executor, targets, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        int orcSpellArmorAfterSkill = orc.getSpellArmor();
        Assert.assertEquals(true, orcSpellArmor >= orcSpellArmorAfterSkill); // the damage can be 0
        Assert.assertEquals(true, orc.getCombatStates().containsKey(Skill.CombatState.DAMAGE_IN_TIME_10));
        Assert.assertEquals(initMana - wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL).getManaNeeded(), executor.getMana());
    }

    @Test
    public void RQ9_bladeWithPoisonBehavior(){
        Enemy orc = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.BLADE_WITH_POISON);
        int skillDamage = skill.dealDamage(orc.getPower(), orc.getSpellPower());
        int maxExpected = orc.getPower();
        Assert.assertEquals(true, 0 <= skillDamage && skillDamage <= maxExpected);
        Assert.assertEquals(3, skill.getCoolDown());
        Assert.assertEquals(Integer.valueOf(2), skill.getCombatStates().get(Skill.CombatState.POISONED_5));
    }

    @Test
    public void RQ9_bladeWithPoisonOverHeroOrEnemy(){
        Hero wizard = (Wizard) HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Hero warrior = (Warrior) HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        int wizardArmor = wizard.getArmor();
        int warriorArmor = warrior.getArmor();
        CombatManager combatManager = new CombatManager();
        GameCharacter executor = orc;
        int initMana = executor.getMana();
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(wizard);
        targets.add(warrior);
        combatManager.executeAction(executor, targets, orc.getSkills().get(SkillFactory.SkillName.BLADE_WITH_POISON));
        int wizardArmorAfterSkill = wizard.getArmor();
        int warriorArmorAfterSkill = warrior.getArmor();
        Assert.assertEquals(true, wizardArmor >= wizardArmorAfterSkill); // the damage can be 0
        Assert.assertEquals(true, warriorArmor >= warriorArmorAfterSkill); // the damage can be 0
        Assert.assertEquals(true, wizard.getCombatStates().containsKey(Skill.CombatState.POISONED_5));
        Assert.assertEquals(true, warrior.getCombatStates().containsKey(Skill.CombatState.POISONED_5));
        Assert.assertEquals(initMana - orc.getSkills().get(SkillFactory.SkillName.BLADE_WITH_POISON).getManaNeeded(), executor.getMana());
    }

    @Test
    public void RQ9_dirtyKickBehavior(){
        Enemy orc = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        Skill skill = SkillFactory.getSkill(SkillFactory.SkillName.DIRTY_KICK);
        int skillDamage = skill.dealDamage(orc.getPower(), orc.getSpellPower());
        int maxExpected = orc.getPower();
        Assert.assertEquals(true, 0 <= skillDamage && skillDamage <= maxExpected);
        Assert.assertEquals(5, skill.getCoolDown());
        Assert.assertEquals(Integer.valueOf(2), skill.getCombatStates().get(Skill.CombatState.POWER_DOWN_20));
    }

    @Test
    public void RQ9_dirtyKickOverHeroOrEnemy(){
        Hero wizard = (Wizard) HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Hero warrior = (Warrior) HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        int wizardArmor = wizard.getArmor();
        int warriorArmor = warrior.getArmor();
        CombatManager combatManager = new CombatManager();
        GameCharacter executor = orc;
        int initMana = executor.getMana();
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(wizard);
        targets.add(warrior);
        combatManager.executeAction(executor, targets, orc.getSkills().get(SkillFactory.SkillName.DIRTY_KICK));
        int wizardArmorAfterSkill = wizard.getArmor();
        int warriorArmorAfterSkill = warrior.getArmor();
        Assert.assertEquals(true, wizardArmor >= wizardArmorAfterSkill); // the damage can be 0
        Assert.assertEquals(true, warriorArmor >= warriorArmorAfterSkill); // the damage can be 0
        Assert.assertEquals(true, wizard.getCombatStates().containsKey(Skill.CombatState.POWER_DOWN_20));
        Assert.assertEquals(true, warrior.getCombatStates().containsKey(Skill.CombatState.POWER_DOWN_20));
        Assert.assertEquals(initMana - orc.getSkills().get(SkillFactory.SkillName.DIRTY_KICK).getManaNeeded(), executor.getMana());
    }
}
