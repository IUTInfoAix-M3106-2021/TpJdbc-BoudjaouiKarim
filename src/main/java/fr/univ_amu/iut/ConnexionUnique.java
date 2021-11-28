package fr.univ_amu.iut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance;

    // Chaine de connexion
    static final String CONNECT_URL = "jdbc:mysql://mysql-boudjaoui.alwaysdata.net:3306/Gestion Pedagogique";
    static final String LOGIN = "boudjaoui";
    static final String PASSWORD = "Ctw8m7z13?";

    private ConnexionUnique() throws SQLException{
        this.connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnexionUnique getInstance() throws SQLException{
        if (instance == null)
            instance = new ConnexionUnique();
        return instance;
    }
}
