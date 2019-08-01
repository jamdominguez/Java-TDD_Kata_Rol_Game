import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private List<Hero> heroes;

    public Player(String id) {
        this.heroes = new ArrayList<Hero>();
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public void select(HeroFactory.HeroClass heroClass) {
        if (this.heroes.size() != 0) this.heroes.clear();
        this.heroes.add(HeroFactory.getHero(heroClass));
    }

    public void resetHeroSelection() {
        this.heroes = new ArrayList<Hero>();
    }
}