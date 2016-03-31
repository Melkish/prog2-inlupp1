import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Melke on 26/03/16.
 */
public class ValuableRegistry extends JFrame {

    private ArrayList<Valuable> valuables = new ArrayList<Valuable>();
    String[] typesOfValuables = {"Jewelry","Appliance","Stock"};
    private JComboBox<String> chooseValuableToCreate = new JComboBox<String>(typesOfValuables);
    private JTextArea display;
    private JRadioButton sortByNameButton;
    private JRadioButton sortByValueButton;


    public ValuableRegistry() {

        Color myGreen = new Color(179, 245, 223);

        JPanel lower = new JPanel();
        add(lower, BorderLayout.SOUTH);
        lower.add(new JLabel("New"));
        lower.add(chooseValuableToCreate);
        JButton showButton = new JButton("Show");
        lower.add(showButton);
        JButton stockCrashButton = new JButton("Stock crash");
        lower.add(stockCrashButton);
        lower.setBackground(myGreen);
        //showButton.addActionListener(new ShowLyss());

        JPanel upper = new JPanel();
        add(upper, BorderLayout.NORTH);
        JLabel valuableRegistryLabel = new JLabel("Valuable registry");
        Font f = new Font("New york", Font.BOLD, 16);
        valuableRegistryLabel.setFont(f);
        upper.add(valuableRegistryLabel);
        upper.setBackground(myGreen);

        JPanel right = new JPanel();
        add(right, BorderLayout.EAST);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.add(new JLabel("Sort by:"));
        sortByValueButton = new JRadioButton("Value");
        right.add(sortByValueButton);
        sortByNameButton = new JRadioButton("Name");
        right.add(sortByNameButton);
        ButtonGroup bg = new ButtonGroup();
        bg.add(sortByValueButton);
        bg.add(sortByNameButton);
        right.setBackground(myGreen);

        display = new JTextArea();
        JScrollPane scroll = new JScrollPane(display);
        add(scroll, BorderLayout.CENTER);
        display.setEditable(false);

        setLocation(450, 100);
        setSize(400, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void main(String[] args) {
        new ValuableRegistry();
        }
    }
