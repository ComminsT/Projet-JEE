package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdresseDAO {
	public void save(Adresse a) {
		
				try {
					
					if(a.getId() != 0) { 
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE adresses set nom=?,adresse=?,cp=?,complement=?,id_utilisateur=? WHERE id=?");
						preparedStatement.setString(1,a.getNom());
						preparedStatement.setString(2,a.getAdresse());
						preparedStatement.setString(3,a.getCp());
						preparedStatement.setString(4,a.getComplement());
						preparedStatement.setInt(5,a.getId_utilisateur());
						preparedStatement.setInt(6,a.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO adresses (nom,adresse,cp,complement,id_utilisateur) VALUES(?,?,?,?,?)");
						preparedStatement.setString(1,a.getNom());
						preparedStatement.setString(2,a.getAdresse());
						preparedStatement.setString(3,a.getCp());
						preparedStatement.setString(4,a.getComplement());
						preparedStatement.setInt(5,a.getId_utilisateur());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Adresse getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM adresses WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Adresse a = new Adresse();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setNom(resultat.getString("nom"));
						a.setAdresse(resultat.getString("adresse"));
						a.setCp(resultat.getString("cp"));
						a.setComplement(resultat.getString("complement"));
						a.setId_utilisateur(resultat.getInt("id_utilisateur"));
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Adresse> getAll() {
			ArrayList<Adresse> list = new ArrayList<Adresse>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM adresses");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Adresse a = new Adresse();
						a.setId(resultat.getInt( "id" ));
						a.setNom(resultat.getString("nom"));
						a.setAdresse(resultat.getString("adresse"));
						a.setCp(resultat.getString("cp"));
						a.setComplement(resultat.getString("complement"));
						a.setId_utilisateur(resultat.getInt("id_utilisateur"));
						list.add(a);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		public ArrayList<Adresse> getAllFromUser(int id) {
			ArrayList<Adresse> list = new ArrayList<Adresse>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM adresses WHERE id_utilisateur=?");
					preparedStatement.setInt(1, id);
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Adresse a = new Adresse();
						a.setId(resultat.getInt( "id" ));
						a.setNom(resultat.getString("nom"));
						a.setAdresse(resultat.getString("adresse"));
						a.setCp(resultat.getString("cp"));
						a.setComplement(resultat.getString("complement"));
						a.setId_utilisateur(resultat.getInt("id_utilisateur"));
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM adresses WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
