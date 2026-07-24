package assignmentjava.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class FacultyManagementSystem extends JFrame {
    private static final String URL = "jdbc:mysql://localhost:3306/university_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";
    JTextField txtId, txtName, txtDept, txtEmail, txtSalary;
    JButton btnAdd, btnUpdate, btnDelete, btnClear;
    JTable table;
    DefaultTableModel model;

    public FacultyManagementSystem() {
        setTitle("Faculty Management System");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Faculty Details"));
        formPanel.add(new JLabel("Faculty ID (Auto)"));
        txtId = new JTextField();
        formPanel.add(txtId);
        formPanel.add(new JLabel("Faculty Name"));
        txtName = new JTextField();
        formPanel.add(txtName);
        formPanel.add(new JLabel("Department"));
        txtDept = new JTextField();
        formPanel.add(txtDept);
        formPanel.add(new JLabel("Email"));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);
        formPanel.add(new JLabel("Salary"));
        txtSalary = new JTextField();
        formPanel.add(txtSalary);
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        btnAdd = new JButton("ADD");
        btnUpdate = new JButton("UPDATE");
        btnDelete = new JButton("DELETE");
        btnClear = new JButton("CLEAR");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(formPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("DEPARTMENT");
        model.addColumn("EMAIL");
        model.addColumn("SALARY");
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        mainPanel.add(pane, BorderLayout.CENTER);
        add(mainPanel);
        Color bgColor = new Color(240, 240, 240);
        mainPanel.setBackground(bgColor);
        formPanel.setBackground(bgColor);
        leftPanel.setBackground(bgColor);
        buttonPanel.setBackground(bgColor);
        txtId.setEditable(false);
        JTextField[] fields = {
                txtId, txtName, txtDept, txtEmail, txtSalary
        };
        for (JTextField field : fields) {
            field.setFont(new Font("Arial", Font.PLAIN, 14));
        }
        for (Component c : formPanel.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(new Font("Arial", Font.BOLD, 14));
                c.setForeground(new Color(44, 62, 80));
            }
        }
        btnAdd.setBackground(new Color(38, 194, 129));
        btnAdd.setForeground(Color.WHITE);
        btnUpdate.setBackground(new Color(44, 62, 80));
        btnUpdate.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(231, 76, 60));
        btnDelete.setForeground(Color.WHITE);
        btnClear.setBackground(new Color(127, 140, 141));
        btnClear.setForeground(Color.WHITE);
        JButton[] buttons = {
                btnAdd, btnUpdate, btnDelete, btnClear
        };

        for (JButton btn : buttons) {
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
        }
        table.setRowHeight(35);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setBackground(Color.WHITE);
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(52, 152, 219));
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBackground(new Color(44, 62, 80));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setDefaultRenderer(
                new javax.swing.table.DefaultTableCellRenderer() {
                    {
                        setHorizontalAlignment(JLabel.CENTER);
                        setBackground(new Color(44, 62, 80));
                        setForeground(Color.WHITE);
                        setFont(new Font("Arial", Font.BOLD, 14));
                        setOpaque(true);
                    }

                    
                    public Component getTableCellRendererComponent(
                            JTable table,
                            Object value,
                            boolean isSelected,
                            boolean hasFocus,
                            int row,
                            int column) {
                        super.getTableCellRendererComponent(
                                table, value, isSelected,
                                hasFocus, row, column);
                        setBackground(new Color(44, 62, 80));
                        setForeground(Color.WHITE);
                        return this;
                    }
                });
        pane.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)),
                "Faculty Details"));
        btnAdd.addActionListener(e -> addFaculty());
        btnUpdate.addActionListener(e -> updateFaculty());
        btnDelete.addActionListener(e -> deleteFaculty());
        btnClear.addActionListener(e -> clearFields());
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                txtId.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row, 1).toString());
                txtDept.setText(model.getValueAt(row, 2).toString());
                txtEmail.setText(model.getValueAt(row, 3).toString());
                txtSalary.setText(model.getValueAt(row, 4).toString());
            }
        });
        loadFacultyData();
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed : " + e.getMessage());
        }
        return con;
    }

    public void loadFacultyData() {
        model.setRowCount(0);
        try {
            Connection con = getConnection();
            String query = "SELECT * FROM faculty";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                });
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Loading Data : " + e.getMessage());
        }
    }

    public void addFaculty() {
        if (!validateForm()) {
            return;
        }
        try {
            Connection con = getConnection();
            String query = "INSERT INTO faculty(name, department, email, salary) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, txtName.getText());
            pst.setString(2, txtDept.getText());
            pst.setString(3, txtEmail.getText());
            pst.setDouble(4, Double.parseDouble(txtSalary.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Faculty Added Successfully");
            con.close();
            loadFacultyData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Insert Error : " + e.getMessage());
        }
    }

    public void updateFaculty() {
        if (!validateForm()) {
            return;
        }
        try {
            Connection con = getConnection();
            String query = "UPDATE faculty SET name=?, department=?, email=?, salary=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, txtName.getText());
            pst.setString(2, txtDept.getText());
            pst.setString(3, txtEmail.getText());
            pst.setDouble(4, Double.parseDouble(txtSalary.getText()));
            pst.setInt(5, Integer.parseInt(txtId.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Faculty Updated Successfully");
            con.close();
            loadFacultyData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update Error : " + e.getMessage());
        }
    }

    public void deleteFaculty() {
        try {
            Connection con = getConnection();
            String query = "DELETE FROM faculty WHERE id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(txtId.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Faculty Deleted Successfully");
            con.close();
            loadFacultyData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Delete Error : " + e.getMessage());
        }
    }

    public boolean validateForm() {
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is Required");
            txtName.requestFocus();
            return false;
        }
        if (txtDept.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Department is Required");
            txtDept.requestFocus();
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email is Required");
            txtEmail.requestFocus();
            return false;
        }
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!txtEmail.getText().matches(emailPattern)) {
            JOptionPane.showMessageDialog(this, "Enter Valid Email");
            txtEmail.requestFocus();
            return false;
        }
        if (txtSalary.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Salary is Required");
            txtSalary.requestFocus();
            return false;
        }
        try {
            Double.parseDouble(txtSalary.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Salary must be Numeric");
            txtSalary.requestFocus();
            return false;
        }
        return true;
    }

    public void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtDept.setText("");
        txtEmail.setText("");
        txtSalary.setText("");
        table.clearSelection();
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(() -> {
            new FacultyManagementSystem().setVisible(true);
        });
    }
}