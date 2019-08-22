package Skills;

public class BladeWithPoison extends Skill{
    public BladeWithPoison() {
        setCoolDown(3);
        addCombatState(CombatState.POISONED_5, 2);
        setDamageType(DamageType.PHYSICAL);
        setSkillName(SkillFactory.SkillName.BLADE_WITH_POISON);
    }

    public int dealDamage(int power, int spellPower) {
        return (int) (Math.random() * power);
    }
}
