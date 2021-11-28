package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.JDBC.ResultSetStreamer;
import fr.univ_amu.iut.JDBC.RowMappers.ConnexionUnique;
import fr.univ_amu.iut.JDBC.RowMappers.EtudiantMapper;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public final class DAOEtudiantJDBC implements DAOEtudiant {


    private Connection connection;


    public DAOEtudiantJDBC() {
       try{
           this.connection = ConnexionUnique.getInstance().getConnection();
       } catch (SQLException e){
           //
       }
    }


    @Override
    public int computeNbEtudiant() {
        return 0;
    }

    @Override
    public List<Etudiant> findByVille(String villeEt) {
        // La requete get all Etudiant by ville
        String reqEtudiantsAixois =
                "SELECT NUM_ET, NOM_ET, PRENOM_ET, CP_ET, VILLE_ET, ANNEE, GROUPE  " +
                        "FROM ETUDIANT " +
                        "WHERE VILLE_ET = '" + villeEt + "'";

        return ResultSetStreamer.stream(connection, reqEtudiantsAixois, new EtudiantMapper()).collect(Collectors.toList());
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        return null;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        return null;
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        return null;
    }

    @Override
    public boolean delete(Etudiant obj) {
        return false;
    }

    @Override
    public List<Etudiant> findAll() {
        return ResultSetStreamer.stream(connection, "SELECT * FROM ETUDIANT", new EtudiantMapper()).collect(Collectors.toList());
    }

    @Override
    public Etudiant getById(int id) {
        return null;
    }

    @Override
    public Etudiant insert(Etudiant obj) {
        return null;
    }

    @Override
    public boolean update(Etudiant obj) {
        return false;
    }
}
