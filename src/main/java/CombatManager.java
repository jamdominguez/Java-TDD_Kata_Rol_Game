import Characters.GameCharacter;
import Skills.Skill;
import Skills.SkillFactory;

import java.util.List;
import java.util.Map;

public class CombatManager {
    private int turn;
    private String lastInfo;
    private List<GameCharacter> characters;

    public CombatManager(List<GameCharacter> characters) {
        this.characters = characters;
    }

    public int getTurn() {
        return this.turn;
    }

    public void nextTurn() {
        updateSkillsCDs();
        updateStatesCDs();
        this.turn++;
    }

    public void start() {
        this.lastInfo = "Combat Start";
        this.turn = 0;
    }

    public void executeAction(GameCharacter executor, List<GameCharacter> targets, Skill skill) {
        int executorMana = executor.getMana();
        String msg;
        if (!executor.isSkillInCD(skill.getSkillName())) {
            if (executorMana >= skill.getManaNeeded()) {
                int manaUpdated = executorMana - skill.getManaNeeded();
                executor.setMana(manaUpdated);
                int damage = skill.dealDamage(executor.getPower(), executor.getSpellPower());
                msg = "Execution action damage " + damage + " from " + executor.getDescription() + " with " + skill + " and " + skill.getManaNeeded() + " mana needed";
                Map<Skill.CombatState, Integer> skillStates = skill.getCombatStates();
                for (GameCharacter target : targets) {
                    target.dealDamage(damage, skill.getDamageType());
                    for (Map.Entry entry : skillStates.entrySet()) {
                        target.addCombatState((Skill.CombatState) entry.getKey(), (Integer) entry.getValue(), damage);
                        target.dealDamageInTime();
                    }

                }
                if (skill.getCoolDown() != 0) executor.addSkillInCD(skill.getSkillName(), skill.getCoolDown());
            } else {
                msg = "Not enough mana " + executorMana + " to execue skill " + skill;
                System.out.println(msg);
            }
            this.lastInfo = msg;
            this.turn++;
        } else {
            msg = "Skill " + skill.getSkillName() + " in cd ";
            System.out.println(msg);
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

    public String getLastInfo() {
        return this.lastInfo;
    }

    public void end() {
        this.lastInfo = "Combat End";
    }

    public void updateSkillsCDs(){
        for (GameCharacter character : characters){
            character.updateSkillsInCD();
        }
    }

    public void updateStatesCDs(){
        for (GameCharacter character : characters){
            character.updateStatesInCDs();
        }
    }
}
