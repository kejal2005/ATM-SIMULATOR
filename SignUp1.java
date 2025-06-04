import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class SignUp1 extends JFrame implements ActionListener {

    private JTextField nameField,
                       fnameField,
                       dobField,
                       emailField,
                       addressField,
                       cityField,
                       stateField,
                       pincodeField;
    private JButton next;
    private JRadioButton maleBtn, femaleBtn, otherGenderBtn;
    private JRadioButton marriedBtn, unmarriedBtn, otherMarriedBtn;
    private String formNo = "" + Math.abs(new Random().nextInt(9000) + 1000);

    public SignUp1() {
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Application Form No. " + formNo);
        heading.setBounds(120, 20, 500, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(heading);

        JLabel page1 = new JLabel("Page 1: Personal Details");
        page1.setBounds(180, 60, 300, 30);
        page1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(page1);

        // Name
        addLabel("Name:", 60, 110);
        nameField = addTextField(200, 110);

        // Father's Name
        addLabel("Father's Name:", 60, 150);
        fnameField = addTextField(200, 150);

        // Date of Birth
        addLabel("Date of Birth (DD/MM/YYYY):", 60, 190);
        dobField = addTextField(260, 190);

        // Gender
        addLabel("Gender:", 60, 230);
        maleBtn  = addRadio("Male",   200, 230);
        femaleBtn= addRadio("Female", 300, 230);
        otherGenderBtn = addRadio("Other", 400, 230);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        genderGroup.add(otherGenderBtn);

        // Email
        addLabel("Email Address:", 60, 270);
        emailField = addTextField(200, 270);

        // Marital Status
        addLabel("Marital Status:", 60, 310);
        marriedBtn      = addRadio("Married",    200, 310);
        unmarriedBtn    = addRadio("Unmarried",  300, 310);
        otherMarriedBtn = addRadio("Other",      400, 310);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(marriedBtn);
        maritalGroup.add(unmarriedBtn);
        maritalGroup.add(otherMarriedBtn);

        // Address
        addLabel("Address:", 60, 350);
        addressField = addTextField(200, 350);

        // City
        addLabel("City:", 60, 390);
        cityField = addTextField(200, 390);

        // State
        addLabel("State:", 60, 430);
        stateField = addTextField(200, 430);

        // Pin Code
        addLabel("Pin Code:", 60, 470);
        pincodeField = addTextField(200, 470);

        // Next button
        next = new JButton("Next");
        next.setBounds(400, 520, 100, 30);
        styleButton(next);
        next.addActionListener(this);
        add(next);

        // Frame settings
        setSize(600, 600);
        setLocation(400, 100);
        setTitle("Sign Up - Page 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setVisible(true);
    }

    // Helper to add a JLabel
    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 200, 25);
        lbl.setFont(new Font("Calibri", Font.PLAIN, 18));
        add(lbl);
    }

    // Helper to add a JTextField
    private JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 300, 25);
        add(tf);
        return tf;
    }

    // Helper to add a JRadioButton
    private JRadioButton addRadio(String text, int x, int y) {
        JRadioButton rb = new JRadioButton(text);
        rb.setBounds(x, y, 100, 25);
        rb.setBackground(Color.white);
        add(rb);
        return rb;
    }

    // Helper to style buttons uniformly
    private void styleButton(JButton b) {
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Collect values
        String name    = nameField.getText().trim();
        String fname   = fnameField.getText().trim();
        String dob     = dobField.getText().trim();
        String gender  = maleBtn.isSelected()   ? "Male"
                       : femaleBtn.isSelected() ? "Female"
                       : otherGenderBtn.isSelected() ? "Other"
                       : "";
        String email   = emailField.getText().trim();
        String marital = marriedBtn.isSelected()      ? "Married"
                       : unmarriedBtn.isSelected()    ? "Unmarried"
                       : otherMarriedBtn.isSelected() ? "Other"
                       : "";
        String address = addressField.getText().trim();
        String city    = cityField.getText().trim();
        String state   = stateField.getText().trim();
        String pin     = pincodeField.getText().trim();

        // TODO: validate fields here...

        try {
            mysql c = new mysql();
            String query = String.format(
                "INSERT INTO signup VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                formNo, name, fname, dob, gender, email, marital, address, city, state, pin
            );
            c.s.executeUpdate(query);
            // move to next page
            setVisible(false);
            new SignUp2(formNo).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignUp1();
    }
}
