package exp14.src;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.*;

public class StudentRecordsViewer extends JFrame {
    JTable table;
    DefaultTableModel model;
    JTextField txtSearch;
    JLabel lblStatus;
    TableRowSorter<DefaultTableModel> sorter;

    public StudentRecordsViewer() {
        setTitle("Student Records Viewer");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        txtSearch = new JTextField();
        topPanel.add(new JLabel(" Search Student : "), BorderLayout.WEST);
        topPanel.add(txtSearch, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Name", "Email", "Course", "Year", "Gender", "PIN"});
        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnRefresh = new JButton("Refresh");
        lblStatus = new JLabel("Records : 0");
        bottomPanel.add(btnRefresh, BorderLayout.WEST);
        bottomPanel.add(lblStatus, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        btnRefresh.addActionListener(e -> loadData());

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { search(); }
            public void removeUpdate(DocumentEvent e) { search(); }
            public void changedUpdate(DocumentEvent e) { search(); }
        });

        loadData();
        setVisible(true);
    }

    private void search() {
        String text = txtSearch.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
        }
        lblStatus.setText("Records : " + table.getRowCount());
    }

    private void loadData() {
        model.setRowCount(0);
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                lblStatus.setText("Connection Failed");
                return;
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getString("year"),
                    rs.getString("gender"),
                    rs.getString("pin")
                });
            }
            lblStatus.setText("Records : " + model.getRowCount());
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentRecordsViewer();
    }
}