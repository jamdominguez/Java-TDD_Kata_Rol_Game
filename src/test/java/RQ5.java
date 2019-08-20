import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import org.junit.Assert;
import org.junit.Test;

public class RQ5 {
    @Test
    public void RQ5_warriorHasAttributesValues() {
        Hero warrior = HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR);
        int life = 100;
        int mana = 0;
        int power = 20;
        int spellPower = 0;
        int armor = 10;
        int spellArmor = 0;
        Assert.assertEquals(life, warrior.getLife());
        Assert.assertEquals(mana, warrior.getMana());
        Assert.assertEquals(power, warrior.getPower());
        Assert.assertEquals(spellPower, warrior.getSpellPower());
        Assert.assertEquals(armor, warrior.getArmor());
        Assert.assertEquals(spellArmor, warrior.getSpellArmor());
    }

    @Test
    public void RQ5_wizardHasAttributesValues() {
        Hero wizard = HeroFactory.getHero(HeroFactory.HeroClass.WIZARD);
        int life = 70;
        int mana = 200;
        int power = 5;
        int spellPower = 30;
        int armor = 0;
        int spellArmor = 10;
        Assert.assertEquals(life, wizard.getLife());
        Assert.assertEquals(mana, wizard.getMana());
        Assert.assertEquals(power, wizard.getPower());
        Assert.assertEquals(spellPower, wizard.getSpellPower());
        Assert.assertEquals(armor, wizard.getArmor());
        Assert.assertEquals(spellArmor, wizard.getSpellArmor());
    }
}
