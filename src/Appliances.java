/**
 * Created by Melke on 26/03/16.
 */

public class Appliances extends Valuable {
    private int buyPrice;
    private int wear;

    public Appliances (String name, int buyPrice, int wear) {
        super (name);
        this.buyPrice = buyPrice;
        this.wear = wear;
    }

    @Override
    public int value() {
        float valueAsDecimal = buyPrice * ((float)wear/10);
        int value = Math.round(valueAsDecimal);
        return value;
    }

    public String toString() {
        return "Appliance: " + super.getName() + " value: " + super.getValue() + " price: " + buyPrice + " wear: " + wear;
    }
}
