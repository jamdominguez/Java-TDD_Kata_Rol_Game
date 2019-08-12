package Characters.Enemies;

public class EnemyFactory {

    public enum EnemyClass {ORC}

    ;

    public static Enemy getEnemy(EnemyClass enemyClass) {
        switch (enemyClass) {
            case ORC:
                return new Orc();
            default:
                return null;
        }
    }
}
