import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Enemies.Orc;
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

public class RQ10 {
    @Test
    public void RQ10_magicalDamageConsumeSpellArmor() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        CombatManager combatManager = new CombatManager();
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        int armor = orc1.getArmor();
        int spellArmor = orc1.getSpellArmor();
        Skill skill = wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL);
        combatManager.executeAction(wizard, enemies, skill);
        Assert.assertEquals(Skill.DamageType.MAGICAL, skill.getDamageType());
        Assert.assertEquals(true, armor == orc1.getArmor());
        Assert.assertEquals(true, spellArmor >= orc1.getSpellArmor());
    }

    @Test
    public void RQ10_ifTargetHasnSpellArmorAllDamageToThelife() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        CombatManager combatManager = new CombatManager();
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        orc1.setSpellArmor(0);
        int life = orc1.getLife();
        int spellArmor = orc1.getSpellArmor();
        Skill skill = wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL);
        combatManager.executeAction(wizard, enemies, skill);
        Assert.assertEquals(0, orc1.getSpellArmor());
        Assert.assertEquals(true, life >= orc1.getLife());
    }

    @Test
    public void RQ10_gameCharacterWithoutManaCantExecuteActionsWithMana() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        CombatManager combatManager = new CombatManager();
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        Enemy orc2 = new Orc();
        enemies.add(orc1);
        enemies.add(orc2);
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(150, wizard.getMana());
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(100, wizard.getMana());
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(50, wizard.getMana());
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(0, wizard.getMana());
        int orc1Life = orc1.getLife();
        int orc2Life = orc2.getLife();
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(0, wizard.getMana());
        Assert.assertEquals(true, orc1.getLife() == orc1Life);
        Assert.assertEquals(true, orc2.getLife() == orc2Life);
    }

    @Test
    public void RQ10_skillsProducesCombatStates() {
        Warrior warrior = (Warrior) HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        Wizard wizard = (Wizard) HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        Orc orc = (Orc) EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC);
        List enemies = new LinkedList();
        enemies.add(orc);
        CombatManager combatManager = new CombatManager();
        Assert.assertEquals(0, orc.getCombatStates().size());
        combatManager.executeAction(warrior, enemies, warrior.getSkills().get(SkillFactory.SkillName.MUTILATE));
        Assert.assertEquals(1, orc.getCombatStates().size());
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(2, orc.getCombatStates().size());
    }
}
