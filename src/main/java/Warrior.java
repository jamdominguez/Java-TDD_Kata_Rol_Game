import java.util.HashMap;
import java.util.Map;

public class Warrior extends Hero {

    public static String DESCRIPTION = "Warrior";
    public enum SkillName {MELEE_ATTACK, BRUTAL_STRIKE, MUTILATE};
    private Map skills;

    public Warrior() {
        this.life = 100;
        this.power = 20;
        this.armor = 10;
        this.skills = new HashMap();
        this.skills.put(SkillName.MELEE_ATTACK, new Skill());
        this.skills.put(SkillName.BRUTAL_STRIKE, new Skill());
        this.skills.put(SkillName.MUTILATE, new Skill());

    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public HeroFactory.HeroClass getHeroClass() {
        return HeroFactory.HeroClass.WARRIOR;
    }

    public Map getSkills() {
        return this.skills;
    }
}
