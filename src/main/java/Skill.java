import java.util.LinkedList;
import java.util.List;

public class Skill {
    public enum CombatState {POWER_DOWN, DAMAGE_IN_TIME, POISONED}
    private List<CombatState> combatStates;

    public Skill(){
        this.combatStates = new LinkedList<CombatState>();
    }

    public int getManaNeeded() {
        return 0;
    }

    public int getCoolDown() {
        return 0;
    }

    public List<CombatState> getCombatStates() {
        return this.combatStates;
    }

    public void addCombatState(CombatState combatState){
        this.combatStates.add(combatState);
    }
}
