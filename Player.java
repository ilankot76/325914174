public class Player extends Character {

    private Item[] inventory;

    public Player(String name, int health, int level) {
        super(name, health, level);
        this.inventory = new Item[0];
    }

    public Player(String name, int health, int level, Item[] inventory) {
        super(name, health, level);
        if (inventory != null)
            this.inventory = inventory.clone();
        else
            this.inventory = new Item[0];
    }

    public void addItem(Item item) {
        if (item == null) return;

        Item[] newInv = new Item[inventory.length + 1];
        System.arraycopy(inventory, 0, newInv, 0, inventory.length);
        newInv[inventory.length] = item;
        inventory = newInv;
    }

    public int calculateInventoryValue() {
        int sum = 0;
        for (Item i : inventory) {
            if (i != null) sum += i.getValue();
        }
        return sum;
    }

    public boolean hasMagicalItem() {
        for (Item i : inventory) {
            if (i != null && i.isMagical()) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Inventory: ");
        if (inventory.length == 0) {
            sb.append("Empty");
        } else {
            for (int i = 0; i < inventory.length; i++) {
                sb.append(inventory[i].getName());
                if (i < inventory.length - 1) sb.append(" | ");
            }
        }
        return sb.toString();
    }
}
