/**
 * Created by Melke on 26/03/16.
 */

public abstract class Valuable {
    private String name;

    public Valuable (String name) {
        this.name = name;
    }

    public abstract int value();

    public String getName() {
        return this.name;
    }

    public int getValue() {
        float valueAsDecimal = (float)value() * 1.25f;
        int value = Math.round(valueAsDecimal);
        return value;
    }
}
