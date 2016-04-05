import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Melke on 26/03/16.
 */
public class ValuableRegistry extends JFrame {

    private ArrayList<Valuable> valuables = new ArrayList<>();
    String[] typesOfValuables = {"Jewelry", "Appliance", "Stock"};
    private JComboBox<String> chooseValuableToCreate = new JComboBox<>(typesOfValuables);
    private JTextArea display;
    private JRadioButton sortByNameButton;
    private JRadioButton sortByValueButton;
    Color myRed = new Color(143, 23, 21);
    Color myGray = new Color(211, 218, 218);

    public static void main(String[] args) {
        new ValuableRegistry();
    }

    public ValuableRegistry() {

        JPanel lower = new JPanel();
        add(lower, BorderLayout.SOUTH);
        JLabel newLabel = new JLabel("New");
        lower.add(newLabel);
        newLabel.setForeground(myGray);

        JPanel left = new JPanel();
        add(left, BorderLayout.WEST);
        JLabel emptyLabel = new JLabel("hejhej");
        left.add(emptyLabel);
        emptyLabel.setForeground(myRed);
        left.setBackground(myRed);

        lower.add(chooseValuableToCreate);
        JButton showButton = new JButton("Show");
        showButton.setForeground(Color.DARK_GRAY);
        lower.add(showButton);

        JButton stockCrashButton = new JButton("Stock crash");
        lower.add(stockCrashButton);
        stockCrashButton.setForeground(Color.DARK_GRAY);
        lower.setBackground(myRed);

        chooseValuableToCreate.addActionListener(new NewListener());
        showButton.addActionListener(new ShowListener());
        stockCrashButton.addActionListener(new StockCrashListener());


        JPanel upper = new JPanel();
        add(upper, BorderLayout.NORTH);
        JLabel valuableRegistryLabel = new JLabel("Register your valuables here!");
        Font f = new Font("New york", Font.BOLD, 16);
        valuableRegistryLabel.setFont(f);
        valuableRegistryLabel.setForeground(myGray);
        upper.add(valuableRegistryLabel);
        upper.setBackground(myRed);

        JPanel right = new JPanel();
        add(right, BorderLayout.EAST);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        JLabel sortLabel = new JLabel("Sort by:");
        Font n = new Font ("New York", Font.BOLD, 14);
        sortLabel.setFont(n);
        right.add(sortLabel);
        sortLabel.setForeground(myGray);

        sortByValueButton = new JRadioButton("Value", true);
        right.add(sortByValueButton);
        sortByValueButton.setForeground(myGray);

        sortByNameButton = new JRadioButton("Name");
        right.add(sortByNameButton);
        sortByNameButton.setForeground(myGray);

        ButtonGroup bg = new ButtonGroup();
        bg.add(sortByValueButton);
        bg.add(sortByNameButton);
        right.setBackground(myRed);

        display = new JTextArea();
        JScrollPane scroll = new JScrollPane(display);
        add(scroll, BorderLayout.CENTER);
        display.setEditable(false);
        display.setBackground(myGray);

        setLocation(450, 100);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }


    public class ShowListener implements ActionListener {

        public void actionPerformed(ActionEvent ave) {
            display.setText("");
            if (sortByNameButton.isSelected()) {
                Collections.sort(valuables, new NameCmp());

                for (Valuable v : valuables)
                    display.append(v.toString() + "\n");
            } else if (sortByValueButton.isSelected()) {
                Collections.sort(valuables, new ValueCmp());

                for (Valuable v : valuables)
                    display.append(v.toString() + "\n");
            }
        }
    }

    class NameCmp implements Comparator <Valuable> {
        public int compare(Valuable v1, Valuable v2) {
            String n1 = v1.getName();
            String n2 = v2.getName();
            return n1.compareTo(n2);
        }
    }

    class ValueCmp implements Comparator<Valuable> {
        public int compare(Valuable v1, Valuable v2) {
            return v1.getValue() - v2.getValue();
        }
    }

    public class NewListener implements ActionListener {

        public void actionPerformed(ActionEvent ave) {
            String chosenValuable = (String) chooseValuableToCreate.getSelectedItem();

            if (chosenValuable.equalsIgnoreCase("Jewelry")) {
                try {
                    JewelryForm j = new JewelryForm();
                    int answer = JOptionPane.showConfirmDialog(ValuableRegistry.this, j,
                            "Create new jewelry registry",
                            JOptionPane.OK_CANCEL_OPTION);
                    if (answer != JOptionPane.OK_OPTION)
                        return;
                    String name = j.getName();
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(ValuableRegistry.this, "No name");
                        return;
                    }
                    int gems = j.getAmountOfGems();
                    boolean isMadeByGold = j.getMadeByGold();

                    Jewelry jewelry = new Jewelry(name, gems, isMadeByGold);
                    valuables.add(jewelry);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(ValuableRegistry.this,"Wrong input! Please try again");
                }

            } else if (chosenValuable.equalsIgnoreCase("Stock")) {
                try {
                    StockForm s = new StockForm();
                    int answer = JOptionPane.showConfirmDialog(ValuableRegistry.this, s,
                            "Create new stock registry",
                            JOptionPane.OK_CANCEL_OPTION);
                    if (answer != JOptionPane.OK_OPTION)
                        return;
                    String name = s.getName();
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(ValuableRegistry.this, "No name");
                        return;
                    }
                    int amount = s.getAmount();
                    int course = s.getCourse();

                    Stock stock = new Stock(name, amount, course);
                    valuables.add(stock);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(ValuableRegistry.this,"Wrong input! Please try again");
                }

            } else if (chosenValuable.equalsIgnoreCase("Appliance")) {
                try {
                    ApplianceForm a = new ApplianceForm();
                    int answer = JOptionPane.showConfirmDialog(ValuableRegistry.this, a,
                            "Create new appliance registry",
                            JOptionPane.OK_CANCEL_OPTION);
                    if (answer != JOptionPane.OK_OPTION)
                        return;
                    String name = a.getName();
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(ValuableRegistry.this, "No name");
                        return;
                    }
                    int price = a.getPrice();
                    int wear = a.getWear();

                    Appliances appliances = new Appliances(name, price, wear);
                    valuables.add(appliances);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(ValuableRegistry.this,"Wrong input! Please try again");
                }
            }
        }
    }

    public class StockCrashListener implements ActionListener {
        public void actionPerformed(ActionEvent ave) {
            for (Valuable v : valuables) {
                if (v instanceof Stock){
                   Stock s = (Stock) v;
                    s.setCourse(0);
                }
            }
        }
    }
}
