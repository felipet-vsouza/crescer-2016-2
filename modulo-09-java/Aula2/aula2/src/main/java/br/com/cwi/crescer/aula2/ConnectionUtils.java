package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "SYSTEM";
    private static final String pass = "lipinh71";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
