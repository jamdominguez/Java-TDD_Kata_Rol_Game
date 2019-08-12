package Skills;

public class MeleeAttack extends Skill {

    public int dealDamage(int power, int spellPower) {
        return (int) (Math.random() * power);
    }
}
