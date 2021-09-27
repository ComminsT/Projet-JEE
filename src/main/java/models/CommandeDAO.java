package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CommandeDAO {
	
	public void save(Commande c) {
		
			try {
				
				if(c.getId() != 0) {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commandes set reference=?,adresse=?,cp=?,complement=?,date_recu=?,date_expedition=?,livraison=?,montant=?,id_utilisateur=? WHERE id=?");
					preparedStatement.setInt(1,c.getReference());
					preparedStatement.setString(2,c.getAdresse());
					preparedStatement.setString(3,c.getCp());
					preparedStatement.setString(4,c.getComplement());
					preparedStatement.setString(5,c.getDate_recu());
					preparedStatement.setString(6,c.getDate_expedition());
					preparedStatement.setInt(7,c.getLivraison());
					preparedStatement.setDouble(8,c.getMontant());
					preparedStatement.setInt(9,c.getId_utilisateur());
					preparedStatement.setInt(10,c.getId());
					preparedStatement.executeUpdate();
				}else {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO commandes (reference,adresse,cp,complement,date_recu,date_expedition,livraison,montant,id_utilisateur) VALUES(?,?,?,?,?,?,?,?,?)");
					preparedStatement.setInt(1,c.getReference());
					preparedStatement.setString(2,c.getAdresse());
					preparedStatement.setString(3,c.getCp());
					preparedStatement.setString(4,c.getComplement());
					preparedStatement.setString(5,c.getDate_recu());
					preparedStatement.setString(6,c.getDate_expedition());
					preparedStatement.setInt(7,c.getLivraison());
					preparedStatement.setDouble(8,c.getMontant());
					preparedStatement.setInt(9,c.getId_utilisateur());
		            preparedStatement.executeUpdate();
				}
				System.out.println("SAVED OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("SAVED NO");
	        }
		
	}
	
	
	
	public Commande getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commandes WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Commande c = new Commande();
				while(resultat.next()) {
					c.setId(resultat.getInt( "id" ));
					c.setReference(resultat.getInt("reference"));
					c.setAdresse(resultat.getString( "adresse" ));
					c.setCp(resultat.getString("cp"));
					c.setComplement(resultat.getString("complement"));
					c.setDate_recu(resultat.getString("date_recu"));
					c.setDate_expedition(resultat.getString("date_expedition"));
					c.setLivraison(resultat.getInt("livraison"));
					c.setMontant(resultat.getDouble("montant"));
					c.setId_utilisateur(resultat.getInt("id_utilisateur"));
				}
				return c;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	
	public ArrayList<Commande> getAll() {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commandes");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Commande c = new Commande();
					c.setId(resultat.getInt( "id" ));
					c.setReference(resultat.getInt("reference"));
					c.setAdresse(resultat.getString( "adresse" ));
					c.setCp(resultat.getString("cp"));
					c.setComplement(resultat.getString("complement"));
					c.setDate_recu(resultat.getString("date_recu"));
					c.setDate_expedition(resultat.getString("date_expedition"));
					c.setLivraison(resultat.getInt("livraison"));
					c.setMontant(resultat.getDouble("montant"));
					c.setId_utilisateur(resultat.getInt("id_utilisateur"));
					list.add(c);
				}
				
				
				return list;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM commandes WHERE id=?");
				preparedStatement.setInt(1,id);
				preparedStatement.executeUpdate();
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
}
