public class Game {

    public static void main(String[] args) {

        // Items
        Item sword = new Item("Ice Sword", 3, true);
        Item grimoire = new Item("Grimoire", 5, true);
        Item shield = new Item("Guardian Shield", 4, false);
        Item wand = new Item("Wand of Winds", 2, true);

        // Players
        Player p1 = new Player("Elara the Enchanter", 10, 3);
        Player p2 = new Player("Kael the Windcaller", 10, 4);

        p1.addItem(grimoire);
        p1.addItem(sword);

        p2.addItem(shield);
        p2.addItem(wand);

        // Enemy
        Enemy goblin = new Enemy("Goblin", 10, 2, 3);

        // World
        GameWorld world = new GameWorld();
        world.addPlayer(p1);
        world.addPlayer(p2);

        // Print players
        System.out.println("Players in world:");
        world.printAllPlayers();

        // Print inventory values
        System.out.println("Inventory values:");
        System.out.println(p1.getName() + " = " + p1.calculateInventoryValue());
        System.out.println(p2.getName() + " = " + p2.calculateInventoryValue());

        // Battle
        simulateBattle(p1, goblin);
    }

    public static void simulateBattle(Player p, Enemy e) {
        System.out.println(p.getName() + " - level: " + p.getLevel()
                + " VS " + e.getName() + " - level: " + e.getLevel());

        if (p.getLevel() > e.getLevel()) {
            p.levelUp();
            System.out.println(p.getName() + " wins!");
        } else if (p.getLevel() < e.getLevel()) {
            e.levelUp();
            System.out.println(e.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
