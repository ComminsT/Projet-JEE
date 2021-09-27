package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PromotionDAO {
	public void save(Promotion a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE promotion set date_debut=?,date_fin=?,taux=?,id_produit=? WHERE id=?");
						preparedStatement.setString(1,a.getDate_debut());
						preparedStatement.setString(2,a.getDate_fin());
						preparedStatement.setInt(3,a.getTaux());
						preparedStatement.setInt(4,a.getId_produit());
						preparedStatement.setInt(5,a.getId());
						
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO promotion (date_debut,date_fin,taux,id_produit) VALUES(?,?,?,?)");
						preparedStatement.setString(1,a.getDate_debut());
						preparedStatement.setString(2,a.getDate_fin());
						preparedStatement.setInt(3,a.getTaux());
						preparedStatement.setInt(4,a.getId_produit());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Promotion getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM promotion WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Promotion a = new Promotion();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setDate_debut(resultat.getString("date_debut"));
						a.setDate_fin(resultat.getString("date_fin"));
						a.setTaux(resultat.getInt("taux"));
						a.setId_produit(resultat.getInt("id_produit"));
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Promotion> getAll() {
			ArrayList<Promotion> list = new ArrayList<Promotion>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM promotion");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Promotion a = new Promotion();
						a.setId(resultat.getInt( "id" ));
						a.setDate_debut(resultat.getString("date_debut"));
						a.setDate_fin(resultat.getString("date_fin"));
						a.setTaux(resultat.getInt("taux"));
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM promotion WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
