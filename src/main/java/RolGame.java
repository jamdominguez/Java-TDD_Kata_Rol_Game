import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;

import java.util.*;

public class RolGame {

    public enum Level {EASY, MEDIUM, HARD}
    public enum State {COMBAT, NO_COMBAT}
    private State state;
    private CombatManager combatManager;
    private Player player;
    private LinkedList<Enemy> enemiesInGame;

    public CombatManager getCombatManager() {
        return this.combatManager;
    }

    public RolGame() {
        this.state = State.NO_COMBAT;
        this.enemiesInGame = new LinkedList<Enemy>();
    }

    public void setCombatManager(CombatManager combatManager){
        this.combatManager = combatManager;
    }

    public State getState() {
        return state;
    }

    public static HeroFactory.HeroClass[] getHeroesToSelect() {
        return HeroFactory.HeroClass.values();
    }

    public static Hero getHero(HeroFactory.HeroClass heroClass) {
        return HeroFactory.getHero(heroClass);
    }

    public static EnemyFactory.EnemyClass[] getEnemiesToSelect() {
        return EnemyFactory.EnemyClass.values();
    }

    public static Enemy getEnemy(EnemyFactory.EnemyClass enemyClass) {
        return EnemyFactory.getEnemy(enemyClass);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addPlayer(String id) {
        this.player = new Player(id);
    }

    public List<Hero> getPlayerHeroes() {
        return this.player.getHeroes();
    }

    public void updateState() {
        if (this.player.isEnemyFound()) this.state = State.COMBAT;
        else this.state = State.NO_COMBAT;
    }

    public void startCombat() {
        this.state = State.COMBAT;
    }

    public void endCombat() {
        this.state = State.NO_COMBAT;
    }

    public void setRandomEnemies(int enemiesNumber) {
        this.enemiesInGame = new LinkedList<Enemy>();
        int enemiesTypeInFactory = EnemyFactory.EnemyClass.values().length;
        for (int i = 0; i < enemiesNumber; i++){
            int randomEnemyIndex = (int) (Math.random() * enemiesTypeInFactory);
            Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.values()[randomEnemyIndex]);
            this.enemiesInGame.add(enemy);
        }
    }

    public LinkedList getEnemiesInGame() {
        return this.enemiesInGame;
    }

    public void setEnemiesInGame(LinkedList<Enemy> enemiesInGame) {
        this.enemiesInGame = enemiesInGame;
    }

    public boolean isGameOver() {
        return getPlayer().getHeroes().get(0).getLife() == 0;
    }

    public boolean isGameWon() {
        for (Enemy enemy : this.enemiesInGame) {
            if (enemy.getLife() != 0) return false;
        }
        return true;
    }

    public void start(Level level) {
        switch (level){
            case EASY:
                setRandomEnemies(1);
                break;
            case MEDIUM:
                setRandomEnemies(3);
                break;
            case HARD:
                setRandomEnemies(5);
                break;
        }
    }
}
