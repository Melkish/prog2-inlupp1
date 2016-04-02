import javax.swing.*;

/**
 * Created by Melke on 02/04/16.
 */
public class StockForm extends JPanel{

    private JTextField nameField = new JTextField(10);
    private JTextField amountField = new JTextField(5);
    private JTextField courseField = new JTextField(5);

    public StockForm() {
        JPanel firstRow = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        firstRow.add(new JLabel("Name: "));
        firstRow.add(nameField);
        add(firstRow);

        JPanel secondRow = new JPanel();
        secondRow.add(new JLabel("Amount; "));
        secondRow.add(amountField);
        add(secondRow);

        JPanel thirdRow = new JPanel();
        thirdRow.add(new JLabel("Course: "));
        thirdRow.add(courseField);
        add(thirdRow);
    }

    public String getName(){
        return nameField.getText();
    }
    public int getAmount(){
        return Integer.parseInt(amountField.getText());
    }

    public int getCourse(){
        return Integer.parseInt(courseField.getText());
    }
}


