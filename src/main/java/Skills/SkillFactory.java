package Skills;

public class SkillFactory {
    public enum SkillName {MELEE_ATTACK, BRUTAL_STRIKE, MUTILATE, LET_IT_GO, BURN_ALL, BLADE_WITH_POISON, DIRTY_KICK}

    public static Skill getSkill(SkillName skillName){
        switch (skillName) {
            case MELEE_ATTACK:
                return new MeleeAttack();
            case BRUTAL_STRIKE:
                return new BrutalStrike();
            case MUTILATE:
                return new Mutilate();
            case LET_IT_GO:
                return new LetItGo();
            case BURN_ALL:
                return new BurnAll();
            case BLADE_WITH_POISON:
                return new BladeWithPoison();
            case DIRTY_KICK:
                return new DirtyKick();
            default:
                return null;
        }
    }
}
