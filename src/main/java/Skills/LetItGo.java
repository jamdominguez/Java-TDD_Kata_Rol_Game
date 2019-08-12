package Skills;

public class LetItGo extends Skill{
    public LetItGo() {
        setManaNeeded(10);
    }

    public int dealDamage(int power, int spellPower) {
        return (int) (Math.random() * spellPower);
    }
}
