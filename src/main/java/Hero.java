public class Hero {
    private final String type;
    private int life;
    private int mana;
    private int power;
    private int spellPower;
    private int armor;
    private int spellArmor;

    public Hero(String heroType) {
        this.type = heroType;
        if ("Warrior".equals(heroType)) {
            this.life = 100;
            this.power = 20;
            this.armor = 10;
        } else if ("Wizard".equals(heroType)) {
            this.life = 70;
            this.mana = 200;
            this.power = 5;
            this.spellPower = 30;
            this.spellArmor = 10;
        }
    }

    public String getType() {
        return this.type;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpellArmor() {
        return spellArmor;
    }

    public void setSpellArmor(int spellArmor) {
        this.spellArmor = spellArmor;
    }
}
