package Skills;

public class BrutalStrike extends Skill {
    public BrutalStrike() {
        setCoolDown(3);
        setDamageType(DamageType.PHYSICAL);
    }
    public int dealDamage(int power, int spellPower) {
        return (int) (Math.random() * power * 2);
    }
}
