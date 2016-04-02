import javax.swing.*;

/**
 * Created by Melke on 02/04/16.
 */
public class ApplianceForm extends JPanel {

    private JTextField nameField = new JTextField(10);
    private JTextField priceField = new JTextField(5);
    private JTextField wearField = new JTextField(5);

    public ApplianceForm() {
        JPanel firstRow = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        firstRow.add(new JLabel("Name: "));
        firstRow.add(nameField);
        add(firstRow);

        JPanel secondRow = new JPanel();
        secondRow.add(new JLabel("Price: "));
        secondRow.add(priceField);
        add(secondRow);

        JPanel thirdRow = new JPanel();
        thirdRow.add(new JLabel("Wear: "));
        thirdRow.add(wearField);
        add(thirdRow);
    }

    public String getName(){
        return nameField.getText();
    }
    public int getPrice(){
        return Integer.parseInt(priceField.getText());
    }

    public int getWear(){
        return Integer.parseInt(wearField.getText());
    }
}
