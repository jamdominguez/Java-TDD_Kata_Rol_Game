public abstract class Enemy {

    protected int life;
    protected int mana;
    protected int power;
    protected int spellPower;
    protected int armor;
    protected int spellArmor;

    public abstract String getDescription();

    public abstract EnemyFactory.EnemyClass getHeroClass();

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
