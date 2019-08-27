package Characters;

import Skills.Skill;
import Skills.SkillFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class GameCharacter {

    protected int life;
    protected int mana;
    protected int power;
    protected int spellPower;
    protected int armor;
    protected int spellArmor;
    protected Map<Skill.CombatState, Integer> combatStates;
    protected Map<SkillFactory.SkillName, Integer> skillsInCD;
    protected Map<Skill.DamageType, Integer> damageInTime;

    public GameCharacter() {
        this.combatStates = new HashMap<Skill.CombatState, Integer>();
        this.skillsInCD = new HashMap<SkillFactory.SkillName, Integer>();
        this.damageInTime = new HashMap<Skill.DamageType, Integer>();
        this.damageInTime.put(Skill.DamageType.PHYSICAL, 0);
        this.damageInTime.put(Skill.DamageType.MAGICAL, 0);
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

    public void dealDamageInTime() {
        updatePhysicalDamage(this.damageInTime.get(Skill.DamageType.PHYSICAL));
        updateMagicalDamage(this.damageInTime.get(Skill.DamageType.MAGICAL));
    };

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

    public boolean addCombatState(Skill.CombatState state, int turns, int damageBased) {
        this.combatStates.put(state, turns);
        switch (state) {
            case POWER_DOWN_50:
                this.power = power / 2;
                return true;
            case POWER_DOWN_20:
                this.power = (power / 5) * 4;
                return true;
            case POISONED_5:
                this.setDamageInTime((damageBased*5)/100, Skill.DamageType.PHYSICAL);
                return true;
            case DAMAGE_IN_TIME_10:
                this.setDamageInTime((damageBased*10)/100, Skill.DamageType.MAGICAL);
                return true;
            default:
                return false;
        }

    }

    protected void setDamageInTime(int damage, Skill.DamageType damageType){
        if (Skill.DamageType.PHYSICAL == damageType) {
            int currentDamage = this.damageInTime.get(Skill.DamageType.PHYSICAL);
            this.damageInTime.put(Skill.DamageType.PHYSICAL, currentDamage + damage);
        } else if ((Skill.DamageType.MAGICAL == damageType)) {
            int currentDamage = this.damageInTime.get(Skill.DamageType.MAGICAL);
            this.damageInTime.put(Skill.DamageType.MAGICAL, currentDamage + damage);
        }
    };

    public Map<Skill.CombatState, Integer> getCombatStates() {
        return this.combatStates;
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public abstract Map<SkillFactory.SkillName, Skill> getSkills();

    public Map<SkillFactory.SkillName, Integer> getSkillsInCD(){
        return this.skillsInCD;
    }

    public void addSkillInCD(SkillFactory.SkillName skillName, int cd){
        this.skillsInCD.put(skillName, cd);
    }

    public void updateSkillInCD(SkillFactory.SkillName skillName) {
        if (isSkillInCD(skillName)) {
            int newCD = this.skillsInCD.get(skillName) - 1;
            if (newCD == 0) this.skillsInCD.remove(skillName); // remove skill cd
            else this.skillsInCD.put(skillName, newCD); // update skill cd
        }
    }

    public void updateSkillsInCD(){
        Set<SkillFactory.SkillName> keys = this.skillsInCD.keySet();
        for (SkillFactory.SkillName key : keys){
            updateSkillInCD(key);
        }
    };

    public boolean isSkillInCD(SkillFactory.SkillName skillName){
        return this.skillsInCD.containsKey(skillName);
    }

    public void updateStatesInCDs(){
        Set<Skill.CombatState> keys = this.combatStates.keySet();
        for (Skill.CombatState key : keys){
            updateStateInCD(key);
        }
    }

    public boolean isStateInCD(Skill.CombatState state){
        return this.combatStates.containsKey(state);
    }

    protected void updateStateInCD(Skill.CombatState state){
        if (isStateInCD(state)) {
            int newCD = this.combatStates.get(state) - 1;
            if (newCD == 0) this.combatStates.remove(state); // remove state cd
            else this.combatStates.put(state, newCD); // update state cd
        }
    }
}
