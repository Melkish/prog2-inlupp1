/**
 * Created by Melke on 26/03/16.
 */

public class Jewelry extends Valuable {

    private int amountOfGems;
    private boolean isMadeByGold;
    private String material;

    public Jewelry (String name, int amountOfGems, boolean isMadeByGold) {
        super (name);
        this.amountOfGems = amountOfGems;
        this.isMadeByGold = isMadeByGold;
        if (isMadeByGold == true) {
            material = "gold";
        } else {
            material = "silver";
        }
    }

    @Override
    public int value() {
        int value;
        if (isMadeByGold == true) {
            value = 2000;
        } else {
            value = 700;
        }

        value = value + (500 * amountOfGems);
        return value;
    }

    public String toString() {
        return "Jewelry: " + super.getName() + " value: " + super.getValue() + " gems: " + amountOfGems + " " + material;
    }
}
