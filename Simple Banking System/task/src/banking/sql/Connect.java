package banking.sql;

import java.sql.*;

public class Connect {

    static Connection conn = null;
    /**
     * Connect to a sample database
     */
    public static void connect(String db) {
        try {
            // db parameters
            String url = "jdbc:sqlite:" + db;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createNewTable() {

        // SQL statement for creating a new table
        String sql = """
                CREATE TABLE IF NOT EXISTS card (
                	id INTEGER,
                	number TEXT,
                	pin TEXT,
                	balance INTEGER NOT NULL
                );""";

        try {
             Statement stmt = conn.createStatement();
            // create a new table
            stmt.execute(sql);
            System.out.println("suc");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert(int id, String number, String pin, int balance) {
        String sql = "INSERT INTO card VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, number);
            pstmt.setString(3, pin);
            pstmt.setInt(4, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
