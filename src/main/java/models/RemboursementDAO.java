package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RemboursementDAO {
	public void save(Remboursement a) {

		try {

			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion
						.prepareStatement("UPDATE remboursement set montant=?,date=?,id_retour=? WHERE id=?");
				preparedStatement.setDouble(1, a.getMontant());
				preparedStatement.setString(2, a.getDate());
				preparedStatement.setInt(3, a.getId_retour());
				preparedStatement.setInt(4, a.getId());

				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion
						.prepareStatement("INSERT INTO remboursement (montant,date,id_retour) VALUES(?,?,?)");
				preparedStatement.setDouble(1, a.getMontant());
				preparedStatement.setString(2, a.getDate());
				preparedStatement.setInt(3, a.getId_retour());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Remboursement getById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM remboursement WHERE id=?");
			preparedStatement.setInt(1, id);

			ResultSet resultat = preparedStatement.executeQuery();

			Remboursement a = new Remboursement();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setMontant(resultat.getDouble("montant"));
				a.setDate(resultat.getString("date"));
				a.setId_retour(resultat.getInt("id_retour"));

			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Remboursement> getAll() {
		ArrayList<Remboursement> list = new ArrayList<Remboursement>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM remboursement");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Remboursement a = new Remboursement();
				a.setId(resultat.getInt("id"));
				a.setMontant(resultat.getDouble("montant"));
				a.setDate(resultat.getString("date"));
				a.setId_retour(resultat.getInt("id_retour"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void deleteById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("DELETE FROM remboursement WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
