/*
 * CE00882-1  Object Oriented and Event Driven Programming
 * Assignment
 */
package assignment;

/**
 * Alex J Davison
 * @author dv003874
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LettingAgencyGUI extends JFrame implements ActionListener, MouseListener {

    private LettingsAgency theLettingsAgency = new LettingsAgency("Octagon Lettings Agency", 5);
    private int eNumButtons,  wNumButtons,  noTextBox,  numOfRooms,  option = 0;
    private double rent;
    private JButton eB[],  wB[];
    private String eLables[],  wLables[],  lablesbox[],  textArea = "Output displayed here",  tf[] = {
        "True", "False"
    };
    private Font exitFont,  enterFont,  titleText;
    private JTextArea display;
    private JTextField textbox[];
    private JFormattedTextField ftextbox[];
    private JLabel textBoxLables[],  title;
    private JComboBox combo;
    private boolean roomOnly;

    /**
     *
     */
    public static void main(String[] args) {
        new LettingAgencyGUI();
    }

    public LettingAgencyGUI() {
        super("Octagon Lettings Agency");
        setSize(800, 600);
        setLocation(0, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        setVisible(true);

    }

    public void init() {

        //Buttons

        wNumButtons = 10;
        wB = new JButton[wNumButtons];
        wLables = new String[wNumButtons];

        //Set name on buttons

        wLables[0] = "1:  Add a house.";
        wLables[1] = "2:  Add a lodging.";
        wLables[2] = "3:  Display all free houses.";
        wLables[3] = "4:  Display all free lodging.";
        wLables[4] = "5:  Display all properties.";
        wLables[5] = "6:  Rent property.";
        wLables[6] = "7:  Re-rent property.";
        wLables[7] = "8:  Remove property.";
        wLables[8] = "9:  Find property.";
        wLables[wLables.length - 1] = "Exit";

        getContentPane().setBackground(Color.BLACK);

        JPanel pw = new JPanel();

        pw.setLayout(new GridLayout(wNumButtons, 1));
        pw.setBackground(Color.BLACK);

        for (int i = 0; i < wB.length; i++) {
            wB[i] = new JButton(wLables[i]);
            pw.add(wB[i]);
            wB[i].setForeground(Color.RED);
            wB[i].addMouseListener(this);
            wB[i].addActionListener(this);
        }

        getContentPane().add("West", pw);

        exitFont = wB[0].getFont();
        enterFont = new Font(exitFont.getFontName(),
                exitFont.getStyle(),
                exitFont.getSize() + 2);

        //Text display

        display = new JTextArea(textArea);
        display.setEditable(false);
        display.setForeground(Color.WHITE);
        display.setBackground(Color.BLACK);

        JScrollPane ps = new JScrollPane(display);

        getContentPane().add("South", ps);

        //Text feilds

        noTextBox = 8;
        textBoxLables = new JLabel[noTextBox];
        lablesbox = new String[noTextBox];

        lablesbox[0] = "Landlord's first name: ";
        lablesbox[1] = "Landlord's surname: ";
        lablesbox[2] = "Address of Propery: ";
        lablesbox[3] = "Tenant's first name: ";
        lablesbox[4] = "Tenant's surname: ";
        lablesbox[5] = "Rent: ";
        lablesbox[6] = "Number of rooms: ";
        lablesbox[7] = "Room only: ";


        //Center Panel

        JPanel pc = new JPanel();

        pc.setLayout(new GridLayout(noTextBox, 2));
        pc.setBackground(Color.BLACK);

        textbox = new JTextField[5];

        for (int i = 0; i < textbox.length; i++) {
            textbox[i] = new JTextField(10);
            textBoxLables[i] = new JLabel(lablesbox[i]);
            textBoxLables[i].setForeground(Color.WHITE);
            pc.add(textBoxLables[i]);
            pc.add(textbox[i]);
        }

        ftextbox = new JFormattedTextField[2];

        ftextbox[0] = new JFormattedTextField();
        ftextbox[0].setValue(new Double(rent));
        ftextbox[0].setColumns(10);
        textBoxLables[5] = new JLabel(lablesbox[5]);
        textBoxLables[5].setForeground(Color.WHITE);
        pc.add(textBoxLables[5]);
        pc.add(ftextbox[0]);

        ftextbox[1] = new JFormattedTextField();
        ftextbox[1].setValue(new Integer(numOfRooms));
        ftextbox[1].setColumns(10);
        textBoxLables[6] = new JLabel(lablesbox[6]);
        textBoxLables[6].setForeground(Color.WHITE);
        pc.add(textBoxLables[6]);
        pc.add(ftextbox[1]);

        combo = new JComboBox();

        combo = new JComboBox(tf);
        textBoxLables[7] = new JLabel(lablesbox[7]);
        textBoxLables[7].setForeground(Color.WHITE);
        pc.add(textBoxLables[7]);
        pc.add(combo);


        getContentPane().add("Center", pc);

        //Title

        titleText = new Font("Arial", Font.BOLD, 36);
        title = new JLabel("Octagon Lettings Agency.", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(titleText);
        getContentPane().add("North", title);

        //East Panel

        JPanel pe = new JPanel();

        eNumButtons = 2;
        eB = new JButton[eNumButtons];
        eLables = new String[eNumButtons];

        //Set name on buttons
        eLables[0] = "Submit";
        eLables[1] = "Rest";


        pe.setLayout(new GridLayout(eNumButtons, 1));
        pe.setBackground(Color.BLACK);

        for (int i = 0; i < eB.length; i++) {
            eB[i] = new JButton(eLables[i]);
            pe.add(eB[i]);
            eB[i].setForeground(Color.RED);
            eB[i].addMouseListener(this);
            eB[i].addActionListener(this);
        }

        getContentPane().add("East", pe);

        //

        hideAll();

    }

    public void start() {
        System.out.println("starting...");
    }

    public void stop() {
        System.out.println("stopping...");
    }

    public void destroy() {
        System.out.println("preparing to unload...");
    }

    /**
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == eB[0]) {
            switch (option) {
                case 1:
                    submitHouse();
                    break;
                case 2:
                    submitLodging();
                    break;
                case 3:
                    submitRent();
                    break;
                case 4:
                    submitReRent();
                    break;
                case 5:
                    submitRemove();
                    break;
                case 6:
                    submitFind();
                    break;
            }
        } else if (e.getSource() == eB[1]) {
            restAll();
        } else if (e.getSource() == wB[0]) {
            option = 1;
            addHouse();
        } else if (e.getSource() == wB[1]) {
            option = 2;
            addLodging();
        } else if (e.getSource() == wB[2]) {
            hideAll();

            if (theLettingsAgency.outputFreeHouseDetails().toString().equals("[]")) {
                JOptionPane.showMessageDialog(null, "No free houses");
            } else {
                textArea = theLettingsAgency.outputFreeHouseDetails().toString();
                display.setText(textArea);
            }

        } else if (e.getSource() == wB[3]) {
            hideAll();

            if (theLettingsAgency.outputFreeLodgingDetails().toString().equals("[]")) {
                JOptionPane.showMessageDialog(null, "No free lodging");
            } else {
                textArea = theLettingsAgency.outputFreeLodgingDetails().toString();
                display.setText(textArea);
            }
        } else if (e.getSource() == wB[4]) {
            hideAll();

            if (theLettingsAgency.outputPropertyDetails().toString().equals("[]")) {
                JOptionPane.showMessageDialog(null, "No free properties");
            } else {
                textArea = theLettingsAgency.outputPropertyDetails().toString();
                display.setText(textArea);
            }
        } else if (e.getSource() == wB[5]) {
            option = 3;
            rentProperty();
        } else if (e.getSource() == wB[6]) {
            option = 4;
            findProperty();
        } else if (e.getSource() == wB[7]) {
            option = 5;
            findProperty();
        } else if (e.getSource() == wB[8]) {
            option = 6;
            findProperty();
        } else if (e.getSource() == wB[9]) {
            System.exit(0);
        }

    }

    /**
     *
     * @param e
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     *
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     *
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
    }

    /**
     *
     * @param e
     */
    public void mouseEntered(MouseEvent e) {
        JButton b = (JButton) e.getSource();
        b.setFont(enterFont);
    }

    /**
     *
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        JButton b = (JButton) e.getSource();
        b.setFont(exitFont);
    }

    /**
     *
     */
    public void hideAll() {
        restAll();
        for (int i = 0; i < textBoxLables.length; i++) {
            textBoxLables[i].setVisible(false);
        }

        for (int i = 0; i < textbox.length; i++) {
            textbox[i].setVisible(false);
        }

        for (int i = 0; i < ftextbox.length; i++) {
            ftextbox[i].setVisible(false);
        }

        for (int i = 0; i < eB.length; i++) {
            eB[i].setVisible(false);
        }

        combo.setVisible(false);

    }

    /**
     *
     */
    public void restAll() {
        textArea = "Output displayed here";
        display.setText(textArea);

        textbox[0].setText("");
        textbox[1].setText("");
        textbox[2].setText("");
        textbox[3].setText("");
        textbox[4].setText("");

        ftextbox[0].setText("0");
        ftextbox[1].setText("0");

        combo.setSelectedIndex(0);
    }

    /**
     *
     */
    public void addHouse() {
        restAll();

        textBoxLables[0].setVisible(true);
        textBoxLables[1].setVisible(true);
        textBoxLables[2].setVisible(true);
        textBoxLables[3].setVisible(false);
        textBoxLables[4].setVisible(false);
        textBoxLables[5].setVisible(true);
        textBoxLables[6].setVisible(true);
        textBoxLables[7].setVisible(false);

        textbox[0].setVisible(true);
        textbox[1].setVisible(true);
        textbox[2].setVisible(true);
        textbox[3].setVisible(false);
        textbox[4].setVisible(false);

        ftextbox[0].setVisible(true);
        ftextbox[1].setVisible(true);

        combo.setVisible(false);

        eB[0].setVisible(true);
        eB[1].setVisible(true);

    }

    /**
     *
     */
    public void addLodging() {
        restAll();

        textBoxLables[0].setVisible(true);
        textBoxLables[1].setVisible(true);
        textBoxLables[2].setVisible(true);
        textBoxLables[3].setVisible(false);
        textBoxLables[4].setVisible(false);
        textBoxLables[5].setVisible(true);
        textBoxLables[6].setVisible(false);
        textBoxLables[7].setVisible(true);

        textbox[0].setVisible(true);
        textbox[1].setVisible(true);
        textbox[2].setVisible(true);
        textbox[3].setVisible(false);
        textbox[4].setVisible(false);

        ftextbox[0].setVisible(true);
        ftextbox[1].setVisible(false);

        combo.setVisible(true);

        eB[0].setVisible(true);
        eB[1].setVisible(true);
    }

    /**
     *
     */
    public void submitHouse() {
        rent = ((Number) ftextbox[0].getValue()).doubleValue();
        numOfRooms = ((Number) ftextbox[1].getValue()).intValue();
        House h = new House(textbox[0].getText(), textbox[1].getText(), textbox[2].getText(), rent, numOfRooms);
        if ((textbox[0].getText().equals("")) || (textbox[1].getText().equals("")) || (textbox[2].getText().equals("")) || (rent <= 0) || (numOfRooms <= 0)) {
            JOptionPane.showMessageDialog(null, "Please check your input");
        } else if (theLettingsAgency.addProperty(h)) {
            restAll();
            JOptionPane.showMessageDialog(null, "House added");
        } else {
            restAll();
            JOptionPane.showMessageDialog(null, "Sorry house not added");
        }
    }

    /**
     *
     */
    public void submitLodging() {
        rent = ((Number) ftextbox[0].getValue()).doubleValue();
        roomOnly = roomOnly();
        Lodging l = new Lodging(textbox[0].getText(), textbox[1].getText(), textbox[2].getText(), rent, roomOnly);

        if ((textbox[0].getText().equals("")) || (textbox[1].getText().equals("")) || (textbox[2].getText().equals("")) || (rent <= 0)) {
            JOptionPane.showMessageDialog(null, "Please check your input");
        } else {
            if (theLettingsAgency.addProperty(l)) {
                restAll();
                JOptionPane.showMessageDialog(null, "Lodging added");
            } else {
                restAll();
                JOptionPane.showMessageDialog(null, "Sorry lodging not added");
            }
        }

    }

    /**
     *
     */
    public void submitRent() {
        if ((textbox[2].getText().equals("")) || (textbox[3].getText().equals("")) || (textbox[4].getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Please check your input");
        } else {
            if (theLettingsAgency.rentProperty(textbox[2].getText(), textbox[3].getText(), textbox[4].getText())) {
                restAll();
                JOptionPane.showMessageDialog(null, "Property rented");
            } else {
                restAll();
                JOptionPane.showMessageDialog(null, "Property not found");
            }
        }
    }

    /**
     *
     */
    public void submitReRent() {
        if (textbox[2].getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please check your input");
        } else {
            if (theLettingsAgency.reRentProperty(textbox[2].getText())) {
                restAll();
                JOptionPane.showMessageDialog(null, "Property ready for re-renting");
            } else {
                restAll();
                JOptionPane.showMessageDialog(null, "Property not found");
            }
        }

    }

    /**
     *
     */
    public void submitRemove() {
        if (textbox[2].getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please check your input");
        } else {
            if (theLettingsAgency.deleteProperty(textbox[2].getText())) {
                restAll();
                JOptionPane.showMessageDialog(null, "Property removed");
            } else {
                restAll();
                JOptionPane.showMessageDialog(null, "Property not found");
            }
        }
    }

    /**
     *
     */
    public void findProperty() {
        restAll();

        textBoxLables[0].setVisible(false);
        textBoxLables[1].setVisible(false);
        textBoxLables[2].setVisible(true);
        textBoxLables[3].setVisible(false);
        textBoxLables[4].setVisible(false);
        textBoxLables[5].setVisible(false);
        textBoxLables[6].setVisible(false);
        textBoxLables[7].setVisible(false);

        textbox[0].setVisible(false);
        textbox[1].setVisible(false);
        textbox[2].setVisible(true);
        textbox[3].setVisible(false);
        textbox[4].setVisible(false);

        ftextbox[0].setVisible(false);
        ftextbox[1].setVisible(false);

        combo.setVisible(false);

        eB[0].setVisible(true);
        eB[1].setVisible(true);
    }

    /**
     *
     */
    public void rentProperty() {
        restAll();

        textBoxLables[0].setVisible(false);
        textBoxLables[1].setVisible(false);
        textBoxLables[2].setVisible(true);
        textBoxLables[3].setVisible(true);
        textBoxLables[4].setVisible(true);
        textBoxLables[5].setVisible(false);
        textBoxLables[6].setVisible(false);
        textBoxLables[7].setVisible(false);

        textbox[0].setVisible(false);
        textbox[1].setVisible(false);
        textbox[2].setVisible(true);
        textbox[3].setVisible(true);
        textbox[4].setVisible(true);

        ftextbox[0].setVisible(false);
        ftextbox[1].setVisible(false);

        combo.setVisible(false);

        eB[0].setVisible(true);
        eB[1].setVisible(true);
    }

    /**
     *
     * @return
     */
    public boolean roomOnly() {
        if ((String) combo.getSelectedItem() == "True") {
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void submitFind() {
        if (textbox[2].getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please check your input");
        } else {
            Property p = theLettingsAgency.findProperty(textbox[2].getText());
            if (p == null) {
                JOptionPane.showMessageDialog(null, "No property found");
            } else {
                textArea = p.toString();
                display.setText(textArea);
            }
        }
    }
}