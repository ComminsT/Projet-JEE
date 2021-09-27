package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UtilisateurDAO {
	public void save(Utilisateur a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE utilisateurs set nom=?,email=?,mdp=?,fidelite=?,telephone=? WHERE id=?");
						preparedStatement.setString(1,a.getNom());
						preparedStatement.setString(2,a.getEmail());
						preparedStatement.setString(3,a.getMdp());
						preparedStatement.setInt(4,a.getFidelite());
						preparedStatement.setString(5,a.getTel());
						preparedStatement.setInt(6,a.getId());
						
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO utilisateurs (nom,email,mdp,fidelite,telephone) VALUES(?,?,?,?,?)");
						preparedStatement.setString(1,a.getNom());
						preparedStatement.setString(2,a.getEmail());
						preparedStatement.setString(3,a.getMdp());
						preparedStatement.setInt(4,a.getFidelite());
						preparedStatement.setString(5,a.getTel());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Utilisateur getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM utilisateurs WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Utilisateur a = new Utilisateur();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setNom(resultat.getString("nom"));
						a.setEmail(resultat.getString("email"));	
						a.setMdp(resultat.getString("mdp"));	
						a.setFidelite(resultat.getInt("fidelite"));	
						a.setTel(resultat.getString("telephone"));	
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Utilisateur> getAll() {
			ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM utilisateurs");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Utilisateur a = new Utilisateur();
						a.setId(resultat.getInt( "id" ));
						a.setNom(resultat.getString("nom"));
						a.setEmail(resultat.getString("email"));	
						a.setMdp(resultat.getString("mdp"));	
						a.setFidelite(resultat.getInt("fidelite"));	
						a.setTel(resultat.getString("telephone"));	
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM utilisateurs WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}

		public Utilisateur connexion(String email,String password) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.
						prepareStatement("SELECT * FROM utilisateurs WHERE email=? AND mdp=?");
				preparedStatement.setString(1,email);
				preparedStatement.setString(2,password);
				ResultSet resultat=preparedStatement.executeQuery();
				Utilisateur a = new Utilisateur();
				if(resultat.next()) {
					a.setId(resultat.getInt( "id" ));
					a.setNom(resultat.getString("nom"));
					a.setEmail(resultat.getString("email"));	
					a.setMdp(resultat.getString("mdp"));	
					a.setFidelite(resultat.getInt("fidelite"));	
					a.setTel(resultat.getString("telephone"));	
					return a;
				}else {
					return null;
				}
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
		public Boolean mailcheck (String email) {
			try {
				
				PreparedStatement preparedStatement  = Database.connexion.
				prepareStatement("SELECT * FROM utilisateurs WHERE email=?");
				preparedStatement.setString(1,email);
				ResultSet resultat=preparedStatement.executeQuery();
				Utilisateur a = new Utilisateur();
				if(resultat.next()) {
					return false;
				}else {
					return true;
				}
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
}
}
