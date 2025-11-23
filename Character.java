public class Character {

    private static final int MIN_HEALTH = 0;
    private static final int MAX_HEALTH = 10;
    private static final int MIN_LEVEL = 0;
    private static final int MAX_LEVEL = 5;

    private String name;
    private int health;
    private int level;

    public Character() {
        this("Unknown", 0, 0);
    }

    public Character(String name, int health, int level) {
        this.name = name;
        this.health = clamp(health, MIN_HEALTH, MAX_HEALTH);
        this.level = clamp(level, MIN_LEVEL, MAX_LEVEL);
    }

    private int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        if (level < MAX_LEVEL) {
            level++;
        }
    }

    public void heal(int amount) {
        if (amount <= 0) return;
        health = clamp(health + amount, MIN_HEALTH, MAX_HEALTH);
    }

    @Override
    public String toString() {
        return "Name: " + name + System.lineSeparator()
                + "Health: " + health + System.lineSeparator()
                + "Level: " + level;
    }
}
