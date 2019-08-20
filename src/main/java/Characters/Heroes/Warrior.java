package Characters.Heroes;

import Skills.Skill;
import Skills.SkillFactory;

import java.util.HashMap;
import java.util.Map;

public class Warrior extends Hero {

    public static String DESCRIPTION = "Characters.Heroes.Warrior";
    private Map<SkillFactory.SkillName, Skill> skills;

    public Warrior() {
        this.life = 100;
        this.power = 20;
        this.armor = 10;
        this.skills = new HashMap();
        this.skills.put(SkillFactory.SkillName.MELEE_ATTACK, SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK));
        this.skills.put(SkillFactory.SkillName.BRUTAL_STRIKE, SkillFactory.getSkill(SkillFactory.SkillName.BRUTAL_STRIKE));
        this.skills.put(SkillFactory.SkillName.MUTILATE, SkillFactory.getSkill(SkillFactory.SkillName.MUTILATE));
        this.combatStates = new HashMap<Skill.CombatState, Integer>();

    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public HeroFactory.HeroClass getHeroClass() {
        return HeroFactory.HeroClass.WARRIOR;
    }

    public Map<SkillFactory.SkillName, Skill> getSkills() {
        return this.skills;
    }

    public int useSkill(SkillFactory.SkillName skillName) {
        int damage = 0;
        if (this.skills.containsKey(skillName)) {
            Skill skill = this.skills.get(skillName);
            damage = skill.dealDamage(this.power, this.spellPower);
        }
        return damage;
    }
}
