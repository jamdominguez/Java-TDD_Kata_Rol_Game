package Characters.Enemies;

import Characters.GameCharacter;
import Skills.SkillFactory;

import java.util.Map;

public abstract class Enemy extends GameCharacter {
    public abstract EnemyFactory.EnemyClass getEnemyClass();

    public abstract Map getSkills();

    public abstract int useSkill(SkillFactory.SkillName skillName);
}
