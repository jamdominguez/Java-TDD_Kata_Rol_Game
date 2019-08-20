package Skills;

import java.util.HashMap;
import java.util.Map;

public abstract class Skill {
    public enum CombatState {POWER_DOWN_50, POWER_DOWN_20, POISONED_5, DAMAGE_IN_TIME_10}
    protected Map<CombatState, Integer> combatStates;
    protected int coolDown;
    protected int manaNeeded;

    protected DamageType damageType;

    public Skill(){
        this.combatStates = new HashMap<CombatState, Integer>();
    }

    public int getManaNeeded() {
        return this.manaNeeded;
    }

    public void setManaNeeded(int manaNeeded){
        this.manaNeeded = manaNeeded;
    }

    public int getCoolDown() {
        return this.coolDown;
    }

    public Map<CombatState, Integer> getCombatStates() {
        return this.combatStates;
    }

    public void addCombatState(CombatState combatState, int turns){
        this.combatStates.put(combatState, turns);
    }

    public void setCoolDown(int coolDown){
        this.coolDown = coolDown;
    }

    public abstract int dealDamage(int power, int spellPower);

    public enum DamageType {PHYSICAL, MAGICAL}

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public DamageType getDamageType() {
        return damageType;
    }
}
