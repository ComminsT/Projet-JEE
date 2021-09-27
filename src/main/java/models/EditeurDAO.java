package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditeurDAO {
	public void save(Editeur e) {
		
				try {
					
					if(e.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE editeurs set nom=? WHERE id=?");
						preparedStatement.setString(1,e.getNom());
						preparedStatement.setInt(2,e.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO editeurs (nom) VALUES(?)");
						preparedStatement.setString(1,e.getNom());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Editeur getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM editeurs WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Editeur e = new Editeur();
					while(resultat.next()) {
						e.setId(resultat.getInt( "id" ));
						e.setNom(resultat.getString("nom"));
					}
					return e;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Editeur> getAll() {
			ArrayList<Editeur> list = new ArrayList<Editeur>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM editeurs");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Editeur e = new Editeur();
						e.setId(resultat.getInt( "id" ));
						e.setNom(resultat.getString( "nom" ));
						list.add(e);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		public void deleteById(int id) {
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM editeurs WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}

		public Editeur getByName(String nom) {
			try {
				
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM editeurs WHERE nom=?");
				preparedStatement.setString(1,nom);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Editeur e = new Editeur();
				while(resultat.next()) {
					e.setId(resultat.getInt( "id" ));
					e.setNom(resultat.getString("nom"));
				}
				return e;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
			
}
