package fr.univ_amu.iut.JDBC.RowMappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
   private Connection connection;
   private static ConnexionUnique instance;

    static final String CONNECT_URL = "jdbc:mysql://mysql-boudjaoui.alwaysdata.net:3306/boudjaoui_bd";
    static final String LOGIN = "boudjaoui";
    static final String PASSWORD = "Ctw8m7z13?";

    public static ConnexionUnique getInstance() throws SQLException {
        if(instance == null)
            instance = new ConnexionUnique();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private ConnexionUnique() throws SQLException {
        connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
    }


}
