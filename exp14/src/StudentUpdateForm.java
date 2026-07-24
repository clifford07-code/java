package exp14.src;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentUpdateForm extends JFrame {

    JTextField txtID;
    JTextField txtName;
    JTextField txtEmail;
    JTextField txtCourse;

    JButton btnFetch;
    JButton btnUpdate;

    public StudentUpdateForm() {

        setTitle("Student Update Form");

        setSize(500,350);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(6,2,10,10));

        txtID = new JTextField();

        txtName = new JTextField();

        txtEmail = new JTextField();

        txtCourse = new JTextField();

        btnFetch =
                new JButton("Fetch");

        btnUpdate =
                new JButton("Update");

        add(new JLabel("Student ID"));
        add(txtID);

        add(btnFetch);
        add(new JLabel());

        add(new JLabel("Name"));
        add(txtName);

        add(new JLabel("Email"));
        add(txtEmail);

        add(new JLabel("Course"));
        add(txtCourse);

        add(btnUpdate);

        btnFetch.addActionListener(
                e -> fetchStudent()
        );

        btnUpdate.addActionListener(
                e -> updateStudent()
        );

        setVisible(true);
    }

    private void fetchStudent() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(
                    1,
                    Integer.parseInt(
                            txtID.getText()
                    )
            );

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                txtName.setText(
                        rs.getString("name")
                );

                txtEmail.setText(
                        rs.getString("email")
                );

                txtCourse.setText(
                        rs.getString("course")
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student Not Found"
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    private void updateStudent() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE students SET name=?, email=?, course=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(
                    1,
                    txtName.getText()
            );

            ps.setString(
                    2,
                    txtEmail.getText()
            );

            ps.setString(
                    3,
                    txtCourse.getText()
            );

            ps.setInt(
                    4,
                    Integer.parseInt(
                            txtID.getText()
                    )
            );

            int rows =
                    ps.executeUpdate();

            if(rows>0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student Updated Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Update Failed"
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new StudentUpdateForm();
    }
}
