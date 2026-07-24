package exp14.src;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class StudentRegistrationForm extends JFrame {
    JTextField txtName;
    JTextField txtEmail;
    JComboBox<String> cmbCourse;
    JComboBox<String> cmbYear;
    JRadioButton male;
    JRadioButton female;
    JPasswordField txtPin;
    JLabel lblID;
    public StudentRegistrationForm() {
        setTitle("Student Registration");
        setSize(500,500);
        setLayout(new GridLayout(8,2));
        txtName = new JTextField();
        txtEmail = new JTextField();
        cmbCourse = new JComboBox<>(
                new String[]{
                        "Computer",
                        "IT",
                        "Mechanical"
                });
        cmbYear = new JComboBox<>(
                new String[]{
                        "FY",
                        "SY",
                        "TY"
                });
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg =
                new ButtonGroup();
        bg.add(male);
        bg.add(female);
        txtPin =
                new JPasswordField();
        JButton btnRegister =
                new JButton("Register");
        JButton btnReset =
                new JButton("Reset");
        lblID =
                new JLabel();
        add(new JLabel("Name"));
        add(txtName);
        add(new JLabel("Email"));
        add(txtEmail);
        add(new JLabel("Course"));
        add(cmbCourse);
        add(new JLabel("Year"));
        add(cmbYear);
        add(male);
        add(female);
        add(new JLabel("PIN"));
        add(txtPin);
        add(btnRegister);
        add(btnReset);
        add(lblID);
        btnRegister.addActionListener(
                e -> registerStudent()
        );
        btnReset.addActionListener(
                e -> clearForm()
        );
        setVisible(true);
    }
    private void registerStudent() {
        try {
            Connection con =
                    DBConnection.getConnection();
            String sql =
                    "INSERT INTO students(name,email,course,year,gender,pin) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps =
                    con.prepareStatement(
                            sql,
                            Statement.RETURN_GENERATED_KEYS
                    );
            ps.setString(1,
                    txtName.getText());
            ps.setString(2,
                    txtEmail.getText());
            ps.setString(3,
                    cmbCourse.getSelectedItem()
                            .toString());
            ps.setString(4,
                    cmbYear.getSelectedItem()
                            .toString());
            ps.setString(
                    5,
                    male.isSelected()
                            ? "Male"
                            : "Female"
            );
            ps.setString(
                    6,
                    new String(
                            txtPin.getPassword()
                    )
            );
            ps.executeUpdate();
            ResultSet rs =
                    ps.getGeneratedKeys();
            if(rs.next()) {
                lblID.setText(
                        "Student ID : "
                                + rs.getInt(1)
                );
            }
            JOptionPane.showMessageDialog(
                    this,
                    "Inserted Successfully"
            );
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void clearForm() {
        txtName.setText("");
        txtEmail.setText("");
        txtPin.setText("");
        lblID.setText("");
    }
    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}