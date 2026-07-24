package exp14.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentDeleteForm extends JFrame {

    JTable table;

    DefaultTableModel model;

    JLabel lblCount;

    public StudentDeleteForm() {

        setTitle("Student Delete Form");

        setSize(900,500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        model =
                new DefaultTableModel();

        model.setColumnIdentifiers(
                new String[]{
                        "ID",
                        "Name",
                        "Email",
                        "Course",
                        "Year",
                        "Gender",
                        "PIN"
                }
        );

        table =
                new JTable(model);

        JScrollPane sp =
                new JScrollPane(table);

        add(sp,
                BorderLayout.CENTER);

        JPanel panel =
                new JPanel();

        JButton btnDelete =
                new JButton("Delete");

        JButton btnRefresh =
                new JButton("Refresh");

        lblCount =
                new JLabel();

        panel.add(btnDelete);
        panel.add(btnRefresh);
        panel.add(lblCount);

        add(panel,
                BorderLayout.SOUTH);

        btnDelete.addActionListener(
                e -> deleteStudent()
        );

        btnRefresh.addActionListener(
                e -> loadStudents()
        );

        loadStudents();

        setVisible(true);
    }

    private void loadStudents() {

        model.setRowCount(0);

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM students"
                    );

            while(rs.next()) {

                model.addRow(
                        new Object[]{
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("course"),
                                rs.getString("year"),
                                rs.getString("gender"),
                                rs.getString("pin")
                        }
                );
            }

            lblCount.setText(
                    "Records : "
                            + model.getRowCount()
            );

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    private void deleteStudent() {

        int row =
                table.getSelectedRow();

        if(row==-1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a record first"
            );

            return;
        }

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete selected student?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );

        if(confirm
                != JOptionPane.YES_OPTION) {

            return;
        }

        try {

            int id =
                    Integer.parseInt(
                            model.getValueAt(
                                    row,
                                    0
                            ).toString()
                    );

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "DELETE FROM students WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,id);

            int result =
                    ps.executeUpdate();

            if(result>0) {

                model.removeRow(row);

                lblCount.setText(
                        "Records : "
                                + model.getRowCount()
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Deleted Successfully"
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new StudentDeleteForm();
    }
}