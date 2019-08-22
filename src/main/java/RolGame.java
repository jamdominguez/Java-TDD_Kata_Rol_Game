import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;

import java.util.*;

public class RolGame {

    public enum State {COMBAT, NO_COMBAT}
    private State state;
    private CombatManager combatManager;
    private Player player;
    private Map<EnemyFactory.EnemyClass, Enemy> enemiesInGame;

    public CombatManager getCombatManager() {
        return this.combatManager;
    }

    public RolGame() {
        this.state = State.NO_COMBAT;
        this.combatManager = new CombatManager();
        this.enemiesInGame = new HashMap<EnemyFactory.EnemyClass, Enemy>();
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
        int number = (int) (Math.random() * enemiesNumber + 1);
        for (int i = 0; i < number; i++){
            int randomEnemyIndex = (int) (Math.random() * EnemyFactory.EnemyClass.values().length);
            Enemy enemy = EnemyFactory.getEnemy(EnemyFactory.EnemyClass.values()[randomEnemyIndex]);
            this.enemiesInGame.put(enemy.getEnemyClass(), enemy);
        }
    }

    public Map<EnemyFactory.EnemyClass, Enemy> getEnemiesInGame() {
        return enemiesInGame;
    }

    public void setEnemiesInGame(Map<EnemyFactory.EnemyClass, Enemy> enemiesInGame) {
        this.enemiesInGame = enemiesInGame;
    }

    public boolean isGameOver() {
        return getPlayer().getHeroes().get(0).getLife() == 0;
    }

    public boolean isGameWon() {
        for (Map.Entry<EnemyFactory.EnemyClass, Enemy> entry : enemiesInGame.entrySet()) {
            if (entry.getValue().getLife() != 0) return false;
        }
        return true;
    }
}
