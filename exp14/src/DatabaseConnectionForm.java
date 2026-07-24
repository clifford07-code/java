package exp14.src;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionForm extends JFrame {

    JTextField txtHost;
    JTextField txtPort;
    JTextField txtDB;

    JComboBox<String> cmbDBType;

    JPasswordField txtPassword;

    JTextField txtURL;

    JLabel lblStatus;

    JButton btnConnect;

    public DatabaseConnectionForm() {

        setTitle("Database Connection");

        setSize(500,400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8,2,10,10));

        txtHost = new JTextField("localhost");
        txtPort = new JTextField("3306");
        txtDB = new JTextField("college");

        txtPassword = new JPasswordField();

        txtURL = new JTextField();
        txtURL.setEditable(false);

        cmbDBType = new JComboBox<>(
                new String[]{
                        "MySQL",
                        "PostgreSQL",
                        "SQLite"
                });

        btnConnect = new JButton("Connect");

        lblStatus = new JLabel("Not Connected");

        add(new JLabel("Host"));
        add(txtHost);

        add(new JLabel("Port"));
        add(txtPort);

        add(new JLabel("Database"));
        add(txtDB);

        add(new JLabel("Database Type"));
        add(cmbDBType);

        add(new JLabel("Password"));
        add(txtPassword);

        add(new JLabel("JDBC URL"));
        add(txtURL);

        add(btnConnect);
        add(lblStatus);

        updateURL();

        DocumentListener listener =
                new DocumentListener() {

                    public void insertUpdate(
                            DocumentEvent e) {
                        updateURL();
                    }

                    public void removeUpdate(
                            DocumentEvent e) {
                        updateURL();
                    }

                    public void changedUpdate(
                            DocumentEvent e) {
                        updateURL();
                    }
                };

        txtHost.getDocument()
                .addDocumentListener(listener);

        txtPort.getDocument()
                .addDocumentListener(listener);

        txtDB.getDocument()
                .addDocumentListener(listener);

        btnConnect.addActionListener(e -> connectDB());

        setVisible(true);
    }

    private void updateURL() {

        String url =
                "jdbc:mysql://"
                        + txtHost.getText()
                        + ":"
                        + txtPort.getText()
                        + "/"
                        + txtDB.getText();

        txtURL.setText(url);
    }

    private void connectDB() {

        try {

            Connection con =
                    DriverManager.getConnection(
                            txtURL.getText(),
                            "root",
                            new String(
                                    txtPassword.getPassword()
                            )
                    );

            lblStatus.setText(
                    "Connection Successful"
            );

            lblStatus.setForeground(
                    Color.GREEN
            );

            con.close();

        } catch (Exception ex) {

            lblStatus.setText(
                    "Connection Failed"
            );

            lblStatus.setForeground(
                    Color.RED
            );
        }
    }

    public static void main(String[] args) {

        new DatabaseConnectionForm();
    }
}