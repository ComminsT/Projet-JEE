package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AuteurDAO {
	public void save(Auteur a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE auteurs set nom=? WHERE id=?");
						preparedStatement.setString(1,a.getNom());
						preparedStatement.setInt(2,a.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO auteurs (nom) VALUES(?)");
						preparedStatement.setString(1,a.getNom());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Auteur getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM auteurs WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Auteur a = new Auteur();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setNom(resultat.getString("nom"));
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Auteur> getAll() {
			ArrayList<Auteur> list = new ArrayList<Auteur>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM auteurs");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Auteur a = new Auteur();
						a.setId(resultat.getInt( "id" ));
						a.setNom(resultat.getString( "nom" ));
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM auteurs WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}

		public Auteur getByName(String auteur) {
			try {
				
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM auteurs WHERE nom=?");
				preparedStatement.setString(1,auteur);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Auteur a = new Auteur();
				while(resultat.next()) {
					a.setId(resultat.getInt( "id" ));
					a.setNom(resultat.getString("nom"));
				}
				return a;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
}
