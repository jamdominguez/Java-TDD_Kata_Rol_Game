package Skills;

public class Mutilate extends Skill {
    public Mutilate() {
        setCoolDown(4);
        addCombatState(CombatState.POWER_DOWN_50, 2);
        setDamageType(DamageType.PHYSICAL);
        setSkillName(SkillFactory.SkillName.MUTILATE);
    }

    public int dealDamage(int power, int spellPower) {
        return (int) (Math.random() * power);
    }
}
