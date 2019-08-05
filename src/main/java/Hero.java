import java.util.Map;

public abstract class Hero extends Character {
    public abstract HeroFactory.HeroClass getHeroClass();

    public abstract Map getSkills();
}
