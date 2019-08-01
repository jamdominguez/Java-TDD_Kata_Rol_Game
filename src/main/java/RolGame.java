import java.util.HashMap;
import java.util.Map;

public class RolGame {
    private static Map<String,Hero> heroes;
    private Player player;

    static {
        heroes = new HashMap<String, Hero>();
        heroes.put("Warrior",new Hero("Warrior"));
        heroes.put("Wizard",new Hero("Wizard"));
    }

    public static Map<String,Hero> getHeroes() {
        return heroes;
    }

    public static Hero getHero(String heroType) {
        return heroes.get(heroType);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addPlayer(String id) {
        this.player = new Player(id);
    }
}
