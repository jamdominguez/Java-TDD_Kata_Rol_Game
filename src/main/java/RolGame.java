import java.util.HashMap;
import java.util.Map;

public class RolGame {
    private static Map<String,Hero> heroes;

    static {
        heroes = new HashMap<String, Hero>();
        heroes.put("Warrior",new Hero("Warrior"));
        heroes.put("Wizard",new Hero("Wizard"));
    }

    public Map<String,Hero> getHeroes() {
        return heroes;
    }

    public Hero getHero(String heroType) {
        return heroes.get(heroType);
    }
}
