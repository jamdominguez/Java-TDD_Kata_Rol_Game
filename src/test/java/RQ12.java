import Characters.Enemies.Enemy;
import Characters.Enemies.Orc;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Skills.Skill;
import Skills.SkillFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ12 {
    @Test
    public void RQ12_magicalDamageConsumeSpellArmor() {
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
    public void RQ12_ifTargetHasnSpellArmorAllDamageToThelife() {
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
    public void RQ12_ifTargetLifeIfUnder0SetTo0AndSetDie(){
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        CombatManager combatManager = new CombatManager();
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        hero.setMana(10000); //recharge extra mana to throw many spells
        Assert.assertEquals(true, orc1.isAlive());
        while (orc1.getLife() > 0) {
            Skill skill = hero.getSkills().get(SkillFactory.SkillName.BURN_ALL);
            combatManager.executeAction(hero, enemies, skill);
        }
        Assert.assertEquals(false, orc1.isAlive());
    }
}
