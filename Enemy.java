public class Enemy extends Character {

    private static final int MIN_DAMAGE = 1;
    private static final int MAX_DAMAGE = 5;

    private int damage;

    public Enemy(String name, int health, int level, int damage) {
        super(name, health, level);
        this.damage = clampDamage(damage);
    }

    private int clampDamage(int d) {
        if (d < MIN_DAMAGE) return MIN_DAMAGE;
        if (d > MAX_DAMAGE) return MAX_DAMAGE;
        return d;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Damage: " + damage;
    }
}
