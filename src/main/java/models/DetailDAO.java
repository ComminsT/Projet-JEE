package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DetailDAO {
	
	public void save(Detail d) {
		
			try {
				
				if(d.getId() != 0) {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE details set quantite=?,prixu=?,id_commande=?,id_produit=? WHERE id=?");
					preparedStatement.setInt(1,d.getQuantite());
					preparedStatement.setDouble(2,d.getPrixu());
					preparedStatement.setInt(3,d.getId_commande());
					preparedStatement.setInt(4,d.getId_produit());
					preparedStatement.setInt(5,d.getId());
		            preparedStatement.executeUpdate();
				}else {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO details (quantite,prixu,id_commande,id_produit) VALUES(?,?,?,?)");
					preparedStatement.setInt(1,d.getQuantite());
					preparedStatement.setDouble(2,d.getPrixu());
					preparedStatement.setInt(3,d.getId_commande());
					preparedStatement.setInt(4,d.getId_produit());
		            preparedStatement.executeUpdate();
				}
				System.out.println("SAVED OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("SAVED NO");
	        }
		
	}
	public Detail getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM details WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Detail d = new Detail();
				while(resultat.next()) {
					d.setId(resultat.getInt( "id" ));
					d.setQuantite(resultat.getInt("quantite"));
					d.setPrixu(resultat.getDouble( "prixu" ));
					d.setId_commande(resultat.getInt("id_commande"));
					d.setId_produit(resultat.getInt("id_produit"));
					
				}
				return d;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	
	public ArrayList<Detail> getAll() {
		ArrayList<Detail> list = new ArrayList<Detail>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM details");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Detail d = new Detail();
					d.setId(resultat.getInt( "id" ));
					d.setQuantite(resultat.getInt("quantite"));
					d.setPrixu(resultat.getDouble( "prixu" ));
					d.setId_commande(resultat.getInt("id_commande"));
					d.setId_produit(resultat.getInt("id_produit"));
					list.add(d);
				}
				
				
				return list;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM details WHERE id=?");
				preparedStatement.setInt(1,id);
				
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
}
