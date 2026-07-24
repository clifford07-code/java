package exp14.src;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/college?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    private static URLClassLoader driverLoader;

    public static Connection getConnection() {
        try {
            ensureDriverLoaded();
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Database connection failed:\n" + ex,
                    "Connection Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private static void ensureDriverLoaded() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            loadDriverJar();
        }
    }

    private static void loadDriverJar() throws Exception {
        String[] jarPaths = {
                "exp14/lib/mysql-connector-j-9.7.0.jar",
                "lib/mysql-connector-j-9.7.0.jar",
                "mysql-connector-j-9.7.0.jar"
        };

        for (String jarPath : jarPaths) {
            Path path = Paths.get(jarPath);
            if (Files.exists(path)) {
                URL url = path.toUri().toURL();
                driverLoader = new URLClassLoader(new URL[] { url }, DBConnection.class.getClassLoader());
                Class.forName("com.mysql.cj.jdbc.Driver", true, driverLoader);
                return;
            }
        }

        throw new ClassNotFoundException(
                "MySQL JDBC driver not found. Add the connector jar to the classpath or place it under exp14/lib.");
    }
}