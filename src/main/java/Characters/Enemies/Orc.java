package Characters.Enemies;

import Skills.Skill;
import Skills.SkillFactory;

import java.util.HashMap;
import java.util.Map;

public class Orc extends Enemy {

    public static String DESCRIPTION = "Characters.Enemies.Orc";
    private Map<SkillFactory.SkillName, Skill> skills;

    public Orc() {
        this.life = getRandomValue(50, 300);
        this.mana = getRandomValue(30, 50);
        this.power = getRandomValue(3, 6);
        this.spellPower = getRandomValue(2, 4);
        this.armor = getRandomValue(3, 5);
        this.spellArmor = getRandomValue(3, 5);
        this.skills = new HashMap<SkillFactory.SkillName, Skill>();
        this.skills.put(SkillFactory.SkillName.MELEE_ATTACK, SkillFactory.getSkill(SkillFactory.SkillName.MELEE_ATTACK));
        this.skills.put(SkillFactory.SkillName.BLADE_WITH_POISON, SkillFactory.getSkill(SkillFactory.SkillName.BLADE_WITH_POISON));
        this.skills.put(SkillFactory.SkillName.DIRTY_KICK, SkillFactory.getSkill(SkillFactory.SkillName.DIRTY_KICK));
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public EnemyFactory.EnemyClass getEnemyClass() {
        return EnemyFactory.EnemyClass.ORC;
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
