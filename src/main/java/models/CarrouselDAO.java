package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarrouselDAO {
	public void save(Carrousel c) {
		
				try {
					
					if(c.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE carrousel set place=?,img=?,id_produit=? WHERE id=?");
						preparedStatement.setInt(1,c.getPlace());
						preparedStatement.setString(2,c.getImg());
						preparedStatement.setInt(3,c.getId_produit());
						preparedStatement.setInt(4,c.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO carrousel (place,img,id_produit) VALUES(?,?,?)");
						preparedStatement.setInt(1,c.getPlace());
						preparedStatement.setString(2,c.getImg());
						preparedStatement.setInt(3,c.getId_produit());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Carrousel getById(int id) {
			try {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM carrousel WHERE id=?");
					preparedStatement.setInt(1,id);
					ResultSet resultat=preparedStatement.executeQuery();
					Carrousel c = new Carrousel();
					while(resultat.next()) {
						c.setId(resultat.getInt( "id" ));
						c.setPlace(resultat.getInt("place"));
						c.setImg(resultat.getString("img"));
						c.setId_produit(resultat.getInt("id_produit"));
					}
					return c;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Carrousel> getAll() {
			ArrayList<Carrousel> list = new ArrayList<Carrousel>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM carrousel");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Carrousel c = new Carrousel();
						c.setId(resultat.getInt( "id" ));
						c.setPlace(resultat.getInt("place"));
						c.setImg(resultat.getString("img"));
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM carrousel WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
