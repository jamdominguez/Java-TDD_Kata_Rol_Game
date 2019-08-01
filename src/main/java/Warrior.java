public class Warrior extends Hero {

    public Warrior() {
        this.life = 100;
        this.power = 20;
        this.armor = 10;
    }

    public String getDescription() {
        return "Warrior";
    }

    public HeroFactory.HeroClass getHeroClass() {
        return HeroFactory.HeroClass.WARRIOR;
    }
}
