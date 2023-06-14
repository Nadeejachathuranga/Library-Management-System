package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbconnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/layerd_library?useSSL=false", "root", "1234");

    }
    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (null == dbconnection) ? new DBConnection() : dbconnection;
    }
    public Connection getConnection(){
        return connection;

    }
}
