import java.util.Map;

public abstract class Enemy extends Character {
    public abstract EnemyFactory.EnemyClass getEnemyClass();

    public abstract Map getSkills();
}
