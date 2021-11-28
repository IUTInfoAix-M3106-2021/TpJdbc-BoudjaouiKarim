package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOProf;
import fr.univ_amu.iut.JDBC.ResultSetStreamer;
import fr.univ_amu.iut.JDBC.RowMappers.ConnexionUnique;
import fr.univ_amu.iut.JDBC.RowMappers.ProfMapper;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public final class DAOProfJDBC implements DAOProf {


    private Connection connection;


    public DAOProfJDBC() {
       try{
           this.connection = ConnexionUnique.getInstance().getConnection();
       } catch (SQLException e){
           //
       }
    }


    @Override
    public List<Prof> findByNom(String nom) {
        return null;
    }

    @Override
    public List<Prof> findMatSpec(Module matSpec) {
        return null;
    }

    @Override
    public int computeNbProf() {
        return 0;
    }


    @Override
    public boolean delete(Prof obj) {
        return false;
    }

    @Override
    public List<Prof> findAll() {
        return ResultSetStreamer.stream(connection, "SELECT * FROM PROF", new ProfMapper()).collect(Collectors.toList());
    }

    @Override
    public Prof getById(int id) {
        return null;
    }

    @Override
    public Prof insert(Prof obj) {
        return null;
    }

    @Override
    public boolean update(Prof obj) {
        return false;
    }

}
