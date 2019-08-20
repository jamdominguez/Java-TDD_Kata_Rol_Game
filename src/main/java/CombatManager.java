import Characters.GameCharacter;
import Skills.Skill;

import java.util.List;
import java.util.Map;

public class CombatManager {
    private int turn;

    public int getTurn() {
        return this.turn;
    }

    public void nextTurn() {
        this.turn++;
    }

    public void start() {
        this.turn = 0;
    }

    public void executeAction(GameCharacter executor, List<GameCharacter> targets, Skill skill) {
        int executorMana = executor.getMana();
        if (executorMana >= skill.getManaNeeded()) {
            executor.setMana(executorMana - skill.getManaNeeded());
            int damage = skill.dealDamage(executor.getPower(), executor.getSpellPower());
            //System.out.println("Execution action damage " + damage + " from " + executor.getDescription() + " with " + skill+ " and " + skill.getManaNeeded() + " mana needed\n");
            Map<Skill.CombatState, Integer> skillStates = skill.getCombatStates();
            for (GameCharacter target : targets) {
                target.dealDamage(damage, skill.getDamageType());
                for (Map.Entry entry : skillStates.entrySet()) {
                    target.addCombatState((Skill.CombatState) entry.getKey(), (Integer) entry.getValue());
                }
            }
        } else {
            System.out.println("Not enough mana " + executorMana + " to execue skill " + skill);
        }
    }
}
