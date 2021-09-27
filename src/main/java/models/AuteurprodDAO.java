package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AuteurprodDAO {
	public void save(Auteurprod a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE auteursprod set id_auteur=?,id_produit=? WHERE id=?");
						preparedStatement.setInt(1,a.getId_auteur());
						preparedStatement.setInt(2,a.getId_produit());
						preparedStatement.setInt(3,a.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO auteursprod (id_auteur,id_produit) VALUES(?,?)");
						preparedStatement.setInt(1,a.getId_auteur());
						preparedStatement.setInt(2,a.getId_produit());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Auteurprod getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM auteursprod WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Auteurprod a = new Auteurprod();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setId_auteur(resultat.getInt("id_auteur"));
						a.setId_produit(resultat.getInt("id_produit"));
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Auteurprod> getAll() {
			ArrayList<Auteurprod> list = new ArrayList<Auteurprod>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM auteursprod");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Auteurprod a = new Auteurprod();
						a.setId(resultat.getInt( "id" ));
						a.setId_auteur(resultat.getInt("id_auteur"));
						a.setId_produit(resultat.getInt("id_produit"));
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM auteursprod WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
