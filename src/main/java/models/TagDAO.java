package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TagDAO {
	public void save(Tag a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE tag set titre=? WHERE id=?");
						preparedStatement.setString(1,a.getTitre());
						
						preparedStatement.setInt(2,a.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO tag (titre) VALUES(?)");
						preparedStatement.setString(1,a.getTitre());
						
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Tag getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM tag WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Tag a = new Tag();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setTitre(resultat.getString("titre"));
						
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Tag> getAll() {
			ArrayList<Tag> list = new ArrayList<Tag>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM tag");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Tag a = new Tag();
						a.setId(resultat.getInt( "id" ));
						a.setTitre(resultat.getString("titre"));	
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM tag WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}

		public Tag getByName(String tag) {
			try {
				
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM tag WHERE titre=?");
				preparedStatement.setString(1,tag);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Tag a = new Tag();
				while(resultat.next()) {
					a.setId(resultat.getInt( "id" ));
					a.setTitre(resultat.getString("titre"));
				}
				return a;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
}
