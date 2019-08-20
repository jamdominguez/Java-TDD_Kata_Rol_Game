package phase1;

import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Enemies.Orc;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Characters.Heroes.Warrior;
import Characters.Heroes.Wizard;
import Skills.SkillFactory;
import org.junit.Assert;
import org.junit.Test;

import CombatManager;
import java.util.LinkedList;
import java.util.List;

public class RQ10 {
    @Test
    public void RQ10_GameCharacterWithoutManaCantExecuteActionsWithMana() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        CombatManager combatManager = new CombatManager();
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        Enemy orc2 = new Orc();
        enemies.add(orc1);
        enemies.add(orc2);
        int initMana = wizard.getMana();
        System.out.println(orc1);
        System.out.println(orc2);

        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(150, wizard.getMana());
        System.out.println(orc1);
        System.out.println(orc2);
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(100, wizard.getMana());
        System.out.println(orc1);
        System.out.println(orc2);
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(50, wizard.getMana());
        System.out.println(orc1);
        System.out.println(orc2);
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(0, wizard.getMana());
        System.out.println(orc1);
        int orc1Life = orc1.getLife();
        System.out.println(orc2);
        int orc2Life = orc2.getLife();
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(0, wizard.getMana());
        Assert.assertEquals(true, orc1.getLife() == orc1Life);
        Assert.assertEquals(true, orc2.getLife() == orc2Life);
        System.out.println(orc1);
        System.out.println(orc2);
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
        System.out.println(orc);
    }
}
