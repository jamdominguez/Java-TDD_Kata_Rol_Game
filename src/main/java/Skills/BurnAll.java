package Skills;

public class BurnAll extends Skill{
    public BurnAll() {
        setManaNeeded(50);
        setCoolDown(4);
        addCombatState(CombatState.DAMAGE_IN_TIME_10, 2);
        setDamageType(DamageType.MAGICAL);
    }

    public int dealDamage(int power, int spellPower) {
        return (int) (Math.random() * spellPower * 3);
    }
}
