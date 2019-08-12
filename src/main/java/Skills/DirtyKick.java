package Skills;

public class DirtyKick extends Skill{
    public DirtyKick() {
        setCoolDown(5);
        addCombatState(CombatState.POWER_DOWN_20, 2);
    }

    public int dealDamage(int power, int spellPower) {
        return (int) Math.random();
    }
}
