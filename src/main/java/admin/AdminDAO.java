package admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Database;

public class AdminDAO {
	public void save(Admin a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE admins set identifiant=?,mdp=? WHERE id=?");
						preparedStatement.setString(1,a.getIdentifiant());
						preparedStatement.setString(2,a.getMdp());
						preparedStatement.setInt(3,a.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO admins (identifiant,mdp) VALUES(?,?)");
						preparedStatement.setString(1,a.getIdentifiant());
						preparedStatement.setString(2,a.getMdp());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Admin getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM admins WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Admin a = new Admin();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setIdentifiant(resultat.getString( "identifiant" ));
						a.setMdp(resultat.getString( "mdp" ));
						
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Admin> getAll() {
			ArrayList<Admin> list = new ArrayList<Admin>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM admins");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Admin a = new Admin();
						a.setId(resultat.getInt( "id" ));
						a.setIdentifiant(resultat.getString( "identifiant" ));
						a.setMdp(resultat.getString( "mdp" ));
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM admins WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
