package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CommentaireDAO {
	
	public void save(Commentaire c) {
		
			try {
				
				if(c.getId() != 0) {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commentaires set commentaire=?,date=?,id_utilisateur=?,id_produit=? WHERE id=?");
					preparedStatement.setString(1,c.getCommentaire());
					preparedStatement.setString(2,c.getDate());
					preparedStatement.setInt(3,c.getId_utilisateur());
					preparedStatement.setInt(4,c.getId_produit());
					preparedStatement.setInt(5,c.getId());
		            preparedStatement.executeUpdate();
				}else {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO commentaires (commentaire,date,id_utilisateur,id_produit) VALUES(?,?,?,?)");
					preparedStatement.setString(1,c.getCommentaire());
					preparedStatement.setString(2,c.getDate());
					preparedStatement.setInt(3,c.getId_utilisateur());
					preparedStatement.setInt(4,c.getId_produit());
		            preparedStatement.executeUpdate();
				}
				System.out.println("SAVED OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("SAVED NO");
	        }
		
	}
	
	
	
	public Commentaire getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaires WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Commentaire c = new Commentaire();
				while(resultat.next()) {
					c.setId(resultat.getInt( "id" ));
					c.setCommentaire(resultat.getString("commentaire"));
					c.setDate(resultat.getString( "date" ));
					c.setId_utilisateur(resultat.getInt("id_utilisateur"));
					c.setId_produit(resultat.getInt("id_produit"));
					
				}
				return c;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	
	public ArrayList<Commentaire> getAll() {
		ArrayList<Commentaire> list = new ArrayList<Commentaire>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaires");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Commentaire c = new Commentaire();
					c.setId(resultat.getInt( "id" ));
					c.setCommentaire(resultat.getString("commentaire"));
					c.setDate(resultat.getString( "date" ));
					c.setId_utilisateur(resultat.getInt("id_utilisateur"));
					c.setId_produit(resultat.getInt("id_produit"));
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
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM commentaires WHERE id=?");
				preparedStatement.setInt(1,id);
				
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
}
