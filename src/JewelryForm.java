import javax.swing.*;

/**
 * Created by Melke on 02/04/16.
 */

public class JewelryForm extends JPanel {

    private JTextField nameField = new JTextField(10);
    private JTextField gemField = new JTextField(5);
    private JCheckBox goldCheckBox = new JCheckBox("Made by gold: ");

    public JewelryForm() {
        JPanel firstRow = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        firstRow.add(new JLabel("Name: "));
        firstRow.add(nameField);
        add(firstRow);

        JPanel secondRow = new JPanel();
        secondRow.add(new JLabel("Amount of gems: "));
        secondRow.add(gemField);
        add(secondRow);
        add(goldCheckBox);
    }

    public String getName(){
        return nameField.getText();
    }
    public int getAmountOfGems(){
        return Integer.parseInt(gemField.getText());
    }
    public boolean getMadeByGold(){
        return goldCheckBox.isSelected();
    }
}
