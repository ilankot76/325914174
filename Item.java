public class Item {

    private String name;
    private int value;
    private boolean isMagical;

    public Item() {
        this("Unknown", 0, false);
    }

    public Item(String name, int value, boolean isMagical) {
        this.name = name;
        setValue(value);
        this.isMagical = isMagical;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            this.value = 0;
        } else {
            this.value = value;
        }
    }

    public boolean isMagical() {
        return isMagical;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(System.lineSeparator());
        sb.append("Value: ").append(value).append(System.lineSeparator());
        sb.append(isMagical ? "Magical item" : "Non-magical item");
        return sb.toString();
    }
}
