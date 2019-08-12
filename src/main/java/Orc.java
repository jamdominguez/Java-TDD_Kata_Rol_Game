import java.util.HashMap;
import java.util.Map;

public class Orc extends Enemy {

    public static String DESCRIPTION = "Orc";
    public enum SkillName {MELEE_ATTACK, BLADE_WITH_POSION, DIRTY_KICK};
    private Map skills;

    public Orc() {
        this.life = getRandomValue(50, 300);
        this.mana = getRandomValue(30, 50);
        this.power = getRandomValue(3, 6);
        this.spellPower = getRandomValue(2, 4);
        this.armor = getRandomValue(3, 5);
        this.spellArmor = getRandomValue(3, 5);
        this.skills = new HashMap();
        this.skills.put(Orc.SkillName.MELEE_ATTACK, new Skill());
        this.skills.put(Orc.SkillName.BLADE_WITH_POSION, new Skill());
        this.skills.put(Orc.SkillName.DIRTY_KICK, new Skill());
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public EnemyFactory.EnemyClass getEnemyClass() {
        return EnemyFactory.EnemyClass.ORC;
    }

    public Map getSkills() {
        return this.skills;
    }
}
