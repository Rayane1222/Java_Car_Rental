package java_car_rental.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    private static final String dbName = "db/data.db"; // SQLite database file name

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            
            // Set the journal mode to WAL
            Statement statement = connection.createStatement();
            statement.executeUpdate("PRAGMA journal_mode=WAL;");
            statement.close();
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle exceptions
        }
        return connection;
    }
}
