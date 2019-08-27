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
import java.util.Map;

public class RQ12 {
    @Test
    public void RQ12_magicalDamageConsumeSpellArmor() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(wizard);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
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
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(wizard);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
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
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        hero.setMana(10000); //recharge extra mana to throw many spells
        Assert.assertEquals(true, orc1.isAlive());
        int i = 0;
        while (orc1.getLife() > 0) {
            Skill skill = hero.getSkills().get(SkillFactory.SkillName.BURN_ALL);
            combatManager.executeAction(hero, enemies, skill);
            combatManager.nextTurn();
        }
        Assert.assertEquals(false, orc1.isAlive());
    }

    @Test
    public void RQ12_skillInCDCantBeUsed(){
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        Map<SkillFactory.SkillName, Integer> skillsInCD = hero.getSkillsInCD();
        Assert.assertEquals(0, hero.getSkillsInCD().size());
        combatManager.executeAction(hero, enemies, hero.getSkills().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        Assert.assertEquals(1, hero.getSkillsInCD().size());
        //Here a message must be shown
        combatManager.executeAction(hero, enemies, hero.getSkills().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        //
    }

    @Test
    public void RQ12_skillAfterCDFinishCanBeUsed() {
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        Map<SkillFactory.SkillName, Integer> skillsInCD = hero.getSkillsInCD();
        Assert.assertEquals(0, hero.getSkillsInCD().size());
        combatManager.executeAction(hero, enemies, hero.getSkills().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        Assert.assertEquals(1, hero.getSkillsInCD().size());
        //Here a message must be shown
        combatManager.executeAction(hero, enemies, hero.getSkills().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        //
        Assert.assertEquals(Integer.valueOf(3), hero.getSkillsInCD().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        combatManager.nextTurn();
        Assert.assertEquals(Integer.valueOf(2), hero.getSkillsInCD().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        combatManager.nextTurn();
        Assert.assertEquals(Integer.valueOf(1), hero.getSkillsInCD().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        combatManager.nextTurn();
        Assert.assertEquals(null, hero.getSkillsInCD().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        Assert.assertEquals(0, hero.getSkillsInCD().size());
        //Here can use the sill again
        combatManager.executeAction(hero, enemies, hero.getSkills().get(SkillFactory.SkillName.BRUTAL_STRIKE));
        //
    }

    @Test
    public void RQ12_sillsProducesBehaviourInTime(){
        Hero hero = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        int orcPower = orc1.getPower();
        Assert.assertEquals(0, orc1.getCombatStates().size());
        combatManager.executeAction(hero, enemies, hero.getSkills().get(SkillFactory.SkillName.MUTILATE));
        Assert.assertEquals(1, orc1.getCombatStates().size());
        Assert.assertEquals(true, orc1.getCombatStates().containsKey(Skill.CombatState.POWER_DOWN_50));
        Assert.assertEquals(true, orcPower > orc1.getPower());
        Assert.assertEquals(Integer.valueOf(2), orc1.getCombatStates().get(Skill.CombatState.POWER_DOWN_50));
        combatManager.nextTurn();
        Assert.assertEquals(Integer.valueOf(1), orc1.getCombatStates().get(Skill.CombatState.POWER_DOWN_50));
        combatManager.nextTurn();
        Assert.assertEquals(0, orc1.getCombatStates().size());
    }

    @Test
    public void RQ12_allSkillsThatProducesBehaviorWorkRight(){
        GameCharacter character = new GameCharacterDummy();
        int turns = 3;
        // Skills available
        for (Skill.CombatState state : Skill.CombatState.values()) {
            Assert.assertEquals(true, character.addCombatState(state, turns, 10));
        }
    }

    class GameCharacterDummy extends GameCharacter{
        public String getDescription() {
            return "dummy";
        }
        public Map<SkillFactory.SkillName, Skill> getSkills() {
            return null;
        }
    }
}
