public class RolGame {
    public Object[] getHeroes() {
        return new Object[2];
    }

    public Hero getHero(String heroType) {
        return new Hero(heroType);
    }
}
