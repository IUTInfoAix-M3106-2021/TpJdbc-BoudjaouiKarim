package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.JDBC.ResultSetStreamer;
import fr.univ_amu.iut.JDBC.RowMappers.ConnexionUnique;
import fr.univ_amu.iut.JDBC.RowMappers.ModuleMapper;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public final class DAOModuleJDBC implements DAOModule {


    private Connection connection;


    public DAOModuleJDBC() {
       try{
           this.connection = ConnexionUnique.getInstance().getConnection();
       } catch (SQLException e){
           //
       }
    }



    @Override
    public boolean delete(Module obj) {
        return false;
    }

    @Override
    public List<Module> findAll() {
        return ResultSetStreamer.stream(connection, "SELECT * FROM MODULE", new ModuleMapper()).collect(Collectors.toList());
    }


    @Override
    public Module getById(int id) {
        return null;
    }


    @Override
    public Module insert(Module obj) {
        return null;
    }

    @Override
    public boolean update(Module obj) {
        return false;
    }


    @Override
    public List<Module> findByLibelle(String libelle) {
        return null;
    }

    @Override
    public List<Module> findByDiscipline(String discipline) {
        return null;
    }

    @Override
    public List<Module> findByResponsable(Prof Responsable) {
        return null;
    }
}
