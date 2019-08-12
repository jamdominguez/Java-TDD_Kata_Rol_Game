package Skills;

import java.util.HashMap;
import java.util.Map;

public abstract class Skill {
    public enum CombatState {POWER_DOWN_50, POWER_DOWN_20, POISONED_5, DAMAGE_IN_TIME_10}
    private Map<CombatState, Integer> combatStates;
    private int coolDown;
    private int manaNeeded;

    public Skill(){
        this.combatStates = new HashMap<CombatState, Integer>();
    }

    public int getManaNeeded() {
        return this.manaNeeded;
    }

    public void setManaNeeded(int i){}

    public int getCoolDown() {
        return this.coolDown;
    }

    public Map getCombatStates() {
        return this.combatStates;
    }

    public void addCombatState(CombatState combatState, int turns){
        this.combatStates.put(combatState, turns);
    }

    public void setCoolDown(int coolDown){
        this.coolDown = coolDown;
    }

    public abstract int dealDamage(int power, int spellPower);


}
