package Characters.Enemies;

import Characters.GameCharacter;
import Skills.Skill;
import Skills.SkillFactory;

import java.util.Map;

public abstract class Enemy extends GameCharacter {
    public abstract EnemyFactory.EnemyClass getEnemyClass();

    public abstract Map<SkillFactory.SkillName, Skill> getSkills();

    public abstract int useSkill(SkillFactory.SkillName skillName);
}
