package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetourDAO {
	public void save(Retour a) {

		try {

			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion
						.prepareStatement("UPDATE retour set date=?,suivi=?,id_commande=?,id_produit=? WHERE id=?");
				preparedStatement.setString(1, a.getDate());
				preparedStatement.setString(2, a.getSuivi());
				preparedStatement.setInt(3, a.getId_commande());
				preparedStatement.setInt(4, a.getId_produit());
				preparedStatement.setInt(5, a.getId());

				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion
						.prepareStatement("INSERT INTO retour (date,suivi,id_commande,id_produit) VALUES(?,?,?,?)");
				preparedStatement.setString(1, a.getDate());
				preparedStatement.setString(2, a.getSuivi());
				preparedStatement.setInt(3, a.getId_commande());
				preparedStatement.setInt(4, a.getId_produit());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Retour getById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM retour WHERE id=?");
			preparedStatement.setInt(1, id);

			ResultSet resultat = preparedStatement.executeQuery();

			Retour a = new Retour();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setDate(resultat.getString("date"));
				a.setSuivi(resultat.getString("suivi"));
				a.setId_commande(resultat.getInt("id_commande"));
				a.setId_produit(resultat.getInt("id_produit"));
				

			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Retour> getAll() {
		ArrayList<Retour> list = new ArrayList<Retour>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM retour");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Retour a = new Retour();
				a.setId(resultat.getInt("id"));
				a.setDate(resultat.getString("date"));
				a.setSuivi(resultat.getString("suivi"));
				a.setId_commande(resultat.getInt("id_commande"));
				a.setId_produit(resultat.getInt("id_produit"));
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
					.prepareStatement("DELETE FROM retour WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
