package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;
import fr.univ_amu.iut.JDBC.RowMappers.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExempleDAOEtudiant {


    public static void main(String[] args) {
        try {

            DAOEtudiant dao = new DAOEtudiantJDBC();

            List<Etudiant> etudiantList = new ArrayList<>();
            //Get all Etudiant
            etudiantList = dao.findAll();
            //Print Etudiants
            etudiantList.forEach(etudiant -> System.out.println(etudiant.toString()));

            System.out.println("=========================");

            List<Etudiant> etudiantListByVille = new ArrayList<>();
            //Get all Etudiant by Ville
            etudiantListByVille = dao.findByVille("AIX-EN-PROVENCE");
            //Print Etudiants
            etudiantListByVille.forEach(etudiant -> System.out.println(etudiant.toString()));



        } catch (Exception e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
