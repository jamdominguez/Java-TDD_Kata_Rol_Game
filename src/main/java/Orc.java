public class Orc extends Enemy {

    public Orc() {
        this.life = getRandomValue(50, 300);
        this.mana = getRandomValue(30, 50);
        this.power = getRandomValue(3, 6);
        this.spellPower = getRandomValue(2, 4);
        this.armor = getRandomValue(3, 5);
        this.spellArmor = getRandomValue(3, 5);
        ;
    }

    public String getDescription() {
        return "Orc";
    }

    public EnemyFactory.EnemyClass getHeroClass() {
        return EnemyFactory.EnemyClass.ORC;
    }

    private int getRandomValue(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- ").append(getHeroClass()).append(" --\n");
        sb.append("Life: ").append(getLife()).append("\n");
        sb.append("Mana: ").append(getMana()).append("\n");;
        sb.append("Power: ").append(getPower()).append("\n");;
        sb.append("SpellPower: ").append(getSpellPower()).append("\n");;
        sb.append("Armor: ").append(getArmor()).append("\n");;
        sb.append("SpellArmor: ").append(getSpellArmor()).append("\n");;

        return sb.toString();
    }
}
