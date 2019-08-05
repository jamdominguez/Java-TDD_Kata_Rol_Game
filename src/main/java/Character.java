public abstract class Character {

    protected int life;
    protected int mana;
    protected int power;
    protected int spellPower;
    protected int armor;
    protected int spellArmor;

    public abstract String getDescription();

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

    protected int getRandomValue(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- ").append(getDescription()).append(" --\n");
        sb.append("Life: ").append(getLife()).append("\n");
        sb.append("Mana: ").append(getMana()).append("\n");
        sb.append("Power: ").append(getPower()).append("\n");
        sb.append("SpellPower: ").append(getSpellPower()).append("\n");
        sb.append("Armor: ").append(getArmor()).append("\n");
        sb.append("SpellArmor: ").append(getSpellArmor()).append("\n");
        return sb.toString();
    }
}