package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc

import fr.univ_amu.iut.JDBC.RowMappers.ConnexionUnique;
import fr.univ_amu.iut.JDBC.RowMappers.ModuleMapper;
import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExempleAsso1 {
    // La requete de test
    private static final String reqAsso1 =
            "SELECT NUM_PROF, NOM_PROF, PRENOM_PROF, ADR_PROF, CP_PROF, VILLE_PROF, MAT_SPEC " +
                    "FROM PROF ";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base nedseb_gestionpedabd
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement statement = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + reqAsso1);

            ResultSet resultSet = statement.executeQuery(reqAsso1);
            List<Prof> profList = new ArrayList<>();
            // Affichage du resultat
            while (resultSet.next()) {
                Module module = new Module();
                module.setCode(resultSet.getString("MAT_SPEC"));

                Prof prof = new Prof();
                prof.setNumProf(resultSet.getInt("NUM_PROF"));
                prof.setNomProf(resultSet.getString("NOM_PROF"));
                prof.setPrenomProf(resultSet.getString("PRENOM_PROF"));
                prof.setAdrProf(resultSet.getString("ADR_PROF"));
                prof.setCpProf(resultSet.getString("CP_PROF"));
                prof.setVilleProf(resultSet.getString("VILLE_PROF"));
                prof.setMatSpec(module);

                profList.add(prof);

            }
            profList.forEach(prof -> System.out.println(prof.toString()));

            // Fermeture de l'instruction (liberation des ressources)
            statement.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
