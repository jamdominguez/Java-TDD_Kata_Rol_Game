package Characters.Heroes;

import Characters.GameCharacter;
import Skills.Skill;
import Skills.SkillFactory;

import java.util.Map;

public abstract class Hero extends GameCharacter {
    public abstract HeroFactory.HeroClass getHeroClass();

    public abstract Map<SkillFactory.SkillName, Skill> getSkills();

    public abstract int useSkill(SkillFactory.SkillName skillName);
}
