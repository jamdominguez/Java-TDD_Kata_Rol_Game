public class HeroFactory {

    public enum HeroClass {WARRIOR, WIZARD};

    public static Hero getHero(HeroClass heroClass){
        switch (heroClass) {
            case WARRIOR:
                return new Warrior();
            case WIZARD:
                return new Wizard();
            default:
                return null;
        }
    }
}
