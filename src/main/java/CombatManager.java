import Characters.GameCharacter;
import Skills.Skill;

import java.util.List;

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
        int damage = skill.dealDamage(executor.getPower(), executor.getSpellPower());
        System.out.println(skill.getDamageType().toString() + " " + damage);
        for (GameCharacter target : targets) {
            target.dealDamage(damage, skill.getDamageType());
        }
    }
}
