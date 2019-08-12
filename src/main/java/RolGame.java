import Characters.Enemies.Enemy;
import Characters.Enemies.EnemyFactory;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RolGame {

    public enum State {COMBAT, NO_COMBAT}
    private State state;
    private CombatManager combatManager;
    private static Map<HeroFactory.HeroClass, Hero> heroes;
    private static Map<EnemyFactory.EnemyClass, Enemy> enemies;
    private Player player;

    static {
        heroes = new HashMap<HeroFactory.HeroClass, Hero>();
        heroes.put(HeroFactory.HeroClass.WARRIOR, HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR));
        heroes.put(HeroFactory.HeroClass.WIZARD, HeroFactory.getHero(HeroFactory.HeroClass.WIZARD));
        enemies = new HashMap<EnemyFactory.EnemyClass, Enemy>();
        enemies.put(EnemyFactory.EnemyClass.ORC, EnemyFactory.getEnemy(EnemyFactory.EnemyClass.ORC));
    }

    public CombatManager getCombatManager() {
        return this.combatManager;
    }

    public RolGame() {
        this.state = State.NO_COMBAT;
        this.combatManager = new CombatManager();
    }

    public State getState() {
        return state;
    }

    public static Map<HeroFactory.HeroClass, Hero> getHeroes() {
        return heroes;
    }

    public static Hero getHero(HeroFactory.HeroClass heroClass) {
        return heroes.get(heroClass);
    }

    public static Map getEnemies() {
        return enemies;
    }

    public static Enemy getEnemy(EnemyFactory.EnemyClass enemyClass) {
        return enemies.get(enemyClass);
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
}
