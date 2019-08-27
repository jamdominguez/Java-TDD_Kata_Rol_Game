import Characters.Enemies.Enemy;
import Characters.Enemies.Orc;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Skills.Skill;
import Skills.SkillFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ11 {
    @Test
    public void RQ11_physicDamageConsumeArmor(){
        Hero warrior = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        int armor = orc1.getArmor();
        int spellArmor = orc1.getSpellArmor();
        Skill skill = warrior.getSkills().get(SkillFactory.SkillName.MELEE_ATTACK);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(warrior);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        combatManager.executeAction(warrior, enemies, skill);
        Assert.assertEquals(Skill.DamageType.PHYSICAL, skill.getDamageType());
        Assert.assertEquals(true, armor >= orc1.getArmor());
        Assert.assertEquals(true, spellArmor == orc1.getSpellArmor());
    }

    @Test
    public void RQ11_ifTargetHasntArmorAllDamageToTheLife(){
        Hero warrior = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        orc1.setArmor(0);
        int life = orc1.getLife();
        Skill skill = warrior.getSkills().get(SkillFactory.SkillName.MELEE_ATTACK);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(warrior);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        combatManager.executeAction(warrior, enemies, skill);
        Assert.assertEquals(0, orc1.getArmor());
        Assert.assertEquals(true, life >= orc1.getLife());
    }

    @Test
    public void RQ11_ifTargetLifeIfUnder0SetTo0AndSetDie(){
        Hero warrior = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        orc1.setArmor(0);
        int life = orc1.getLife();
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(warrior);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        Skill skill = warrior.getSkills().get(SkillFactory.SkillName.MELEE_ATTACK);
        combatManager.executeAction(warrior, enemies, skill);
        Assert.assertEquals(0, orc1.getArmor());
        Assert.assertEquals(true, life >= orc1.getLife());
    }
}
