package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String url = "jdbc:oracle:thin:@10.99.2.45:1521:xe";
    private static final String user = "cwi";
    private static final String pass = "cwi";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
