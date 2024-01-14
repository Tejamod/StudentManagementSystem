package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static Connection getCon() {
      // Connecting to the database
        String url = "database_url";
        try {
          // Making a connection object
            Connection con = DriverManager.getConnection(url, "user", "password");
            return con;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
