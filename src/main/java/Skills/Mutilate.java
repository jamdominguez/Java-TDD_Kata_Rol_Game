package Skills;

public class Mutilate extends Skill {
    public Mutilate() {
        setCoolDown(4);
        addCombatState(CombatState.POWER_DOWN_50, 2);
    }

    public int dealDamage(int power, int spellPower) {
        return (int) Math.random();
    }
}
