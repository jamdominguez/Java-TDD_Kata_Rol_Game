package Characters;

import Skills.Skill;
import Skills.SkillFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class GameCharacter {

    protected int life;
    protected int mana;
    protected int power;
    protected int spellPower;
    protected int armor;
    protected int spellArmor;
    protected Map<Skill.CombatState, Integer> combatStates;

    public GameCharacter() {
        this.combatStates = new HashMap<Skill.CombatState, Integer>();
    }

    public abstract String getDescription();

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpellArmor() {
        return spellArmor;
    }

    public void setSpellArmor(int spellArmor) {
        this.spellArmor = spellArmor;
    }

    protected int getRandomValue(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- ").append(getDescription()).append(" --\n");
        sb.append("Life: ").append(getLife()).append("\n");
        sb.append("Mana: ").append(getMana()).append("\n");
        sb.append("Power: ").append(getPower()).append("\n");
        sb.append("SpellPower: ").append(getSpellPower()).append("\n");
        sb.append("Armor: ").append(getArmor()).append("\n");
        sb.append("SpellArmor: ").append(getSpellArmor()).append("\n");
        sb.append("Combat States: \n");
        for (Map.Entry entry : this.combatStates.entrySet()) {
            sb.append(" - ").append(entry.getKey()).append(" | ").append(entry.getValue()).append(" turns remains\n");
        }
        return sb.toString();
    }

    public void dealDamage(int damage, Skill.DamageType damageType) {
        if (Skill.DamageType.PHYSICAL == damageType) updatePhysicalDamage(damage);
        else if (Skill.DamageType.MAGICAL == damageType) updateMagicalDamage(damage);
        if (getLife() < 0) setLife(0);
    }

    private void updatePhysicalDamage(int damage) {
        if (this.getArmor() > 0) {
            this.setArmor(this.getArmor() - damage); // first remove armor
            if (this.getArmor() < 0) { // more damage than armor
                this.setLife(this.getLife() + this.getArmor()); // recalculate the life
                this.setArmor(0); // armor can't be negative, set to 0
            }
        } else {
            this.setLife(this.getLife() - damage);
        }
    }

    private void updateMagicalDamage(int damage) {
        if (this.getSpellArmor() > 0) {
            this.setSpellArmor(this.getSpellArmor() - damage); // first remove spellarmor
            if (this.getSpellArmor() < 0) { // more damage than armor
                this.setLife(this.getLife() + this.getSpellArmor()); // recalculate the life
                this.setSpellArmor(0); // armor can't be negative, set to 0
            }
        } else {
            this.setLife(this.getLife() - damage);
        }
    }

    public int getCombatState(Skill.CombatState state) throws CombatStateException {
        if (this.combatStates.containsKey(state)) return this.combatStates.get(state);
        else throw new CombatStateException();
    }

    public void addCombatState(Skill.CombatState state, int turns) {
        this.combatStates.put(state, turns);
    }

    public Map<Skill.CombatState, Integer> getCombatStates() {
        return this.combatStates;
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public abstract Map<SkillFactory.SkillName, Skill> getSkills();
}
