import java.util.HashMap;
import java.util.Map;

public class Wizard extends Hero {

    public static String DESCRIPTION = "Wizard";

    public Wizard() {
        this.life = 70;
        this.mana = 200;
        this.power = 5;
        this.spellPower = 30;
        this.spellArmor = 10;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    public HeroFactory.HeroClass getHeroClass() {
        return HeroFactory.HeroClass.WIZARD;
    }

    public Map getSkills() {
        Map skills = new HashMap();
        skills.put(0, "Skill0");
        return skills;
    }
}
