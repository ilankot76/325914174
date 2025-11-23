public class GameWorld {

    private String name;
    private Player[] players;
    private Enemy[] enemies;
    private int difficulty;

    public GameWorld() {
        this("Crystalpath", 1, new Player[0], new Enemy[0]);
    }

    public GameWorld(String name, int difficulty, Player[] players, Enemy[] enemies) {
        this.name = name;
        this.difficulty = clampDifficulty(difficulty);
        this.players = (players != null) ? players.clone() : new Player[0];
        this.enemies = (enemies != null) ? enemies.clone() : new Enemy[0];
    }

    private int clampDifficulty(int d) {
        if (d < 1) return 1;
        if (d > 3) return 3;
        return d;
    }

    public void addPlayer(Player p) {
        Player[] newArr = new Player[players.length + 1];
        System.arraycopy(players, 0, newArr, 0, players.length);
        newArr[players.length] = p;
        players = newArr;
    }

    public void printAllPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("------------- Player " + (i + 1) + " -------------");
            System.out.println(players[i]);
            System.out.println();
        }
    }

    public int getTotalValueOfWorld() {
        int sum = 0;
        for (Player p : players) sum += p.calculateInventoryValue();
        return sum;
    }

    @Override
    public String toString() {
        return "World Name: " + name + System.lineSeparator()
                + "Difficulty: " + difficulty + System.lineSeparator()
                + "Number of players: " + players.length;
    }
}
