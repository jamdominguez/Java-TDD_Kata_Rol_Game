public class Wizard extends Hero {

    public Wizard() {
        this.life = 70;
        this.mana = 200;
        this.power = 5;
        this.spellPower = 30;
        this.spellArmor = 10;
    }

    public String getDescription() {
        return "Wizard";
    }

    public HeroFactory.HeroClass getHeroClass() {
        return HeroFactory.HeroClass.WIZARD;
    }
}
