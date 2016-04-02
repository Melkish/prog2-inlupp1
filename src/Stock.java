/**
 * Created by Melke on 26/03/16.
 */
public class Stock extends Valuable {
    private int amount;
    private int course;

    public Stock(String name, int amount, int course) {
        super (name);
        this.amount =  amount;
        this.course = course;
    }

    @Override
    public int value() {
        int value = amount * course;
        return value;
    }

    public String toString() {
        return "Stock: " + super.getName() + " value: " + super.getValue() + " amount: " + amount + " course: " + course;
    }

    public void setCourse(int newCourse) {
        this.course = newCourse;
    }
}
