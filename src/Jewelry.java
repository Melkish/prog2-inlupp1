/**
 * Created by Melke on 26/03/16.
 */
public class Jewelry extends Valuable {

    private int amountOfGems;
    private boolean isSilver;


    public Jewelry (String name, int amountOfGems, boolean isSilver) {
        super (name);
        this.amountOfGems = amountOfGems;
        this.isSilver = isSilver;
    }

    @Override
    public int value() {
        int value;
        if (isSilver != true) {
            value = 2000;
        } else {
            value = 700;
        }

        value = value + (500 * amountOfGems);
        return value;
    }

    public int getAmountOfGems() {
        return this.amountOfGems;
    }

    public boolean getIsSilver() {
        return this.isSilver;
    }
}
