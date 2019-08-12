import java.util.HashMap;
import java.util.Map;

public class Wizard extends Hero {

    public static String DESCRIPTION = "Wizard";
    public enum SkillName {MELEE_ATTACK, LET_IT_GO, BURN_ALL};
    private Map skills;

    public Wizard() {
        this.life = 70;
        this.mana = 200;
        this.power = 5;
        this.spellPower = 30;
        this.spellArmor = 10;
        this.skills = new HashMap();
        this.skills.put(Wizard.SkillName.MELEE_ATTACK, new Skill());
        this.skills.put(Wizard.SkillName.LET_IT_GO, new Skill());
        this.skills.put(Wizard.SkillName.BURN_ALL, new Skill());
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


}
