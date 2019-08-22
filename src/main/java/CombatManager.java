import Characters.GameCharacter;
import Skills.Skill;
import Skills.SkillFactory;

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

    public SkillFactory.SkillName executeActionIA(GameCharacter executor, List<GameCharacter> targets) {
        // Get executor skills
        Map<SkillFactory.SkillName, Skill> skills = executor.getSkills();
        // Get a random number
        int randomIndex = (int) (Math.random() * skills.size());
        // Get a skill name into the executor skills
        SkillFactory.SkillName skillName = (SkillFactory.SkillName) skills.keySet().toArray()[randomIndex];
        // Get a skill into the executor skills
        Skill skill = skills.get(skillName);
        // Execute action with these skill
        executeAction(executor, targets, skill);
        return skillName;
    }

    public int getMaxHeroesByCombat() {
        return 1;
    }

    public int getMaxEnemiesByCombat() {
        return 1;
    }

    public int[] getMaxCharactersIncCombatBySide() {
        int[] characters = {getMaxHeroesByCombat(), getMaxEnemiesByCombat()};
        return characters;
    }
}
