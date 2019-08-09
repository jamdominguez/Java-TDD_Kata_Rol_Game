public class CombatManager {
    private int turn;

    public int getTurn() {
        return this.turn;
    }

    public void nextTurn() {
        this.turn++;
    }

    public void start() {
        this.turn = 0;
    }
}
