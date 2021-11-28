package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc

import fr.univ_amu.iut.JDBC.RowMappers.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExempleEntite {
    // La requete de test
    private static final String reqEtudiantsAixois =
            "SELECT NUM_ET, NOM_ET, PRENOM_ET, CP_ET, VILLE_ET, ANNEE, GROUPE  " +
                    "FROM ETUDIANT " +
                    "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base nedseb_gestionpedabd
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement statement = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + reqEtudiantsAixois);

            ResultSet resultSet = statement.executeQuery(reqEtudiantsAixois);
            List<Etudiant> etudiantList = new ArrayList<>();
            // Affichage du resultat
            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(resultSet.getInt("NUM_ET"));
                etudiant.setNomEt(resultSet.getString("NOM_ET"));
                etudiant.setPrenomEt(resultSet.getString("PRENOM_ET"));
                etudiant.setCpEt(resultSet.getString("CP_ET"));
                etudiant.setVilleEt(resultSet.getString("VILLE_ET"));
                etudiant.setAnnee(resultSet.getInt("ANNEE"));
                etudiant.setGroupe(resultSet.getInt("GROUPE"));

                etudiantList.add(etudiant);

            }
            etudiantList.forEach(etudiant -> System.out.println(etudiant.toString()));

            // Fermeture de l'instruction (liberation des ressources)
            statement.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
