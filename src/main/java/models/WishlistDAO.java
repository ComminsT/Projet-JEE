package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WishlistDAO {
	public void save(Wishlist a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE wishlist set id_produit=?,id_utilisateur=? WHERE id=?");
						preparedStatement.setInt(1,a.getId_produit());
						preparedStatement.setInt(2,a.getId_utilisateur());
						preparedStatement.setInt(3,a.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO wishlist (id_produit,id_utilisateur) VALUES(?,?)");
						preparedStatement.setInt(1,a.getId_produit());
						preparedStatement.setInt(2,a.getId_utilisateur());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Wishlist getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM wishlist WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Wishlist a = new Wishlist();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setId_produit(resultat.getInt( "id_produit" ));
						a.setId_utilisateur(resultat.getInt( "id_utilisateur" ));
						
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Wishlist> getAll() {
			ArrayList<Wishlist> list = new ArrayList<Wishlist>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM wishlist");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Wishlist a = new Wishlist();
						a.setId(resultat.getInt( "id" ));
						a.setId_produit(resultat.getInt( "id_produit" ));
						a.setId_utilisateur(resultat.getInt( "id_utilisateur" ));
						list.add(a);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		public ArrayList<Wishlist> getAllFromUser(int id) {
			ArrayList<Wishlist> list = new ArrayList<Wishlist>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM wishlist WHERE id_utilisateur=?");
					preparedStatement.setInt(1, id);
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Wishlist a = new Wishlist();
						a.setId(resultat.getInt( "id" ));
						a.setId_produit(resultat.getInt( "id_produit" ));
						a.setId_utilisateur(resultat.getInt( "id_utilisateur" ));
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
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM wishlist WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
