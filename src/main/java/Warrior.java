import java.util.HashMap;
import java.util.Map;

public class Warrior extends Hero {

    public static String DESCRIPTION = "Warrior";

    public Warrior() {
        this.life = 100;
        this.power = 20;
        this.armor = 10;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public HeroFactory.HeroClass getHeroClass() {
        return HeroFactory.HeroClass.WARRIOR;
    }

    public Map getSkills() {
        Map skills = new HashMap();
        skills.put(0, "Skill0");
        return skills;
    }
}
