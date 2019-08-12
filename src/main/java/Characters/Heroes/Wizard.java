package Characters.Heroes;

import Skills.Skill;
import Skills.SkillFactory;

import java.util.HashMap;
import java.util.Map;

public class Wizard extends Hero {

    public static String DESCRIPTION = "Characters.Heroes.Wizard";
    private Map<SkillFactory.SkillName, Skill> skills;

    public Wizard() {
        this.life = 70;
        this.mana = 200;
        this.power = 5;
        this.spellPower = 30;
        this.spellArmor = 10;
        this.skills = new HashMap();
        this.skills.put(SkillFactory.SkillName.MELEE_ATTACK, SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK));
        this.skills.put(SkillFactory.SkillName.LET_IT_GO, SkillFactory.getSkill(SkillFactory.SkillName.LET_IT_GO));
        this.skills.put(SkillFactory.SkillName.BURN_ALL, SkillFactory.getSkill(SkillFactory.SkillName.BURN_ALL));
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public HeroFactory.HeroClass getHeroClass() {
        return HeroFactory.HeroClass.WIZARD;
    }

    public Map getSkills() {
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
