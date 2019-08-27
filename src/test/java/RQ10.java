import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Enemies.Orc;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Characters.Heroes.Warrior;
import Characters.Heroes.Wizard;
import Skills.SkillFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ10 {
    @Test
    public void RQ10_gameCharacterWithoutManaCantExecuteActionsWithMana() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        Enemy orc2 = new Orc();
        enemies.add(orc1);
        enemies.add(orc2);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(wizard);
        characters.add(orc1);
        characters.add(orc2);
        CombatManager combatManager = new CombatManager(characters);
        //
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(150, wizard.getMana());
        // now has cooldown
        for (int i = 0; i < wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL).getCoolDown(); i++) combatManager.nextTurn();
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(100, wizard.getMana());

        for (int i = 0; i < wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL).getCoolDown(); i++) combatManager.nextTurn();
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(50, wizard.getMana());

        for (int i = 0; i < wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL).getCoolDown(); i++) combatManager.nextTurn();
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(0, wizard.getMana());

        int orc1Life = orc1.getLife();
        int orc2Life = orc2.getLife();
        combatManager.nextTurn();combatManager.nextTurn();combatManager.nextTurn();
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

        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(warrior);
        characters.add(wizard);
        characters.add(orc);
        CombatManager combatManager = new CombatManager(characters);
        //

        Assert.assertEquals(0, orc.getCombatStates().size());
        combatManager.executeAction(warrior, enemies, warrior.getSkills().get(SkillFactory.SkillName.MUTILATE));
        Assert.assertEquals(1, orc.getCombatStates().size());
        combatManager.executeAction(wizard, enemies, wizard.getSkills().get(SkillFactory.SkillName.BURN_ALL));
        Assert.assertEquals(2, orc.getCombatStates().size());
    }
}
