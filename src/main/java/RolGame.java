import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RolGame {
    private static Map<HeroFactory.HeroClass, Hero> heroes;
    private static Map<String, Enemy> enemies;
    private Player player;

    static {
        heroes = new HashMap<HeroFactory.HeroClass, Hero>();
        heroes.put(HeroFactory.HeroClass.WARRIOR, HeroFactory.getHero(HeroFactory.HeroClass.WARRIOR));
        heroes.put(HeroFactory.HeroClass.WIZARD, HeroFactory.getHero(HeroFactory.HeroClass.WIZARD));
        enemies = new HashMap<String, Enemy>();
        enemies.put("Orc", new Enemy("Orc"));
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

    public static Enemy getEnemy(String enemyType) {
        return enemies.get(enemyType);
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
}
