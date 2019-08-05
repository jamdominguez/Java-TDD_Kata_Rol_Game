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
}
