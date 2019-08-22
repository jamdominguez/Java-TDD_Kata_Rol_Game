package Skills;

public class LetItGo extends Skill{
    public LetItGo() {
        setManaNeeded(10);
        setDamageType(DamageType.MAGICAL);
        setSkillName(SkillFactory.SkillName.LET_IT_GO);
    }

    public int dealDamage(int power, int spellPower) {
        return (int) (Math.random() * spellPower);
    }
}
