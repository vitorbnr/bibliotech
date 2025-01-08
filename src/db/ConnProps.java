package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnProps {

        private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
        private static final String USUARIO = "root";
        private static final String SENHA = "admin";

        public static Connection getConnection() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver JDBC não encontrado.", e);
            }
        }
    }
