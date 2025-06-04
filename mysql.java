import java.sql.*;

public class mysql {
    Connection c;
    Statement s;

    public mysql() {
        try {
            // Load MySQL JDBC Driver (optional in modern Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the "atm" database on localhost
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/atm", "root", "Kejal@sql123"
            );

            // Create statement
            s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e);
        }
    }
}
